package com.pensatocode.example.resources;

import com.google.zxing.WriterException;
import com.pensatocode.totp.db.UserRepository;
import com.pensatocode.totp.services.qrcode.QRCodeGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserResource.class);

    private static final String IMAGE_PNG = "image/png";

    private final UserRepository userRepository;
    private final QRCodeGenerator qrCodeGenerator;

    public UserResource(UserRepository userRepository, QRCodeGenerator qrCodeGenerator) {
        this.userRepository = userRepository;
        this.qrCodeGenerator = qrCodeGenerator;
        LOGGER.info("############## UserResource Constructor ##############");
    }

    @GET
    @Path("/{username}")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response showUser(@PathParam("username") String username) {
        LOGGER.info("############## showUser: " + username);
        var user = userRepository.findByUsername(username);
        if(user.isEmpty()) {
            LOGGER.warn("############## User not found: " + username);
            throw new NotFoundException("User not found");
        }
        return Response.status(200).entity(user.toString()).build();
    }

    @GET
    @Path("/qrcode/{username}")
    @Produces(IMAGE_PNG)
    @Consumes(MediaType.APPLICATION_JSON)
    public byte[] generateQRCode(@PathParam("username") String username) {
        var user = userRepository.findByUsername(username);
        if(user.isEmpty()) {
            LOGGER.warn("############## User not found: " + username);
            throw new NotFoundException("User not found");
        }

        try {
            return qrCodeGenerator.generateQRCode(user.get().getCredentials());
        } catch (WriterException e) {
            LOGGER.warn("############## WriteException: " + e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            LOGGER.warn("############## IOException: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

}

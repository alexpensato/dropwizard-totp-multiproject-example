package com.pensatocode.example.resources;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/my-ip")
@Produces(MediaType.APPLICATION_JSON)
public class LoopbackResource {

    private final int defaultSize;

    public LoopbackResource(int defaultSize) {
        this.defaultSize = defaultSize;
    }

    @GET
    @Path("/")
    public Response ask(@Context HttpServletRequest request) {
        final String ip = request.getRemoteAddr();
        return Response.ok(ip).build();
    }
}

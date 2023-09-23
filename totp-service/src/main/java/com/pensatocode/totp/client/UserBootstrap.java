package com.pensatocode.totp.client;

import com.pensatocode.totp.model.Credential;
import com.pensatocode.totp.model.PersonalData;
import com.pensatocode.totp.model.User;
import com.pensatocode.totp.services.SecretKeyGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public final class UserBootstrap {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserBootstrap.class);

    private UserBootstrap() {
        // Nothing to do
    }

    public static List<User> initUsers(SecretKeyGenerator secretKeyGenerator) {
        var users = new java.util.ArrayList<User>();
        var personalData1 = new PersonalData("Alex Pensato", "alex.pensato@example.com");
        var username1 = "alex";
        var secretKey1 = secretKeyGenerator.generateSecretKey(username1);
        var credentials1 = new Credential(username1, secretKey1);
        var user1 = new User(1L, personalData1, credentials1);
        LOGGER.info(String.format("############## Bootstrapping: %s", user1));
        users.add(user1);
        var personalData2 = new PersonalData("Jane Doe", "jane.doe@example.com");
        var username2 = "janedoe";
        var secretKey2 = secretKeyGenerator.generateSecretKey(username2);
        var credentials2 = new Credential(username2, secretKey2);
        var user2 = new User(2L, personalData2, credentials2);
        LOGGER.info(String.format("############## Bootstrapping: %s", user2));
        users.add(user2);
        var personalData3 = new PersonalData("Mark Smith", "mark.smith@example.com");
        var username3 = "mrsmith";
        var secretKey3 = secretKeyGenerator.generateSecretKey(username3);
        var credentials3 = new Credential(username3, secretKey3);
        var user3 = new User(3L, personalData3, credentials3);
        LOGGER.info(String.format("############## Bootstrapping: %s", user3));
        users.add(user3);
        return users;
    }
}

package com.pensatocode.totp.services;

import com.pensatocode.totp.db.UserRepository;
import com.warrenstrange.googleauth.*;
import com.warrenstrange.googleauth.GoogleAuthenticatorConfig.GoogleAuthenticatorConfigBuilder;


public class SecretKeyGenerator {

    private final GoogleAuthenticator gAuth;

    private final UserRepository userRepository;

    public SecretKeyGenerator(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.gAuth = gAuth();
    }

    public GoogleAuthenticator gAuth() {
        GoogleAuthenticatorConfig config = getGoogleAuthenticatorConfig();
        GoogleAuthenticator googleAuthenticator = new GoogleAuthenticator(config);
        googleAuthenticator.setCredentialRepository(userRepository);
        return googleAuthenticator;
    }

    private GoogleAuthenticatorConfig getGoogleAuthenticatorConfig() {
        GoogleAuthenticatorConfigBuilder configBuilder = new GoogleAuthenticatorConfigBuilder();
        configBuilder.setTimeStepSizeInMillis(30_000);
        configBuilder.setWindowSize(3);
        configBuilder.setCodeDigits(6);
        configBuilder.setNumberOfScratchCodes(0); // default is 5
        configBuilder.setSecretBits(256); // default is 80
        configBuilder.setKeyRepresentation(KeyRepresentation.BASE32);
        configBuilder.setHmacHashFunction(HmacHashFunction.HmacSHA256); // default is HmacSHA1
        return configBuilder.build();
    }

    public GoogleAuthenticatorKey generateSecretKey(String username) {
        return gAuth.createCredentials(username);
    }

}

package com.pensatocode.totp.model;

import com.warrenstrange.googleauth.GoogleAuthenticatorKey;

import java.util.Arrays;

public class Credential {
    private String username;
    private GoogleAuthenticatorKey secretKey;

    public Credential(String username, GoogleAuthenticatorKey secretKey) {
        this.username = username;
        this.secretKey = secretKey;
    }

    // getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public GoogleAuthenticatorKey getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(GoogleAuthenticatorKey secretKey) {
        this.secretKey = secretKey;
    }

    @Override
    public String toString() {
        return "Credentials{" +
                "username='" + username + '\'' +
                ", algorithm='" + secretKey.getConfig().getHmacHashFunction().name() + '\'' +
                ", secret_key='" + secretKey.getKey() + '\'' +
                ", verification_code='" + secretKey.getVerificationCode() + '\'' +
                ", scratch_codes='" + Arrays.toString(secretKey.getScratchCodes().toArray()) + '\'' +
                '}';
    }

}

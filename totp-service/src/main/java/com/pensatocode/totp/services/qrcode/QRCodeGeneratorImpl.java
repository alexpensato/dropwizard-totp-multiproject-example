package com.pensatocode.totp.services.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.pensatocode.totp.model.Credential;
import com.warrenstrange.googleauth.GoogleAuthenticatorQRGenerator;

import java.io.ByteArrayOutputStream;
import java.io.IOException;


public class QRCodeGeneratorImpl implements QRCodeGenerator {

    private static final int IMAGE_SIZE = 200;
    private static final String IMAGE_FORMAT = "PNG";
    private static final String ISSUER_NAME = "PensatoCode";

    public byte[] generateQRCode(Credential credentials) throws WriterException, IOException {
        //I've decided to generate QRCode on backend site
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        String otpAuthURL = GoogleAuthenticatorQRGenerator.getOtpAuthTotpURL(
                ISSUER_NAME, credentials.getUsername(), credentials.getSecretKey());

        BitMatrix bitMatrix = qrCodeWriter.encode(otpAuthURL, BarcodeFormat.QR_CODE, IMAGE_SIZE, IMAGE_SIZE);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, IMAGE_FORMAT, outputStream);
        outputStream.close();
        return outputStream.toByteArray();
    }

}

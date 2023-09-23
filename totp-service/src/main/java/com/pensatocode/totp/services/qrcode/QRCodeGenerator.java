package com.pensatocode.totp.services.qrcode;

import com.google.zxing.WriterException;
import com.pensatocode.totp.model.Credential;

import java.io.IOException;

public interface QRCodeGenerator {

    byte[] generateQRCode(Credential credentials) throws WriterException, IOException;
}

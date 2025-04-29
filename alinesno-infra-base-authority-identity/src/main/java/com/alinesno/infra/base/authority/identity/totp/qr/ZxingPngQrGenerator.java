package com.alinesno.infra.base.authority.identity.totp.qr;

import com.alinesno.infra.base.authority.identity.totp.exceptions.QrGenerationException;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import lombok.Data;

import java.io.ByteArrayOutputStream;

@Data
public class ZxingPngQrGenerator implements QrGenerator {

    private final Writer writer;
    private int imageSize = 350;

    public ZxingPngQrGenerator() {
        this(new QRCodeWriter());
    }

    public ZxingPngQrGenerator(Writer writer) {
        this.writer = writer;
    }

    public String getImageMimeType() {
        return "image/png";
    }

    @Override
    public byte[] generate(QrData data) throws QrGenerationException {
        try {
            BitMatrix bitMatrix = writer.encode(data.getUri(), BarcodeFormat.QR_CODE, imageSize, imageSize);
            ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);

            return pngOutputStream.toByteArray();
        } catch (Exception e) {
            throw new QrGenerationException("Failed to generate QR code. See nested exception.", e);
        }
    }
}

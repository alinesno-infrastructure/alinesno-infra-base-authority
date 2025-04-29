package com.alinesno.infra.base.authority.identity.totp.qr;

import com.alinesno.infra.base.authority.identity.totp.code.HashingAlgorithm;
import lombok.Data;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@SuppressWarnings("WeakerAccess")
@Data
public class QrData {

    private final String type;
    private final String label;
    private final String secret;
    private final String issuer;
    private final String algorithm;
    private final int digits;
    private final int period;

    /**
     * Force use of builder to create instances.
     */
    private QrData(String type, String label, String secret, String issuer, String algorithm, int digits, int period) {
        this.type = type;
        this.label = label;
        this.secret = secret;
        this.issuer = issuer;
        this.algorithm = algorithm;
        this.digits = digits;
        this.period = period;
    }


    /**
     * @return The URI/message to encode into the QR image, in the format specified here:
     * https://github.com/google/google-authenticator/wiki/Key-Uri-Format
     */
    public String getUri() {
        return "otpauth://" +
                uriEncode(type) + "/" +
                uriEncode(label) + "?" +
                "secret=" + uriEncode(secret) +
                "&issuer=" + uriEncode(issuer) +
                "&algorithm=" + uriEncode(algorithm) +
                "&digits=" + digits +
                "&period=" + period;
    }

    private String uriEncode(String text)  {
        // Null check
        if (text == null) {
            return "";
        }

        return URLEncoder.encode(text, StandardCharsets.UTF_8).replaceAll("\\+", "%20");
    }

    @Data
    public static class Builder {
        private String label;
        private String secret;
        private String issuer;
        private HashingAlgorithm algorithm = HashingAlgorithm.SHA1;
        private int digits = 6;
        private int period = 30;

        public Builder label(String label) {
            this.label = label;
            return this;
        }

        public Builder secret(String secret) {
            this.secret = secret;
            return this;
        }

        public Builder issuer(String issuer) {
            this.issuer = issuer;
            return this;
        }

        public Builder algorithm(HashingAlgorithm algorithm) {
            this.algorithm = algorithm;
            return this;
        }

        public Builder digits(int digits) {
            this.digits = digits;
            return this;
        }

        public Builder period(int period) {
            this.period = period;
            return this;
        }

        public QrData build() {
            return new QrData("totp", label, secret, issuer, algorithm.getFriendlyName(), digits, period);
        }
    }
}

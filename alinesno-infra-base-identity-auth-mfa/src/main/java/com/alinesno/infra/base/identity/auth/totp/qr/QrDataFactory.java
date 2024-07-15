package com.alinesno.infra.base.identity.auth.totp.qr;


import com.alinesno.infra.base.identity.auth.totp.code.HashingAlgorithm;

public class QrDataFactory {

    private HashingAlgorithm defaultAlgorithm;
    private int defaultDigits;
    private int defaultTimePeriod;

    public QrDataFactory(HashingAlgorithm defaultAlgorithm, int defaultDigits, int defaultTimePeriod) {
        this.defaultAlgorithm = defaultAlgorithm;
        this.defaultDigits = defaultDigits;
        this.defaultTimePeriod = defaultTimePeriod;
    }

    public QrData.Builder newBuilder() {
        return new QrData.Builder()
            .algorithm(defaultAlgorithm)
            .digits(defaultDigits)
            .period(defaultTimePeriod);
    }
}

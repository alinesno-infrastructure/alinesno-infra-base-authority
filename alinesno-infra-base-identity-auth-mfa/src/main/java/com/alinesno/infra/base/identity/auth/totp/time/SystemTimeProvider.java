package com.alinesno.infra.base.identity.auth.totp.time;

import com.alinesno.infra.base.identity.auth.totp.exceptions.TimeProviderException;

import java.time.Instant;

public class SystemTimeProvider implements TimeProvider {
    @Override
    public long getTime() throws TimeProviderException {
        return Instant.now().getEpochSecond();
    }
}

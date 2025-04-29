package com.alinesno.infra.base.authority.identity.totp.time;

import com.alinesno.infra.base.authority.identity.totp.exceptions.TimeProviderException;

import java.time.Instant;

public class SystemTimeProvider implements TimeProvider {
    @Override
    public long getTime() throws TimeProviderException {
        return Instant.now().getEpochSecond();
    }
}

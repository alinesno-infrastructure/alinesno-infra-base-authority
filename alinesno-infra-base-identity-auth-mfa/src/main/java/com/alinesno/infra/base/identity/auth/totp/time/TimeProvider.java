package com.alinesno.infra.base.identity.auth.totp.time;


import com.alinesno.infra.base.identity.auth.totp.exceptions.TimeProviderException;

public interface TimeProvider {
    /**
     * @return The number of seconds since Jan 1st 1970, 00:00:00 UTC.
     */
    long getTime() throws TimeProviderException;
}

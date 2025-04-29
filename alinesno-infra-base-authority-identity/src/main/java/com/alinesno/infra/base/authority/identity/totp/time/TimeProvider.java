package com.alinesno.infra.base.authority.identity.totp.time;


import com.alinesno.infra.base.authority.identity.totp.exceptions.TimeProviderException;

public interface TimeProvider {
    /**
     * @return The number of seconds since Jan 1st 1970, 00:00:00 UTC.
     */
    long getTime() throws TimeProviderException;
}

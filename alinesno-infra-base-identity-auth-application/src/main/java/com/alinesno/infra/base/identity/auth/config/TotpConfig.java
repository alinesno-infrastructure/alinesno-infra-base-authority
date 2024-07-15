package com.alinesno.infra.base.identity.auth.config;

import com.alinesno.infra.base.identity.auth.totp.code.HashingAlgorithm;
import com.alinesno.infra.base.identity.auth.totp.time.NtpTimeProvider;
import com.alinesno.infra.base.identity.auth.totp.time.TimeProvider;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TotpConfig {

    @Bean
    public HashingAlgorithm hashingAlgorithm() {
        return HashingAlgorithm.SHA256;
    }

    @SneakyThrows
    @Bean
    public TimeProvider timeProvider() {
        return new NtpTimeProvider("pool.ntp.org");
    }

}

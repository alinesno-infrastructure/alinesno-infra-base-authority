package com.alinesno.infra.base.authority.identity.event;

import com.alinesno.infra.base.authority.identity.domain.dto.AuthWebLogDto;
import lombok.Getter;

@Getter
public class AuthWebLogEvent extends BaseEvent {

    private final AuthWebLogDto loginEvent ;

    public AuthWebLogEvent(AuthWebLogDto loginEvent) {
        super(loginEvent);
        this.loginEvent = loginEvent;
    }

}
package com.alinesno.infra.base.authority.identity.event;

import com.alinesno.infra.base.authority.identity.domain.LoginEventEntity;
import lombok.Getter;

@Getter
public class LoginTypeEvent extends BaseEvent {

    private final LoginEventEntity loginEvent ;

    public LoginTypeEvent(LoginEventEntity loginEvent) {
        super(loginEvent);
        this.loginEvent = loginEvent;
    }

}
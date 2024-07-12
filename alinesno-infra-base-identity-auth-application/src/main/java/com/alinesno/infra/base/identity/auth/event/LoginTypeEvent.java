package com.alinesno.infra.base.identity.auth.event;

import com.alinesno.infra.base.identity.auth.domain.LoginEventEntity;
import lombok.Getter;

@Getter
public class LoginTypeEvent extends BaseEvent {

    private final LoginEventEntity loginEvent ;

    public LoginTypeEvent(LoginEventEntity loginEvent) {
        super(loginEvent);
        this.loginEvent = loginEvent;
    }

}
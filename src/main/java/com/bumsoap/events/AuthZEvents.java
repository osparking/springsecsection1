package com.bumsoap.events;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.security.authorization.event.AuthorizationDeniedEvent;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AuthZEvents {

    @EventListener
    public void onFailure(AuthorizationDeniedEvent deniedEvent) {
        log.info("권한 부여가 거절된 유저 이름: {}, 부족한 권한: {}",
                deniedEvent.getAuthentication().get().getName(),
                deniedEvent.getAuthorizationDecision().toString());
    }
}

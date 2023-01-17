package com.yesid.rpgcharacter.aop;

import com.yesid.rpgcharacter.aop.exception.SessionExpiredException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Aspect
@Component
public class SecuredHttpRequestAspect {

    private final List<String> expiredSessions = Collections.singletonList("123");

    @Before(value = "@annotation(com.yesid.rpgcharacter.aop.annotation.Secured)")
    public void evaluateHttpRequest(JoinPoint joinPoint) {
        String authorization = (String) joinPoint.getArgs()[0];
        checkSessionExpiration(authorization);
    }

    private void checkSessionExpiration(String auth) {
        if (expiredSessions.contains(auth)) {
            throw new SessionExpiredException("Sesión expirada");
        }
    }
}

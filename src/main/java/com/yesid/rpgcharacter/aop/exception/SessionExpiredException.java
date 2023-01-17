package com.yesid.rpgcharacter.aop.exception;

public class SessionExpiredException extends RuntimeException {

    private static final long serialVersionUID = 7059898230456755595L;

    public SessionExpiredException(String message) {
        super(message);
    }
}

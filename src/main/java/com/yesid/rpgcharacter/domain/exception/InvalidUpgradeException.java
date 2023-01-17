package com.yesid.rpgcharacter.domain.exception;

public class InvalidUpgradeException extends RuntimeException {

    private static final long serialVersionUID = -4287546994817455103L;

    public InvalidUpgradeException(String message) {
        super(message);
    }
}

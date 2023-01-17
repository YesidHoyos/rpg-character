package com.yesid.rpgcharacter.domain.exception;

public class InvalidCharacterException extends RuntimeException {

    private static final long serialVersionUID = -7064154938936314443L;

    public InvalidCharacterException(String message) {
        super(message);
    }
}

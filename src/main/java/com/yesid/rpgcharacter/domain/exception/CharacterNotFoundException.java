package com.yesid.rpgcharacter.domain.exception;

public class CharacterNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 7291484916478908008L;

    public CharacterNotFoundException(String message) {
        super(message);
    }
}

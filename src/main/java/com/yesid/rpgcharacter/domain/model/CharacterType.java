package com.yesid.rpgcharacter.domain.model;

import com.yesid.rpgcharacter.domain.exception.InvalidCharacterException;

public enum CharacterType {
    WARRIOR("warrior"),
    HEALER("healer");

    public final String label;

    CharacterType(String label) {
        this.label = label;
    }

    public static CharacterType valueOfLabel(String label) {
        for (CharacterType characterType : values()) {
            if (characterType.label.equals(label)) {
                return characterType;
            }
        }
        throw new InvalidCharacterException("clase no valida");
    }
}

package com.yesid.rpgcharacter.domain.factory;

import com.yesid.rpgcharacter.domain.exception.InvalidCharacterException;
import com.yesid.rpgcharacter.domain.model.CharacterType;
import org.springframework.stereotype.Component;

@Component
public class CharacterFactoryContext {

    private final WarriorCharacterFactory warriorCharacterFactory;
    private final HealerCharacterFactory healerCharacterFactory;

    public CharacterFactoryContext(WarriorCharacterFactory warriorCharacterFactory, HealerCharacterFactory healerCharacterFactory) {
        this.warriorCharacterFactory = warriorCharacterFactory;
        this.healerCharacterFactory = healerCharacterFactory;
    }

    public CharacterFactory getCharacterFactory(CharacterType characterType) {
        switch (characterType) {
            case WARRIOR:
                return warriorCharacterFactory;
            case HEALER:
                return healerCharacterFactory;
            default:
                throw new InvalidCharacterException("clase no valida");
        }
    }
}

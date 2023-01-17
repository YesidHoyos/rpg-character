package com.yesid.rpgcharacter.domain.factory;

import com.yesid.rpgcharacter.config.prototype.CharacterPrototypeCreator;
import com.yesid.rpgcharacter.domain.model.Character;
import com.yesid.rpgcharacter.domain.model.CharacterType;
import org.springframework.stereotype.Component;

@Component
public class WarriorCharacterFactory extends CharacterFactory {

    private final CharacterPrototypeCreator characterPrototypeCreator;

    public WarriorCharacterFactory(CharacterPrototypeCreator characterPrototypeCreator) {
        this.characterPrototypeCreator = characterPrototypeCreator;
    }

    @Override
    public Character buildCharacter() {
        return characterPrototypeCreator.getCharacterPrototypes().get(CharacterType.WARRIOR).clone();
    }
}

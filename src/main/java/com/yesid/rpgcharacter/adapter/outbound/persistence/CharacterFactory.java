package com.yesid.rpgcharacter.adapter.outbound.persistence;

import com.yesid.rpgcharacter.adapter.outbound.persistence.entity.CharacterEntity;
import com.yesid.rpgcharacter.domain.exception.InvalidCharacterException;
import com.yesid.rpgcharacter.domain.model.Character;
import com.yesid.rpgcharacter.domain.model.CharacterType;
import com.yesid.rpgcharacter.domain.model.Healer;
import com.yesid.rpgcharacter.domain.model.Warrior;

public class CharacterFactory {

    private CharacterFactory(){}

    public static Character getCharacter(CharacterEntity characterEntity) {
        switch (characterEntity.getCharacterType()) {
            case WARRIOR:
                return Warrior.builder()
                        .nickname(characterEntity.getNickname())
                        .mount(characterEntity.getMount())
                        .attackPower(characterEntity.getAttackPower())
                        .defensePower(characterEntity.getDefensePower())
                        .level(characterEntity.getLevel())
                        .skinColor(characterEntity.getSkinColor())
                        .gender(characterEntity.getGender())
                        .hairStyle(characterEntity.getHairStyle())
                        .hairColor(characterEntity.getHairColor())
                        .build();
            case HEALER:
                return Healer.builder()
                        .nickname(characterEntity.getNickname())
                        .pet(characterEntity.getPet())
                        .attackPower(characterEntity.getAttackPower())
                        .defensePower(characterEntity.getDefensePower())
                        .level(characterEntity.getLevel())
                        .skinColor(characterEntity.getSkinColor())
                        .gender(characterEntity.getGender())
                        .hairStyle(characterEntity.getHairStyle())
                        .hairColor(characterEntity.getHairColor())
                        .build();
            default:
                throw new InvalidCharacterException("clase no valida");
        }
    }

    public static CharacterEntity getEntity(Character character) {
        CharacterEntity characterEntity = CharacterEntity.builder()
                .nickname(character.getNickname())
                .attackPower(character.getAttackPower())
                .defensePower(character.getDefensePower())
                .level(character.getLevel())
                .skinColor(character.getSkinColor())
                .gender(character.getGender())
                .hairStyle(character.getHairStyle())
                .hairColor(character.getHairColor())
                .build();
        if (character instanceof Warrior) {
            characterEntity.setCharacterType(CharacterType.WARRIOR);
            characterEntity.setMount(((Warrior) character).getMount());
        } else {
            characterEntity.setCharacterType(CharacterType.HEALER);
            characterEntity.setPet(((Healer) character).getPet());
        }
        return characterEntity;
    }
}

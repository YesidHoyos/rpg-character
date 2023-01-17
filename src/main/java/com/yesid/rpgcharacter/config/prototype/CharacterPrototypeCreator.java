package com.yesid.rpgcharacter.config.prototype;

import com.yesid.rpgcharacter.domain.model.Character;
import com.yesid.rpgcharacter.domain.model.CharacterType;
import com.yesid.rpgcharacter.domain.model.Healer;
import com.yesid.rpgcharacter.domain.model.Warrior;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.EnumMap;

@Component
@Getter
public class CharacterPrototypeCreator {

    private final EnumMap<CharacterType, Character> characterPrototypes;

    public CharacterPrototypeCreator() {
        this.characterPrototypes = new EnumMap<> (CharacterType.class);
        Character warrior = Warrior.builder()
                .mount("Caballo")
                .attackPower(10)
                .defensePower(10)
                .level(1)
                .skinColor("piel")
                .gender("M")
                .hairStyle("cabello-corto")
                .hairColor("negro")
                .build();
        this.characterPrototypes.put(CharacterType.WARRIOR, warrior);
        Character healer = Healer.builder()
                .pet("Conejo")
                .attackPower(10)
                .defensePower(6)
                .level(1)
                .skinColor("piel")
                .gender("F")
                .hairStyle("cabello-largo")
                .hairColor("rubio")
                .build();
        this.characterPrototypes.put(CharacterType.HEALER, healer);
    }
}

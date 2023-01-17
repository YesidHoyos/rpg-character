package com.yesid.rpgcharacter.adaper.outbound.it.persistence;

import com.yesid.rpgcharacter.RpgCharacterApplication;
import com.yesid.rpgcharacter.adapter.outbound.persistence.CharacterRepository;
import com.yesid.rpgcharacter.domain.exception.CharacterNotFoundException;
import com.yesid.rpgcharacter.domain.model.Character;
import com.yesid.rpgcharacter.domain.model.Healer;
import com.yesid.rpgcharacter.domain.model.Warrior;
import com.yesid.rpgcharacter.domain.usecase.mother.CharacterMother;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = RpgCharacterApplication.class)
class CharacterRepositoryIT {

    private static final String WARRIOR_NICKNAME = "ferho";
    private static final String HEALER_NICKNAME = "ferho1";
    private static final String WRONG_NICKNAME = "wrong";

    @Autowired
    private CharacterRepository characterRepository;

    @Test
    void givenCharacterWhenSaveThenWarriorIsSaved() {
        Warrior character = CharacterMother.getWarrior();
        character.setNickname(WARRIOR_NICKNAME);
        characterRepository.save(character);
        Character characterSaved = characterRepository.getByNickname(WARRIOR_NICKNAME);
        Assertions.assertEquals(character, characterSaved);
    }

    @Test
    void givenCharacterWhenSaveThenHealerIsSaved() {
        Healer character = CharacterMother.getHealer();
        character.setNickname(HEALER_NICKNAME);
        characterRepository.save(character);
        Character characterSaved = characterRepository.getByNickname(HEALER_NICKNAME);
        Assertions.assertEquals(character, characterSaved);
    }

    @Test
    void givenWrongNicknameWhenGetByNicknameThenCharacterNotFoundException() {
        Assertions.assertThrows(CharacterNotFoundException.class,
                () -> characterRepository.getByNickname(WRONG_NICKNAME), "El personaje no existe");
    }

}

package com.yesid.rpgcharacter.domain.factory;

import com.yesid.rpgcharacter.config.prototype.CharacterPrototypeCreator;
import com.yesid.rpgcharacter.domain.model.Character;
import com.yesid.rpgcharacter.domain.model.CharacterType;
import com.yesid.rpgcharacter.domain.model.Warrior;
import com.yesid.rpgcharacter.domain.usecase.mother.CharacterMother;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.EnumMap;

@ExtendWith(MockitoExtension.class)
class WarriorCharacterFactoryTest {

    @Mock
    private CharacterPrototypeCreator characterPrototypeCreator;
    @InjectMocks
    private WarriorCharacterFactory warriorCharacterFactory;

    @Test
    void WhenBuildCharacterThenReturnWarriorCharacter() {
        EnumMap<CharacterType, Character> characterPrototypes = new EnumMap<> (CharacterType.class);
        Character warrior = CharacterMother.getWarrior();
        characterPrototypes.put(CharacterType.WARRIOR, warrior);
        Mockito.when(characterPrototypeCreator.getCharacterPrototypes()).thenReturn(characterPrototypes);
        Character character = warriorCharacterFactory.buildCharacter();
        Assertions.assertEquals(warrior, character);
    }
}

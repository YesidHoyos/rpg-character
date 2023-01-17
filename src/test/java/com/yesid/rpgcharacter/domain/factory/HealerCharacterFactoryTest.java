package com.yesid.rpgcharacter.domain.factory;

import com.yesid.rpgcharacter.config.prototype.CharacterPrototypeCreator;
import com.yesid.rpgcharacter.domain.model.Character;
import com.yesid.rpgcharacter.domain.model.CharacterType;
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
class HealerCharacterFactoryTest {

    @Mock
    private CharacterPrototypeCreator characterPrototypeCreator;
    @InjectMocks
    private HealerCharacterFactory healerCharacterFactory;

    @Test
    void WhenBuildCharacterThenReturnHealerCharacter() {
        EnumMap<CharacterType, Character> characterPrototypes = new EnumMap<> (CharacterType.class);
        Character healer = CharacterMother.getHealer();
        characterPrototypes.put(CharacterType.HEALER, healer);
        Mockito.when(characterPrototypeCreator.getCharacterPrototypes()).thenReturn(characterPrototypes);
        Character character = healerCharacterFactory.buildCharacter();
        Assertions.assertEquals(healer, character);
    }
}

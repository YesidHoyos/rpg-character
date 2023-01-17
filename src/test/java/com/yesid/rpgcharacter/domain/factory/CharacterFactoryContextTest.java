package com.yesid.rpgcharacter.domain.factory;

import com.yesid.rpgcharacter.domain.exception.InvalidCharacterException;
import com.yesid.rpgcharacter.domain.model.CharacterType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CharacterFactoryContextTest {

    @Mock
    private WarriorCharacterFactory warriorCharacterFactory;
    @Mock
    private HealerCharacterFactory healerCharacterFactory;
    @InjectMocks
    private CharacterFactoryContext characterFactoryContext;

    @Test
    void givenCharacterTypeWhenGetCharacterFactoryThenReturnWarriorCharacterFactory() {
        CharacterFactory characterFactory = characterFactoryContext.getCharacterFactory(CharacterType.WARRIOR);
        Assertions.assertEquals(warriorCharacterFactory, characterFactory);
    }

    @Test
    void givenCharacterTypeWhenGetCharacterFactoryThenReturnHealerCharacterFactory() {
        CharacterFactory characterFactory = characterFactoryContext.getCharacterFactory(CharacterType.HEALER);
        Assertions.assertEquals(healerCharacterFactory, characterFactory);
    }

    @Test
    void givenCharacterTypeWhenGetCharacterFactoryThenInvalidCharacterException() {
        CharacterType characterType = CharacterType.valueOfLabel("invalid");
        Assertions.assertThrows(InvalidCharacterException.class,
                () -> characterFactoryContext.getCharacterFactory(characterType),
                "clase no valida");
    }
}

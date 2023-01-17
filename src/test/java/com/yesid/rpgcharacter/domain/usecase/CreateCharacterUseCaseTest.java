package com.yesid.rpgcharacter.domain.usecase;

import com.yesid.rpgcharacter.domain.factory.CharacterFactoryContext;
import com.yesid.rpgcharacter.domain.factory.WarriorCharacterFactory;
import com.yesid.rpgcharacter.domain.model.Character;
import com.yesid.rpgcharacter.domain.model.CharacterType;
import com.yesid.rpgcharacter.domain.observer.CharacterCreatedManager;
import com.yesid.rpgcharacter.domain.usecase.mother.CharacterMother;
import com.yesid.rpgcharacter.provider.CharacterRepositoryProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CreateCharacterUseCaseTest {

    private static final String NICKNAME = "ferho";

    @Mock
    private CharacterFactoryContext characterFactoryContext;
    @Mock
    private CharacterCreatedManager characterCreatedManager;
    @Mock
    private CharacterRepositoryProvider characterRepositoryProvider;
    @Mock
    private WarriorCharacterFactory warriorCharacterFactory;
    @InjectMocks
    private CreateCharacterUseCase createCharacterUseCase;

    @Test
    void givenCharacterTypeAndNickNameWhenCreateThenCharacterCreated() {
        Character warrior = CharacterMother.getWarrior();
        Character warriorSaved = warrior.clone();
        warriorSaved.setNickname(NICKNAME);

        Mockito.when(characterFactoryContext.getCharacterFactory(CharacterType.WARRIOR)).thenReturn(warriorCharacterFactory);
        Mockito.when(warriorCharacterFactory.buildCharacter()).thenReturn(warrior);
        Mockito.when(characterRepositoryProvider.save(warrior)).thenReturn(warriorSaved);
        Mockito.doNothing().when(characterCreatedManager).notify(warriorSaved);

        Character characterSaved = createCharacterUseCase.create(CharacterType.WARRIOR, NICKNAME);
        Assertions.assertNotNull(characterSaved);
        Assertions.assertEquals(warriorSaved, characterSaved);
    }
}

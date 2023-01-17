package com.yesid.rpgcharacter.domain.observer;

import com.yesid.rpgcharacter.domain.model.Character;
import com.yesid.rpgcharacter.domain.usecase.mother.CharacterMother;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CharacterCreatedManagerTest {

    @Mock
    private EmailNotificationListener emailNotificationListener;
    @Mock
    private ApiNotificationListener apiNotificationListener;
    @InjectMocks
    private CharacterCreatedManager characterCreatedManager;

    @Test
    void givenCharacterWhenNotifyThenOk() {
        Character character = CharacterMother.getWarrior();
        character.setNickname("ferho");
        Mockito.doNothing().when(apiNotificationListener).update(character);
        Mockito.doNothing().when(emailNotificationListener).update(character);
        characterCreatedManager.notify(character);
        Mockito.verify(apiNotificationListener, Mockito.times(1)).update(character);
        Mockito.verify(emailNotificationListener, Mockito.times(1)).update(character);
    }
}

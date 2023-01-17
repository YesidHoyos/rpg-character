package com.yesid.rpgcharacter.domain.observer;

import com.yesid.rpgcharacter.domain.model.Character;
import com.yesid.rpgcharacter.domain.usecase.mother.CharacterMother;
import com.yesid.rpgcharacter.provider.AccountManagementProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ApiNotificationListenerTest {

    @Mock
    private AccountManagementProvider accountManagementProvider;
    @InjectMocks
    private ApiNotificationListener apiNotificationListener;

    @Test
    void givenCharacterWhenUpdateThenOk() {
        Character character = CharacterMother.getWarrior();
        character.setNickname("ferho");
        Mockito.doNothing().when(accountManagementProvider).notifyCharacterCreation(character);
        apiNotificationListener.update(character);
        Mockito.verify(accountManagementProvider, Mockito.times(1)).notifyCharacterCreation(character);
    }
}

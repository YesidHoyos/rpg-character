package com.yesid.rpgcharacter.domain.observer;

import com.yesid.rpgcharacter.domain.model.Character;
import com.yesid.rpgcharacter.provider.AccountManagementProvider;
import org.springframework.stereotype.Component;

@Component
public class ApiNotificationListener implements CharacterCreatedListener {

    private final AccountManagementProvider accountManagementProvider;

    public ApiNotificationListener(AccountManagementProvider accountManagementProvider) {
        this.accountManagementProvider = accountManagementProvider;
    }

    @Override
    public void update(Character character) {
        accountManagementProvider.notifyCharacterCreation(character);
    }
}

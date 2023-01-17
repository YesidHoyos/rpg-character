package com.yesid.rpgcharacter.provider;

import com.yesid.rpgcharacter.domain.model.Character;

public interface AccountManagementProvider {
    void notifyCharacterCreation(Character character);
}

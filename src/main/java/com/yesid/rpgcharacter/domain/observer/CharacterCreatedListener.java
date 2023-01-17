package com.yesid.rpgcharacter.domain.observer;

import com.yesid.rpgcharacter.domain.model.Character;

public interface CharacterCreatedListener {
    void update(Character character);
}

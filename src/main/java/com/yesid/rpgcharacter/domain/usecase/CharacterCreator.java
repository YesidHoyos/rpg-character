package com.yesid.rpgcharacter.domain.usecase;

import com.yesid.rpgcharacter.domain.model.Character;
import com.yesid.rpgcharacter.domain.model.CharacterType;

public interface CharacterCreator {
    Character create(CharacterType characterType, String nickName);
}

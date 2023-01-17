package com.yesid.rpgcharacter.provider;

import com.yesid.rpgcharacter.domain.model.Character;

public interface CharacterRepositoryProvider {
    Character save(Character character);
    Character getByNickname(String nickName);
}

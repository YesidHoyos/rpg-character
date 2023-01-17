package com.yesid.rpgcharacter.domain.usecase;

import com.yesid.rpgcharacter.domain.model.Character;
import com.yesid.rpgcharacter.domain.decorator.ArmorUpgradeDecorator;
import com.yesid.rpgcharacter.domain.decorator.CharacterDecorator;
import com.yesid.rpgcharacter.domain.decorator.WeaponUpgradeDecorator;
import com.yesid.rpgcharacter.provider.CharacterRepositoryProvider;
import org.springframework.stereotype.Service;

@Service
public class AttackUseCase {

    private final CharacterRepositoryProvider characterRepositoryProvider;

    public AttackUseCase(CharacterRepositoryProvider characterRepositoryProvider) {
        this.characterRepositoryProvider = characterRepositoryProvider;
    }

    public void attack(String nickName) {
        Character character = characterRepositoryProvider.getByNickname(nickName);
        character.attack();
    }

    public void attackWithArmorUpgraded(String nickName) {
        Character character = characterRepositoryProvider.getByNickname(nickName);
        CharacterDecorator characterDecorator = new ArmorUpgradeDecorator(character);
        characterDecorator.attack();

    }

    public void attackWithWeaponUpgraded(String nickName) {
        Character character = characterRepositoryProvider.getByNickname(nickName);
        CharacterDecorator characterDecorator = new WeaponUpgradeDecorator(character);
        characterDecorator.attack();
    }
}

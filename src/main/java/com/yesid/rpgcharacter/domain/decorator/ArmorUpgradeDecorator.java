package com.yesid.rpgcharacter.domain.decorator;

import com.yesid.rpgcharacter.domain.model.Character;

public class ArmorUpgradeDecorator extends CharacterDecorator {

    public ArmorUpgradeDecorator(Character decoratedCharacter) {
        super(decoratedCharacter);
    }

    @Override
    public void attack() {
        super.attack();
        System.out.println("poder aumentado +3");
    }
}

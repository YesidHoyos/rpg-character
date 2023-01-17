package com.yesid.rpgcharacter.domain.decorator;

import com.yesid.rpgcharacter.domain.model.Character;
import com.yesid.rpgcharacter.domain.visitor.CharacterVisitor;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public abstract class CharacterDecorator extends Character {

    private final Character decoratedCharacter;

    protected CharacterDecorator(Character decoratedCharacter) {
        this.decoratedCharacter = decoratedCharacter;
    }

    @Override
    public void attack() {
        decoratedCharacter.attack();
    }

    @Override
    public Character clone() {
        return decoratedCharacter.clone();
    }

    @Override
    public String accept(CharacterVisitor characterVisitor) {
        return decoratedCharacter.accept(characterVisitor);
    }
}

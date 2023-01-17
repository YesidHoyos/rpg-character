package com.yesid.rpgcharacter.domain.model;

import com.yesid.rpgcharacter.domain.visitor.CharacterVisitor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Setter
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Healer extends Character {

    private String pet;
    public Healer(Healer target) {
        super(target);
        this.pet = target.getPet();
    }

    @Override
    public void attack() {
        System.out.println("curando con un poder de: " + this.getAttackPower());
    }

    @Override
    public Character clone() {
        return new Healer(this);
    }

    @Override
    public String accept(CharacterVisitor characterVisitor) {
        return characterVisitor.visit(this);
    }
}

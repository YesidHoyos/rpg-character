package com.yesid.rpgcharacter.domain.visitor;

import com.yesid.rpgcharacter.domain.model.Character;
import org.springframework.stereotype.Component;

@Component
public class ExportCharacterStyleVisitor implements CharacterVisitor {

    @Override
    public String visit(Character character) {
        return "<character>" + "\n" +
                "    <gender>" + character.getGender() + "</gender>" + "\n" +
                "    <skinColor>" + character.getSkinColor() + "</skinColor>" + "\n" +
                "    <hairStyle>" + character.getHairStyle() + "</hairStyle>" + "\n" +
                "    <hairColor>" + character.getHairColor() + "</hairColor>" + "\n" +
                "</character>";
    }
}

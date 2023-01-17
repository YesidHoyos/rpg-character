package com.yesid.rpgcharacter.domain.visitor;

import com.yesid.rpgcharacter.domain.model.Character;

public interface CharacterVisitor {

    String visit(Character character);
}

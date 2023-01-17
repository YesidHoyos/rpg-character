package com.yesid.rpgcharacter.adapter.inbound.proxy;

import com.yesid.rpgcharacter.domain.usecase.CharacterCreator;
import com.yesid.rpgcharacter.domain.exception.InvalidCharacterException;
import com.yesid.rpgcharacter.domain.model.Character;
import com.yesid.rpgcharacter.domain.model.CharacterType;
import com.yesid.rpgcharacter.domain.usecase.CreateCharacterUseCase;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CharacterCreatorProxy implements CharacterCreator {

    private final CreateCharacterUseCase createCharacterUseCase;

    private final List<String> bannedNames;

    public CharacterCreatorProxy(CreateCharacterUseCase createCharacterUseCase) {
        this.createCharacterUseCase = createCharacterUseCase;
        bannedNames = Arrays.asList("pepito", "john");
    }

    @Override
    public Character create(CharacterType characterType, String nickName) {
        if(bannedNames.contains(nickName.toLowerCase())) {
            throw new InvalidCharacterException("Nombre de personaje no permitido");
        }
        return createCharacterUseCase.create(characterType, nickName);
    }
}

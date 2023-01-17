package com.yesid.rpgcharacter.domain.usecase;

import com.yesid.rpgcharacter.domain.model.Character;
import com.yesid.rpgcharacter.domain.model.CharacterType;
import com.yesid.rpgcharacter.domain.factory.CharacterFactoryContext;
import com.yesid.rpgcharacter.domain.observer.CharacterCreatedManager;
import com.yesid.rpgcharacter.provider.CharacterRepositoryProvider;
import org.springframework.stereotype.Service;

@Service
public class CreateCharacterUseCase implements CharacterCreator {

    private final CharacterFactoryContext characterFactoryContext;
    private final CharacterCreatedManager characterCreatedManager;
    private final CharacterRepositoryProvider characterRepositoryProvider;

    public CreateCharacterUseCase(CharacterFactoryContext characterFactoryContext,
                                  CharacterCreatedManager characterCreatedManager,
                                  CharacterRepositoryProvider characterRepositoryProvider) {
        this.characterFactoryContext = characterFactoryContext;
        this.characterCreatedManager = characterCreatedManager;
        this.characterRepositoryProvider = characterRepositoryProvider;
    }

    @Override
    public Character create(CharacterType characterType, String nickName) {
        Character character = characterFactoryContext.getCharacterFactory(characterType).buildCharacter();
        character.setNickname(nickName);
        Character characterSaved = characterRepositoryProvider.save(character);
        characterCreatedManager.notify(characterSaved);
        return character;
    }
}

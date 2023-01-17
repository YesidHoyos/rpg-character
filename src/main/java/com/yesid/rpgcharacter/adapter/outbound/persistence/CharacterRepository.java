package com.yesid.rpgcharacter.adapter.outbound.persistence;

import com.yesid.rpgcharacter.adapter.outbound.persistence.entity.CharacterEntity;
import com.yesid.rpgcharacter.domain.exception.CharacterNotFoundException;
import com.yesid.rpgcharacter.domain.model.Character;
import com.yesid.rpgcharacter.provider.CharacterRepositoryProvider;
import org.springframework.stereotype.Repository;

@Repository
public class CharacterRepository implements CharacterRepositoryProvider {

    private final CharacterRepositoryJpa characterRepositoryJpa;

    public CharacterRepository(CharacterRepositoryJpa characterRepositoryJpa) {
        this.characterRepositoryJpa = characterRepositoryJpa;
    }

    @Override
    public Character save(Character character) {
        CharacterEntity characterEntity = CharacterFactory.getEntity(character);
        characterRepositoryJpa.save(characterEntity);
        return CharacterFactory.getCharacter(characterEntity);
    }

    @Override
    public Character getByNickname(String nickName) {
        CharacterEntity characterEntity = characterRepositoryJpa.findByNickname(nickName)
                .orElseThrow(() -> new CharacterNotFoundException("El personaje no existe"));
        return CharacterFactory.getCharacter(characterEntity);
    }
}

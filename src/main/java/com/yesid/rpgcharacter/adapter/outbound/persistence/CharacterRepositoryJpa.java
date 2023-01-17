package com.yesid.rpgcharacter.adapter.outbound.persistence;

import com.yesid.rpgcharacter.adapter.outbound.persistence.entity.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CharacterRepositoryJpa extends JpaRepository<CharacterEntity, Long> {
    Optional<CharacterEntity> findByNickname(String nickName);
}

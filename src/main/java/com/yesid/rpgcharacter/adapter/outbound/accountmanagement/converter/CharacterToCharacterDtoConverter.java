package com.yesid.rpgcharacter.adapter.outbound.accountmanagement.converter;

import com.yesid.rpgcharacter.adapter.outbound.accountmanagement.dto.CharacterDto;
import com.yesid.rpgcharacter.domain.exception.InvalidCharacterException;
import com.yesid.rpgcharacter.domain.model.Character;
import com.yesid.rpgcharacter.domain.model.Healer;
import com.yesid.rpgcharacter.domain.model.Warrior;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface CharacterToCharacterDtoConverter extends Converter<Character, CharacterDto> {

    @Mapping(source = "character", target = "characterType", qualifiedByName = "getCharacterType")
    CharacterDto convert(Character character);

    @Named("getCharacterType")
    default String getCharacterType(Character character) {
        if (character instanceof Warrior) {
            return "warrior";
        } else if (character instanceof Healer) {
            return "healer";
        } else {
            throw new InvalidCharacterException("clase no valida");
        }
    }
}

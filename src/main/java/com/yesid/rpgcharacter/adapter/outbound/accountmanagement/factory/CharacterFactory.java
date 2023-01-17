package com.yesid.rpgcharacter.adapter.outbound.accountmanagement.factory;

import com.yesid.rpgcharacter.adapter.outbound.accountmanagement.dto.CharacterDto;
import com.yesid.rpgcharacter.domain.model.Character;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

@Component
public class CharacterFactory {

    private final ConversionService conversionService;

    public CharacterFactory(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    public CharacterDto getCharacterDto(Character character) {
        return conversionService.convert(character, CharacterDto.class);
    }
}

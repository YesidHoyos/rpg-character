package com.yesid.rpgcharacter.adapter.inbound.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CharacterRequestDto {
    @JsonProperty(required = true)
    private String nickName;

    @JsonProperty(required = true)
    private String characterType;
}

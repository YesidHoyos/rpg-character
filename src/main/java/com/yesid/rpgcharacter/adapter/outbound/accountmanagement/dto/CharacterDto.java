package com.yesid.rpgcharacter.adapter.outbound.accountmanagement.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CharacterDto {
    private String nickname;
    private int level;
    private String characterType;
}

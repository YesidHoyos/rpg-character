package com.yesid.rpgcharacter.adaper.outbound.it.accountmanagement;

import com.yesid.rpgcharacter.RpgCharacterApplication;
import com.yesid.rpgcharacter.adapter.outbound.accountmanagement.client.AccountManagementClient;
import com.yesid.rpgcharacter.adapter.outbound.accountmanagement.dto.CharacterDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = RpgCharacterApplication.class)
class AccountManagementClientIT {

    @Autowired
    private AccountManagementClient accountManagementClient;

    @Test
    void givenCharacterWhenNotifyCharacterCreationThenOK() {
        CharacterDto characterDto = CharacterDto.builder()
                .nickname("ferho")
                .level(1)
                .characterType("warrior").build();
        Assertions.assertDoesNotThrow(() -> accountManagementClient.notifyCharacterCreation(characterDto));
    }
}

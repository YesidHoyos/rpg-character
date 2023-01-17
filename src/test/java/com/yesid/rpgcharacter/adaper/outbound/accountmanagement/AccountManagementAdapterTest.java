package com.yesid.rpgcharacter.adaper.outbound.accountmanagement;

import com.yesid.rpgcharacter.adapter.outbound.accountmanagement.AccountManagementAdapter;
import com.yesid.rpgcharacter.adapter.outbound.accountmanagement.client.AccountManagementClient;
import com.yesid.rpgcharacter.adapter.outbound.accountmanagement.dto.CharacterDto;
import com.yesid.rpgcharacter.adapter.outbound.accountmanagement.factory.CharacterFactory;
import com.yesid.rpgcharacter.domain.model.Warrior;
import com.yesid.rpgcharacter.domain.usecase.mother.CharacterMother;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AccountManagementAdapterTest {

    @Mock
    private AccountManagementClient accountManagementClient;
    @Mock
    private CharacterFactory characterFactory;
    @InjectMocks
    private AccountManagementAdapter accountManagementAdapter;

    @Test
    void givenCharacterWhenNotifyCharacterCreationThenOK() {
        Warrior character = CharacterMother.getWarrior();
        character.setNickname("ferho");
        CharacterDto characterDto = CharacterDto.builder()
                .nickname(character.getNickname())
                .level(character.getLevel())
                .characterType("warrior").build();
        Mockito.when(characterFactory.getCharacterDto(character)).thenReturn(characterDto);
        Mockito.doNothing().when(accountManagementClient).notifyCharacterCreation(characterDto);
        accountManagementAdapter.notifyCharacterCreation(character);
        Mockito.verify(accountManagementClient).notifyCharacterCreation(characterDto);
    }
}

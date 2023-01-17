package com.yesid.rpgcharacter.adapter.outbound.accountmanagement;

import com.yesid.rpgcharacter.adapter.outbound.accountmanagement.client.AccountManagementClient;
import com.yesid.rpgcharacter.adapter.outbound.accountmanagement.dto.CharacterDto;
import com.yesid.rpgcharacter.adapter.outbound.accountmanagement.factory.CharacterFactory;
import com.yesid.rpgcharacter.domain.model.Character;
import com.yesid.rpgcharacter.provider.AccountManagementProvider;
import org.springframework.stereotype.Component;

@Component
public class AccountManagementAdapter implements AccountManagementProvider {

    private final AccountManagementClient accountManagementClient;
    private final CharacterFactory characterFactory;

    public AccountManagementAdapter(AccountManagementClient accountManagementClient, CharacterFactory characterFactory) {
        this.accountManagementClient = accountManagementClient;
        this.characterFactory = characterFactory;
    }

    @Override
    public void notifyCharacterCreation(Character character) {
        /*todo
        implement async call and fault tolerance
         */
        CharacterDto characterDto = characterFactory.getCharacterDto(character);
        accountManagementClient.notifyCharacterCreation(characterDto);
    }
}

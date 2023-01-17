package com.yesid.rpgcharacter.adapter.outbound.accountmanagement.client;

import com.yesid.rpgcharacter.adapter.outbound.accountmanagement.dto.CharacterDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "accountManagementClient", url = "${accountmanagement.api.url}")
public interface AccountManagementClient {

    @PostMapping(value = "/account-management/notification/character")
    void notifyCharacterCreation(CharacterDto characterDto);
}

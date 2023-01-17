package com.yesid.rpgcharacter.adapter.inbound.controller;

import com.yesid.rpgcharacter.adapter.inbound.controller.dto.AttackerRequestDto;
import com.yesid.rpgcharacter.adapter.inbound.controller.dto.CharacterRequestDto;
import com.yesid.rpgcharacter.adapter.inbound.controller.dto.UpgradeType;
import com.yesid.rpgcharacter.adapter.inbound.proxy.CharacterCreatorProxy;
import com.yesid.rpgcharacter.aop.annotation.Secured;
import com.yesid.rpgcharacter.domain.model.Character;
import com.yesid.rpgcharacter.domain.model.CharacterType;
import com.yesid.rpgcharacter.domain.usecase.AttackUseCase;
import com.yesid.rpgcharacter.domain.usecase.ExportCharacterStyleUseCase;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/character")
public class CharacterController {

    private final CharacterCreatorProxy characterCreatorProxy;
    private final ExportCharacterStyleUseCase exportCharacterStyleUseCase;
    private final AttackUseCase attackUseCase;

    public CharacterController(CharacterCreatorProxy characterCreatorProxy,
                               ExportCharacterStyleUseCase exportCharacterStyleUseCase, AttackUseCase attackUseCase) {
        this.characterCreatorProxy = characterCreatorProxy;
        this.exportCharacterStyleUseCase = exportCharacterStyleUseCase;
        this.attackUseCase = attackUseCase;
    }

    @Secured
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Character createCharacter(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorization,
                                     @RequestBody CharacterRequestDto characterRequestDto) {
        CharacterType characterType = CharacterType.valueOfLabel(characterRequestDto.getCharacterType());
        return characterCreatorProxy.create(characterType, characterRequestDto.getNickName());
    }

    @GetMapping("/{nickName}/style")
    public String exportCharacterStyle(@PathVariable String nickName) {
        return exportCharacterStyleUseCase.export(nickName);
    }

    @PostMapping("/attack")
    public void attack(@RequestBody AttackerRequestDto attackerRequestDto) {
        switch (UpgradeType.valueOfLabel(attackerRequestDto.getUpgradeType())) {
            case ARMOR:
                attackUseCase.attackWithArmorUpgraded(attackerRequestDto.getNickName());
                break;
            case WEAPON:
                attackUseCase.attackWithWeaponUpgraded(attackerRequestDto.getNickName());
                break;
            default:
                attackUseCase.attack(attackerRequestDto.getNickName());
        }
    }
}

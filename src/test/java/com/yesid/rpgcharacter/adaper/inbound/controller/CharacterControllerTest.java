package com.yesid.rpgcharacter.adaper.inbound.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yesid.rpgcharacter.adapter.inbound.controller.CharacterController;
import com.yesid.rpgcharacter.adapter.inbound.proxy.CharacterCreatorProxy;
import com.yesid.rpgcharacter.domain.exception.InvalidCharacterException;
import com.yesid.rpgcharacter.domain.model.Character;
import com.yesid.rpgcharacter.domain.model.CharacterType;
import com.yesid.rpgcharacter.domain.usecase.AttackUseCase;
import com.yesid.rpgcharacter.domain.usecase.ExportCharacterStyleUseCase;
import com.yesid.rpgcharacter.domain.usecase.mother.CharacterMother;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(CharacterController.class)
class CharacterControllerTest {

    private static final String NICKNAME = "ferho";
    private static final String NICKNAME_BANNED = "pepito";
    private static final String INVALID_CHARACTER_NAME_MESSAGE = "Nombre de personaje no permitido";
    private static final String BASE_URL = "/character";
    private static final String ATTACK_URL = "/character/attack";
    private static final String INVALID_CLASS_MESSAGE = "clase no valida";

    @MockBean
    private CharacterCreatorProxy characterCreatorProxy;
    @MockBean
    private ExportCharacterStyleUseCase exportCharacterStyleUseCase;
    @MockBean
    private AttackUseCase attackUseCase;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void createCharacterTest() throws Exception {
        Character warrior = CharacterMother.getWarrior();
        warrior.setNickname(NICKNAME);

        String warriorJson = objectMapper.writeValueAsString(warrior);

        Mockito.when(characterCreatorProxy.create(CharacterType.WARRIOR, NICKNAME)).thenReturn(warrior);

        mockMvc.perform(MockMvcRequestBuilders
                        .post(BASE_URL)
                        .header("Authorization", "1234")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"characterType\": \"warrior\",\"nickName\": \"ferho\"}"))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().json(warriorJson));
    }

    @Test
    void createCharacterInvalidCharacterNameExceptionTest() throws Exception {
        Mockito.when(characterCreatorProxy.create(CharacterType.WARRIOR, NICKNAME_BANNED))
                .thenThrow(new InvalidCharacterException(INVALID_CHARACTER_NAME_MESSAGE));

        mockMvc.perform(MockMvcRequestBuilders
                        .post(BASE_URL)
                        .header("Authorization", "1234")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"characterType\": \"warrior\",\"nickName\": \"pepito\"}"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string(INVALID_CHARACTER_NAME_MESSAGE));
    }

    @Test
    void createCharacterInvalidCharacterClassExceptionTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .post(BASE_URL)
                        .header("Authorization", "1234")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"characterType\": \"clare\",\"nickName\": \"ferho\"}"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string(INVALID_CLASS_MESSAGE));
    }

    @Test
    void exportCharacterStyleTest() throws Exception {
        Character warrior = CharacterMother.getWarrior();
        String warriorStyle = "<character>" + "\n" +
                "    <gender>" + warrior.getGender() + "</gender>" + "\n" +
                "    <skinColor>" + warrior.getSkinColor() + "</skinColor>" + "\n" +
                "    <hairStyle>" + warrior.getHairStyle() + "</hairStyle>" + "\n" +
                "    <hairColor>" + warrior.getHairColor() + "</hairColor>" + "\n" +
                "</character>";

        Mockito.when(exportCharacterStyleUseCase.export(NICKNAME)).thenReturn(warriorStyle);

        mockMvc.perform(MockMvcRequestBuilders
                        .get(BASE_URL.concat("/ferho/style")))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(warriorStyle));
    }

    @Test
    void attackTest() throws Exception {
        Mockito.doNothing().when(attackUseCase).attack(NICKNAME);
        mockMvc.perform(MockMvcRequestBuilders
                        .post(ATTACK_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"upgradeType\": \"none\",\"nickName\": \"ferho\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void attackWithArmorUpgradedTest() throws Exception {
        Mockito.doNothing().when(attackUseCase).attackWithArmorUpgraded(NICKNAME);
        mockMvc.perform(MockMvcRequestBuilders
                        .post(ATTACK_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"upgradeType\": \"armor\",\"nickName\": \"ferho\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void attackWithWeaponUpgradedTest() throws Exception {
        Mockito.doNothing().when(attackUseCase).attackWithWeaponUpgraded(NICKNAME);
        mockMvc.perform(MockMvcRequestBuilders
                        .post(ATTACK_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"upgradeType\": \"weapon\",\"nickName\": \"ferho\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}

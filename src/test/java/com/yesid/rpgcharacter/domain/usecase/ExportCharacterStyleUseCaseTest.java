package com.yesid.rpgcharacter.domain.usecase;

import com.yesid.rpgcharacter.domain.model.Character;
import com.yesid.rpgcharacter.domain.usecase.mother.CharacterMother;
import com.yesid.rpgcharacter.domain.visitor.ExportCharacterStyleVisitor;
import com.yesid.rpgcharacter.provider.CharacterRepositoryProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ExportCharacterStyleUseCaseTest {

    private static final String NICKNAME = "ferho";

    @Mock
    private ExportCharacterStyleVisitor exportCharacterStyleVisitor;
    @Mock
    private CharacterRepositoryProvider characterRepositoryProvider;
    @InjectMocks
    private ExportCharacterStyleUseCase exportCharacterStyleUseCase;

    @Test
    void givenNickNameWhenExportThenCharacterStyleExported() {
        Character warrior = CharacterMother.getWarrior();
        warrior.setNickname(NICKNAME);
        String warriorStyle = "<character>" + "\n" +
                "    <gender>" + warrior.getGender() + "</gender>" + "\n" +
                "    <skinColor>" + warrior.getSkinColor() + "</skinColor>" + "\n" +
                "    <hairStyle>" + warrior.getHairStyle() + "</hairStyle>" + "\n" +
                "    <hairColor>" + warrior.getHairColor() + "</hairColor>" + "\n" +
                "</character>";
        Mockito.when(characterRepositoryProvider.getByNickname(NICKNAME)).thenReturn(warrior);
        Mockito.when(exportCharacterStyleVisitor.visit(warrior)).thenReturn(warriorStyle);

        String characterStyle = exportCharacterStyleUseCase.export(NICKNAME);

        Assertions.assertEquals(warriorStyle, characterStyle);
    }
}

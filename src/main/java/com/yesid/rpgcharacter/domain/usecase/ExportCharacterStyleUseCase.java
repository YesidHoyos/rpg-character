package com.yesid.rpgcharacter.domain.usecase;

import com.yesid.rpgcharacter.domain.model.Character;
import com.yesid.rpgcharacter.domain.visitor.ExportCharacterStyleVisitor;
import com.yesid.rpgcharacter.provider.CharacterRepositoryProvider;
import org.springframework.stereotype.Service;

@Service
public class ExportCharacterStyleUseCase {

    private final ExportCharacterStyleVisitor exportCharacterStyleVisitor;
    private final CharacterRepositoryProvider characterRepositoryProvider;

    public ExportCharacterStyleUseCase(ExportCharacterStyleVisitor exportCharacterStyleVisitor,
                                       CharacterRepositoryProvider characterRepositoryProvider) {
        this.exportCharacterStyleVisitor = exportCharacterStyleVisitor;
        this.characterRepositoryProvider = characterRepositoryProvider;
    }

    public String export(String nickName) {
        Character character = characterRepositoryProvider.getByNickname(nickName);
        return exportCharacterStyleVisitor.visit(character);
    }
}

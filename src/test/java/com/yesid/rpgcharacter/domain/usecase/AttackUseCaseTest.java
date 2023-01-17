package com.yesid.rpgcharacter.domain.usecase;

import com.yesid.rpgcharacter.domain.model.Character;
import com.yesid.rpgcharacter.domain.usecase.mother.CharacterMother;
import com.yesid.rpgcharacter.provider.CharacterRepositoryProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AttackUseCaseTest {

    private static final String NICKNAME = "ferho";

    @Mock
    private CharacterRepositoryProvider characterRepositoryProvider;
    @InjectMocks
    private AttackUseCase attackUseCase;

    @Test
    void givenNickNameWhenAttackThenCharacterAttack() {
        Character warrior = CharacterMother.getWarrior();
        warrior.setNickname(NICKNAME);
        Mockito.when(characterRepositoryProvider.getByNickname(NICKNAME)).thenReturn(warrior);

        attackUseCase.attack(NICKNAME);

        Mockito.verify(characterRepositoryProvider, Mockito.times(1)).getByNickname(NICKNAME);
    }

    @Test
    void givenNickNameWhenAttackWithArmorUpgradedThenCharacterAttackWithArmorUpgraded() {
        Character warrior = CharacterMother.getWarrior();
        warrior.setNickname(NICKNAME);
        Mockito.when(characterRepositoryProvider.getByNickname(NICKNAME)).thenReturn(warrior);

        attackUseCase.attackWithArmorUpgraded(NICKNAME);

        Mockito.verify(characterRepositoryProvider, Mockito.times(1)).getByNickname(NICKNAME);
    }

    @Test
    void givenNickNameWhenAttackWithWeaponUpgradedThenCharacterAttackWithWeaponUpgraded() {
        Character warrior = CharacterMother.getWarrior();
        warrior.setNickname(NICKNAME);
        Mockito.when(characterRepositoryProvider.getByNickname(NICKNAME)).thenReturn(warrior);

        attackUseCase.attackWithWeaponUpgraded(NICKNAME);

        Mockito.verify(characterRepositoryProvider, Mockito.times(1)).getByNickname(NICKNAME);
    }
}

package com.yesid.rpgcharacter.domain.observer;

import com.yesid.rpgcharacter.domain.model.Character;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationListener implements CharacterCreatedListener {
    @Override
    public void update(Character character) {
        /*todo
        implement and consume a queue service
         */
        System.out.println("Correo enviado al dueño de la cuenta. Se ha creado un nuevo personaje, nickname: " + character.getNickname());
    }
}

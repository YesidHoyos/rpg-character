package com.yesid.rpgcharacter.domain.observer;

import com.yesid.rpgcharacter.domain.model.Character;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CharacterCreatedManager {
    private final List<CharacterCreatedListener> listeners;

    public CharacterCreatedManager(EmailNotificationListener emailNotificationListener,
                                   ApiNotificationListener apiNotificationListener) {
        this.listeners = Arrays.asList(emailNotificationListener, apiNotificationListener);
    }

    public void notify(Character character) {
        for (CharacterCreatedListener listener : listeners) {
            listener.update(character);
        }
    }
}

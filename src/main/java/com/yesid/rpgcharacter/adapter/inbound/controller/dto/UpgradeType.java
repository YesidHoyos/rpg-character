package com.yesid.rpgcharacter.adapter.inbound.controller.dto;


import com.yesid.rpgcharacter.domain.exception.InvalidUpgradeException;

public enum UpgradeType {
    NONE("none"),
    ARMOR("armor"),
    WEAPON("weapon");

    public final String label;

    UpgradeType(String label) {
        this.label = label;
    }

    public static UpgradeType valueOfLabel(String label) {
        for (UpgradeType upgradeType : values()) {
            if (upgradeType.label.equals(label)) {
                return upgradeType;
            }
        }
        throw new InvalidUpgradeException("Mejora no valida");
    }
}

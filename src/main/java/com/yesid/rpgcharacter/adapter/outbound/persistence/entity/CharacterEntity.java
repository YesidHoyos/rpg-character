package com.yesid.rpgcharacter.adapter.outbound.persistence.entity;

import com.yesid.rpgcharacter.domain.model.CharacterType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "character")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CharacterEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nickname;
    private String gender;
    @Column(name = "skin_color")
    private String skinColor;
    @Column(name = "hair_style")
    private String hairStyle;
    @Column(name = "hair_color")
    private String hairColor;
    @Column(name = "attack_power")
    private int attackPower;
    @Column(name = "defense_power")
    private int defensePower;
    private int level;
    @Column(name = "character_type")
    private CharacterType characterType;
    private String pet;
    private String mount;
}

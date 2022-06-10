package com.company.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Player extends Character {
    private Inventory inventory;
    private Equipment equipment;

    public Player(String name, int level, Inventory inventory, Equipment equipment, int maxHealthPoints, int healthPoints, int strength, int defense, int speed, int dexterity, String charClass, int money) {
        super(name, level, maxHealthPoints, healthPoints, strength, defense, speed, dexterity, charClass, money);
        this.inventory = inventory;
        this.equipment = equipment;
    }

}

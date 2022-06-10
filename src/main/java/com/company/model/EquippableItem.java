package com.company.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EquippableItem extends Item{
    int dexterity,
            charisma,
            defense,
            speed,
            strength;
    Item item;

    public EquippableItem(Item item){
        this.item = item;
    }


    public EquippableItem(String name, String type, String description, int price, int quantity, int dexterity, int charisma, int defense, int speed, int strength) {
        super(name, type, description, price, quantity);
        this.dexterity = dexterity;
        this.charisma = charisma;
        this.defense = defense;
        this.speed = speed;
        this.strength = strength;
    }

}

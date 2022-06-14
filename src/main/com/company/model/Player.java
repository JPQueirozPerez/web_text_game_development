package main.com.company.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Player extends Character {
    private Inventory inventory;
    private Equipment equipment;
    private int maxExperiencePoints;

    public Player(String name, int level, Inventory inventory, Equipment equipment, int maxHealthPoints, int healthPoints, int strength, int defense, int speed, int dexterity, String charClass, int money, int experiencePoints, int charisma, int maxExperiencePoints) {
        super(name, level, maxHealthPoints, healthPoints, strength, defense, speed, dexterity, charClass, money, experiencePoints, charisma);
        this.inventory = inventory;
        this.equipment = equipment;
        this.maxExperiencePoints = maxExperiencePoints;
    }

}

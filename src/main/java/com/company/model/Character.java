package com.company.model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Character {
    private String charClass,
            name;
    private int charisma,
            defense,
            dexterity,
            experiencePoints,
            healthPoints,
            level,
            manaPoints,
            maxHealthPoints,
            maxManaPoints,
            money,
            speed,
            strength,
            totalCharisma,
            totalDefense,
            totalDexterity,
            totalHealthPoints,
            totalSpeed,
            totalStrength;


    public Character(String name, int level, int maxHealthPoints, int healthPoints, int strength, int defense, int speed, int dexterity, String charClass, int money) {
        this.name = name;
        this.level = level;
        this.maxHealthPoints = maxHealthPoints;
        this.healthPoints = healthPoints;
        this.strength = strength;
        this.defense = defense;
        this.speed = speed;
        this.dexterity = dexterity;
        this.charClass = charClass;
        this.money = money;
        this.totalStrength = strength;
        this.totalDefense = defense;
        this.totalSpeed = speed;
    }

}

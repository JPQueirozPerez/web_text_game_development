package main.com.company.model;

import lombok.*;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Proxy(lazy = false)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcharacter")
    private int idcharacter;
    @Column(name = "npc_or_player")
    private boolean type;
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


    public Character(String name, int level, int maxHealthPoints, int healthPoints, int strength, int defense, int speed, int dexterity, String charClass, int money, int experiencePoints, int charisma) {
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
        this.experiencePoints = experiencePoints;
        this.charisma = charisma;
    }
}

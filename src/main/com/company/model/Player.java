package main.com.company.model;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Proxy;
import org.springframework.data.jpa.repository.Modifying;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Proxy(lazy = false)
@DiscriminatorValue(value = "player_har")
public class Player extends Character {

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    @JoinColumn(name = "inventory_fk")
    private Inventory inventory;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "equipment_fk")
    private Equipment equipment;

    private int maxExperiencePoints;

    private  String nameItem;

    public Player(String name, int level, Inventory inventory, Equipment equipment, int maxHealthPoints, int healthPoints, int strength, int defense, int speed, int dexterity, String charClass, int money, int experiencePoints, int charisma, int maxExperiencePoints) {
        super(name, level, maxHealthPoints, healthPoints, strength, defense, speed, dexterity, charClass, money, experiencePoints, charisma);
        this.inventory = inventory;
        this.equipment = equipment;
        this.maxExperiencePoints = maxExperiencePoints;
    }

    public Player(String name, int level, Inventory inventory, Equipment equipment, int maxHealthPoints, int healthPoints, int strength, int defense, int speed, int dexterity, String charClass, int money, int experiencePoints, int charisma, String nameItem, int maxExperiencePoints) {
        super(name, level, maxHealthPoints, healthPoints, strength, defense, speed, dexterity, charClass, money, experiencePoints, charisma);
        this.inventory = inventory;
        this.equipment = equipment;
        this.nameItem = nameItem;
        this.maxExperiencePoints = maxExperiencePoints;
    }

}

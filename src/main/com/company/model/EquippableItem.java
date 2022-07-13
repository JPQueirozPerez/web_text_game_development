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
@DiscriminatorValue(value = "equippableItem")
public class EquippableItem extends Item{

    int dexterity,
            charisma,
            defense,
            speed,
            strength;

    public EquippableItem(String name, String type, String description, int price, int quantity, int dexterity, int charisma, int defense, int speed, int strength, int choise) {
        super(name, type, description, price, quantity,choise);
        this.dexterity = dexterity;
        this.charisma = charisma;
        this.defense = defense;
        this.speed = speed;
        this.strength = strength;
    }



}

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
@DiscriminatorValue(value = "npc_char")
public class NPC extends Character {


//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY,optional = true)
//    @JoinColumn(name = "treasure_fk")
    @Transient
    private Item treasure;

    int choise ;

    public NPC(String name, int level, Item treasure, int maxHealthPoints, int healthPoints, int strength, int defense, int speed, int dexterity, String charClass, int money, int experiencePoints, int charisma, int choise, boolean type) {
        super(name, level, maxHealthPoints, healthPoints, strength, defense, speed, dexterity, charClass, money, experiencePoints, charisma,type);
        this.treasure = treasure;
        this.choise = choise;
    }

}

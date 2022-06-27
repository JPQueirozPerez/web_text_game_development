package main.com.company.model;

import jdk.jfr.BooleanFlag;
import lombok.*;

import java.util.LinkedList;


@Getter
@Setter
//@BooleanFlag
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Equipment {
    private int quantityEquippedItems,
            totalDefense,
            totalSpeed,
            totalStrength;
    private boolean head,
            body,
            arms,
            legs,
            weapon1,
            weapon2;
    private LinkedList<EquippableItem> equipments;


    public boolean isHead(){return this.head;}
    public boolean isBody(){return this.body;}
    public boolean isArms(){return this.arms;}
    public boolean isLegs(){return this.legs;}
    public boolean isWeapon1(){return this.weapon1;}
    public boolean isWeapon2(){return this.weapon2;}

}

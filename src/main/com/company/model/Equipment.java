package main.com.company.model;

import lombok.*;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Proxy(lazy = false)
@Table(name = "equipment")
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idequipment")
    private int idequipment;
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

    @OneToMany(cascade = CascadeType.ALL,  fetch = FetchType.LAZY)
    @JoinColumn(name = "equipment_item_fk")
    private List<EquippableItem> equipments;


    public Equipment(int i, int i1, int i2, int i3, List<EquippableItem> equipments) {
        this.quantityEquippedItems = i;
        this.totalDefense = i1;
        this.totalSpeed = i2;
        this.totalStrength = i3;
        this.equipments = equipments;
    }


    public boolean isHead(){return this.head;}
    public boolean isBody(){return this.body;}
    public boolean isArms(){return this.arms;}
    public boolean isLegs(){return this.legs;}
    public boolean isWeapon1(){return this.weapon1;}
    public boolean isWeapon2(){return this.weapon2;}

}

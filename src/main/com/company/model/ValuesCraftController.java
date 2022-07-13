package main.com.company.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Proxy(lazy = false)
@Table(name = "recipes")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
public class ValuesCraftController {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrecipe")
    private int id,
        necessaryQuantity;
    private String craftItemName,
           ingredientName;

    public ValuesCraftController(int necessaryQuantity, String craftItemName, String ingredientName) {
        this.necessaryQuantity = necessaryQuantity;
        this.craftItemName = craftItemName;
        this.ingredientName = ingredientName;
    }

}
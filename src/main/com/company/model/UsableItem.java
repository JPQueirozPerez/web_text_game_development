package main.com.company.model;

import lombok.*;
import org.hibernate.annotations.Proxy;
import org.hibernate.engine.spi.Status;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Proxy(lazy = false)
@DiscriminatorValue(value = "usableItem")
public class UsableItem extends Item{
    String use;
    int value;

    public UsableItem(String name, String type, String description, int price, int quantity, String use, int value, int choise) {
        super(name, type, description, price, quantity, choise);
        this.use = use;
        this.value = value;
    }

}

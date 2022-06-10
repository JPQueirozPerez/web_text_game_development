package com.company.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Item {
    private String description,
            name,
            type;
    private int index,
            price,
            quantity;




    public Item(String name, String type, String description, int price, int quantity) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Item item = (Item) o;

        if (!name.equals(item.name)) {
            return false;
        }
        if (!type.equals(item.type)) {
            return false;
        }
        if (!description.equals(item.description)) {
            return false;
        }
        if (price != (item.price)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 42 * result + price;
        return result;
    }

}

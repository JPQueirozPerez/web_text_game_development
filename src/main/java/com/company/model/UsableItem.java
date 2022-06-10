package com.company.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UsableItem extends Item{
    String use;
    int value;



    public UsableItem(String name, String type, String description, int price, int quantity, String use, int value) {
        super(name, type, description, price, quantity);
        this.use = use;
        this.value = value;
    }
}

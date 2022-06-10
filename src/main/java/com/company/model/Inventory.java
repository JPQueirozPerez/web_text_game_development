package com.company.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Inventory {
    private int capacity;
    private List<Item> items;


}

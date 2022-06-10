package com.company.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Equipment {
    private int quantityEquippedItems,
            totalDefense,
            totalSpeed,
            totalStrenght;
    private List<EquippableItem> equipments;


}

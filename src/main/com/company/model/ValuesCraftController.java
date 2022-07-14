package main.com.company.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValuesCraftController {



    @Id
    int id;
    String ingredientName;
    int necessaryQuantity;
    String craftItemName;
}
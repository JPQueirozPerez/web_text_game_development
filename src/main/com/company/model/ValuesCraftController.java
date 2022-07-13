package main.com.company.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ValuesCraftController {



    @Id
    int id;
    String ingredientName;
    int neccesaryQuantity;
    String craftItemName;
}

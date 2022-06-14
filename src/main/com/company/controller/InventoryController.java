package main.com.company.controller;

import main.com.company.model.Inventory;
import main.com.company.model.Item;
import main.com.company.view.InventoryView;

import java.util.List;

import static main.com.company.service.InventoryService.compareItems;
import static main.com.company.service.InventoryService.searchItemByName;

public class InventoryController {

    public static Inventory addItemToInventory(List<Item> items, Inventory inventory, Item newItem) {
        String name = newItem.getName();
        if (inventory.getCapacity() == 0) InventoryView.addItemToInventoryMessage("3", newItem);
        else  {
            if (!compareItems(inventory.getItems(), newItem)) {
                items.add(newItem);
                newItem.setQuantity(1);
//                items.replace(newItem, items.get(newItem) + 1);
                if(inventory.getInitialCapacity() == 10) InventoryView.addItemToInventoryMessage("2", newItem);
            } else {
                items.stream().filter(z -> z.getName().equals(name)).forEach( x -> x.setQuantity(x.getQuantity()+1));
                if(inventory.getInitialCapacity() == 10) InventoryView.addItemToInventoryMessage("1", newItem);
            }
            inventory.setItems(items);
            inventory.setCapacity(inventory.getCapacity() - 1);
        }
        return inventory;
    }

    public static Inventory removeItemFromInventory(Inventory inventory, Item itemToRemove, int repetition){
        String name = itemToRemove.getName();
        inventory.getItems().stream().filter(z -> z.getName().equals(name)).forEach( x -> x.setQuantity(x.getQuantity()-repetition));
        inventory.setCapacity(inventory.getCapacity() + repetition);
        if (searchItemByName(inventory.getItems(),name).getQuantity() < 1) inventory.getItems().remove(itemToRemove);
        return inventory;
    }
}

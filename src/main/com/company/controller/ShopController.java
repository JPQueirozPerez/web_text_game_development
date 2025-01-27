package main.com.company.controller;

import main.com.company.model.Inventory;
import main.com.company.model.Item;
import main.com.company.model.Player;
import main.com.company.view.ShopView;

import java.util.ArrayList;
import java.util.List;

import static main.com.company.service.InventoryService.compareItems;
import static main.com.company.service.InventoryService.createItem;

public class ShopController {

    public static Inventory createShopInventory(){
        int index = 0;
        List<Item> items = new ArrayList<>(100);
        Inventory shopInventory = new Inventory(200, items);
        for (int i = 0; i < 100; i++) {
            Item newItem = createItem();
            if (compareItems(shopInventory.getItems(), newItem)){
                String name = newItem.getName();
                items.stream().filter(z -> z.getName().equals(name)).forEach( x -> x.setQuantity(x.getQuantity()+1));
            }
            //shopInventory.getItems().items.replace(newItem, items.get(newItem) + 1);
            else {
                newItem.setIndex(index);
                items.add(newItem);
                index++;
            }
            newItem.setQuantity(newItem.getQuantity()+1);
            shopInventory.setItems(items);
            shopInventory.setCapacity(shopInventory.getCapacity() - 1);
        }
        return shopInventory;
    }

    public static void shopping(Player player, int value) {
        Inventory shopInventory = createShopInventory();
        if (value != 1) ShopView.buyingAndSelling(shopInventory, player, 2);
        else ShopView.buyingAndSelling(shopInventory, player, 1);
    }
}

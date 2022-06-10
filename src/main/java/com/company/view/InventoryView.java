package com.company.view;

import com.company.model.EquippableItem;
import com.company.model.Item;
import com.company.model.Player;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import static com.company.service.InventoryService.equippingOrUsingObject;

public class InventoryView {








    public static void showInventory(Player player) {
        System.out.println("INVENTORY");
        showInventoryLoop(player);
        System.out.println("Choose an item number to equip or use. Press 0 to return to Game Menu");
    }


    public static void showInventoryLoop(Player player){
        AtomicInteger i = new AtomicInteger(1);
        player.getInventory().getItems().forEach(     (item) -> { item.setIndex(i.intValue());
            System.out.format(i.getAndIncrement() + ". Name: "
                    + item.getName()+ " | Quantity: x"+ item.getQuantity() + "               "+ " " + "\n"
                    + " " + "    Description: " + item.getDescription() + " " + "\n");
            if (item.getClass() == EquippableItem.class){
                if(((EquippableItem) item).getStrength() != 0) {
                    System.out.format(" "  + "    Attack: "+ ((EquippableItem) item).getStrength() + "\n");
                }
            }
            if (item.getClass() == EquippableItem.class){
                if (((EquippableItem) item).getDefense() != 0) {
                    System.out.format( "    Defense: "+ ((EquippableItem) item).getDefense() + "\n");
                }
            }
            if (item.getClass() == EquippableItem.class) {
                if (((EquippableItem) item).getSpeed() != 0) {
                    System.out.format( "    Speed: " + ((EquippableItem) item).getSpeed() + "\n");
                }
            }
            System.out.println();
        });
    }

    public static void addItemToInventoryMessage(String value, Item newItem) {
        switch (value) {
            case "1": {
                System.out.println("Same item: "  + newItem.getName() );
                break;
            }
            case "2": {
                System.out.println("New item: "  + newItem.getName());
                break;
            }
            case "3": {
                System.out.println("Your inventory is full, you can't get more items");
                break;
            }
        }
    }

    public static void inventoryUseItem(Player player) {
        Scanner reader = new Scanner(System.in);
        while (true) {
            showInventory(player);
            String option = reader.nextLine();
            try {
                if (Integer.parseInt(option) == 0) break;
                else equippingOrUsingObject(player, Integer.parseInt(option));
            } catch (Exception e) {
                System.out.println("Unknown option. Try again");
            }
        }
    }

    public static void inventoryMessage(int value, Item item) {
        switch (value) {
            case 1: {
                System.out.println("The chosen object is: "  + item.getName());
                break;
            }
            case 2: {
                System.out.println("You cannot use or equip this item.");
                break;
            }
        }
    }
}


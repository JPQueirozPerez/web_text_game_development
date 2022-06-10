package com.company.view;

import com.company.controller.ShopController;
import com.company.model.EquippableItem;
import com.company.model.Inventory;
import com.company.model.Player;
import com.company.service.ShopService;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import static com.company.service.ShopService.itemPriceCalculation;
import static com.company.utils.Utilities.ask;
import static com.company.view.IOView.gameLoopView;

public class ShopView {
    static Scanner reader = new Scanner(System.in);
    public static void menuShopView() {
        System.out.println();
        System.out.println(" SHOP");
        System.out.println();
        System.out.println(" 1- Buy");
        System.out.println(" 2- Sell");
        System.out.println(" 0- Return to back Menu");
        System.out.println();
    }
    public static void showShopInventoryLoop(Inventory shopInventory, int value){
        AtomicInteger i = new AtomicInteger(1);
        shopInventory.getItems().forEach((item) -> {
            item.setIndex(i.intValue());
            System.out.format(i.getAndIncrement() + ". Name: "
                    + item.getName()+ " | Quantity: x"+ item.getQuantity()+ "\n"
                    + "    Description: "+ item.getDescription() + "\n"
                    + "    Price: "+ ((value == 1) ? itemPriceCalculation(1, item) : itemPriceCalculation(2, item))+ "\n");
            if (item.getClass() == EquippableItem.class){
                if(((EquippableItem) item).getStrength() != 0) {
                    System.out.format("    Attack: "+ ((EquippableItem) item).getStrength() + "\n");
                }
            }
            if (item.getClass() == EquippableItem.class){
                if (((EquippableItem) item).getDefense() != 0) {
                    System.out.format("    Defense: "+ ((EquippableItem) item).getDefense() + "\n");
                }
            }
            if (item.getClass() == EquippableItem.class) {
                if (((EquippableItem) item).getSpeed() != 0) {
                    System.out.format("    Speed: "+ ((EquippableItem) item).getSpeed() + "\n");
                }
            }
            System.out.println();
        });
    }
    public static void showShopInventory(Inventory shopInventory, int value) {
        System.out.println();
        System.out.println("SHOP INVENTORY");
        System.out.println();
        showShopInventoryLoop(shopInventory,value);
        System.out.println(" ");
    }

    public static void buyingAndSelling(Inventory shopInventory, Player player, int value) {
        while (true) {
            if (value != 1) showShopInventory(player.getInventory(), value);
            else showShopInventory(shopInventory,value);

            String option = ask(reader, "Choose an item number to " + ((value != 1) ? "sell" : "buy") + ". Press 0 to return to Shop Menu");
            try {
                if (Integer.parseInt(option) == 0) break;
                else {
                    int quantity = Integer.parseInt(ask(reader, "How many items do you want to " + ((value != 1) ? "sell" : "buy") + "?"));
                    if (quantity < 1) {
                        System.out.println("The quantity needs to be at least 1");
                    } else {
                        if (value == 1) {
                            ShopService.shopping(1, shopInventory, Integer.parseInt(option), player, quantity);
                        } else {
                            ShopService.shopping(2, shopInventory, Integer.parseInt(option), player, quantity);
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Unknown option. Try again");
            }
        }
    }

    public static void shopping(Player player) {
        while (true) {
            menuShopView();
            String option = ask(reader, "Choose an option");
            switch (option) {
                case "1": {
                    ShopController.shopping(player, 1);
                    break;
                }
                case "2": {
                    ShopController.shopping(player, 2);
                    break;
                }
                case "0": {
                    gameLoopView(player);
                    break;
                }
                default: {
                    System.out.println("Unknown option. Try again");
                    break;
                }
            }
        }
    }

    public static void shopMessage(int value, String itemName, int price, int quantity) {
        switch (value) {
            case 1: {
                System.out.println("The chosen object is "  + itemName  + ", its quantity is "  + quantity  + " and its price is "  + price);
                break;
            }
            case 2: {
                System.out.println("You don't have enough money for buy "  + quantity  + ((quantity == 1) ? " unit " : " units ") + "of "+ itemName);
                break;
            }
            case 3: {
                System.out.println("You don't have "  + quantity  + ((quantity == 1) ? " unit " : " units ") + "of " +  itemName + " to sell.");
                break;
            }
        }
    }
}

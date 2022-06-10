package com.company.view;

import com.company.controller.CraftController;
import com.company.model.Player;

import java.util.Scanner;

import static com.company.utils.Utilities.ask;

public class CraftView {

    public static void craftMenuView() {
        System.out.println();
        System.out.println("CRAFTING MENU");
        System.out.println();
        System.out.println(" 1- Health potion");
        System.out.println(" 2- Golem arm");
        System.out.println(" 3- Golem leg");
        System.out.println(" 4- Golem head");
        System.out.println(" 5- Golem body");
        System.out.println(" 6- Leather");
        System.out.println(" 7- Leather helmet");
        System.out.println(" 8- Leather gloves" );
        System.out.println(" 9- Leather boots");
        System.out.println(" 10- Leather armour");
        System.out.println();
    }

    public static void crafting(Player player) {
        Scanner reader = new Scanner(System.in);
        while (true) {
            craftMenuView();
            String option = ask(reader, "Choose what item you want to craft. Press 0 to return to back Menu");
            try {
                if (Integer.parseInt(option) == 0) break;
                else {
                    int quantity = Integer.parseInt(ask(reader, "How many items do you want to craft?"));
                    if (quantity < 1) {
                        System.out.println("The quantity needs to be at least 1");
                    } else CraftController.crafting(player, Integer.parseInt(option), quantity);
                }
            } catch (Exception e) {
                System.out.println("Unknown option. Try again");
            }
        }
    }

    public static void craftingMessages(int value, String craftedItemName, int inventoryQuantity, int necessaryQuantity, String ingredientName, int craftQuantity) {
        switch (value) {
            case 1: {
                System.out.println("You don't have enough ingredients, you need "  + (necessaryQuantity * craftQuantity - inventoryQuantity)  + " more of "  + ingredientName  + " to craft "  + craftQuantity + " " + craftedItemName);
                break;
            }
        }
    }
}
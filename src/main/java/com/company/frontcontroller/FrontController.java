package com.company.frontcontroller;

import com.company.model.Player;

import static com.company.controller.FightController.fighting;
import static com.company.view.CharacterView.character;
import static com.company.view.CharacterView.createCharacter;
import static com.company.view.CraftView.crafting;
import static com.company.view.InventoryView.inventoryUseItem;
import static com.company.view.ShopView.shopping;

public class FrontController {
    public static void mainLoopController(String value) {
        switch (value) {
            case "1": {
                createCharacter();
                break;
            }
        }
    }

    public static void gameLoopController(String value, Player player) {
        switch (value) {
            case "1": {
                fighting(player);
                break;
            }
            case "2": {
                inventoryUseItem(player);
                break;
            }
            case "3": {
                character(player);
                break;
            }
            case "4": {
                shopping(player);
                break;
            }
            case "5": {
                crafting(player);
                break;
            }
        }
    }
}

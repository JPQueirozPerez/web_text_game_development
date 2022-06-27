package main.com.company.controller;


import main.com.company.model.*;
import main.com.company.service.CharacterService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static main.com.company.service.InventoryService.createItem;

public class

CharacterController {

    public static Player createPlayer(String name, String charClass) {
        List<Item> items = new ArrayList<>();
        Inventory playerInventory = new Inventory(10, 10, items);
        LinkedList<EquippableItem> equipments = new LinkedList<>();
        Equipment playerEquipment = new Equipment(0, 0, 0, 0, false, false, false, false, false, false, equipments);
        Player newPlayer = new Player();
        switch (charClass) {
            case "Cleric": {
                Player player = new Player(name, 1, playerInventory, playerEquipment, 100, 100, 10, 15, 20, 20, "Cleric", 5, 0, 0, 100);
                Item newItem = new EquippableItem("Tunic", "cloth", "A simple tunic", 2, 1, 0, 0, 1, 0, 0, "body");
                newPlayer = CharacterService.createPlayer(items, newItem, player, playerInventory);
                break;
            }

            case "Mage": {
                Player player = new Player(name, 1, playerInventory, playerEquipment, 100, 100, 10, 15, 25, 15, "Mage", 5, 0, 0, 100);
                Item newItem = new EquippableItem("Tunic", "cloth", "A simple tunic", 2, 1, 0, 0, 1, 0, 0, "body");
                newPlayer = CharacterService.createPlayer(items, newItem, player, playerInventory);
                break;
            }

            case "Monk": {
                Player player = new Player(name, 1, playerInventory, playerEquipment, 90, 90, 15, 10, 25, 25, "Monk", 5, 0, 0, 100);
                Item newItem = new EquippableItem("Wooden stick", "weapon", "A simple stick made of wood", 1, 1, 0, 0, 0, 0, 1,"weapon");
                newPlayer = CharacterService.createPlayer(items, newItem, player, playerInventory);
                break;
            }

            case "Paladin": {
                Player player = new Player(name, 1, playerInventory, playerEquipment, 120, 120, 15, 15, 15, 10, "Paladin", 5, 0, 0, 100);
                Item newItem = new EquippableItem("Sword", "weapon", "A simple sword", 7, 1, 0, 0, 0, 0, 4,"weapon");
                newPlayer = CharacterService.createPlayer(items, newItem, player, playerInventory);
                break;
            }

            case "Ranger": {
                Player player = new Player(name, 1, playerInventory, playerEquipment, 100, 100, 10, 10, 20, 25, "Ranger", 5, 0, 0, 100);
                Item newItem = new EquippableItem("Bow", "weapon", "A simple bow", 4, 1, 0, 0, 0, 0, 2,"weapon");
                newPlayer = CharacterService.createPlayer(items, newItem, player, playerInventory);
                break;
            }

            case "Rogue": {
                Player player = new Player(name, 1, playerInventory, playerEquipment, 90, 90, 15, 15, 20, 25, "Rogue", 500, 0, 0, 100);
                Item newItem = new EquippableItem("Dagger", "weapon", "A simple dagger", 3, 1, 0, 0, 0, 0, 2,"weapon");
                newPlayer = CharacterService.createPlayer(items, newItem, player, playerInventory);
                break;
            }

            case "Warrior": {
                Player player = new Player(name, 1, playerInventory, playerEquipment, 100, 100, 25, 15, 10, 15, "Warrior", 5, 0, 0, 100);
                Item newItem = new EquippableItem("Sword", "weapon", "A simple sword", 7, 1, 0, 0, 0, 0, 4,"weapon");
                newPlayer = CharacterService.createPlayer(items, newItem, player, playerInventory);
                break;
            }
        }
        return newPlayer;
    }

    public static NPC createEnemyPlaceholder(int playerLevel) {
        NPC enemy;
        int level;
        int value = new Random().nextInt((11 - 1) + 1);
        if (!(playerLevel < 4)) {
            level = new Random().nextInt((playerLevel - 3), (playerLevel + 4));
        } else {
            level = new Random().nextInt( 1, playerLevel+4);
        }

        Item fur = new Item("Fur", "material", "The fur of an wild animal", 1, 1);
        Item clay = new Item("Clay", "material", "A handful of clay", 1, 1);

        switch (value) {
            case 1: {
                enemy = new NPC("Goblin", level, createItem(), 20 + (level * 4), 20 + (level * 4), 20 + (level * 3), 5 + level, 25 + (level * 4), 25 + (level * 2), null, 5, 40 * level, 0);
                break;
            }
            case 2: {
                enemy = new NPC("Wolf", level, fur, 10 + level, 10 + level, 10 + (level * 2), 15 + (level * 2), 35 + (level * 4), 5 + level, "beast", 0, 20 * level, 0);
                break;
            }
            case 3: {
                enemy = new NPC("Burglar", level, createItem(), 25 + (level * 2), 25 + (level * 2), 15 + (level * 2), 15 + (level * 2), 15 + (level * 2), 15 + (level * 2), null, 20, 30 * level, 0);
                break;
            }
            case 4: {
                enemy = new NPC("Witch", level, createItem(), 20 + (level * 3), 20 + (level * 3), 10 + level, 15 + level , 25 + (level * 2), 15 + (level * 2), null, 5, 25 * level, 0);
                break;
            }
            case 5: {
                enemy = new NPC("Ratman", level, fur, 25 + level, 25 + level, 20 + (level * 2), 10 + level, 20 + (level * 2), 10 + level, "beast", 0, 20 * level, 0);
                break;
            }
            case 6: {
                enemy = new NPC("Wild boar", level, fur, 10 + level, 10 + level, 10 + level, 10 + level, 25 + (level * 3), 10 + level, "beast", 0, 15 * level, 0);
                break;
            }
            case 7: {
                enemy = new NPC("Vampire", level, createItem(), 40 + (level * 4), 40 + (level * 4), 20 + (level * 2), 10 + level, 15 + level, 15 + level, null, 10, 50 * level, 0);
                break;
            }
            case 8: {
                enemy = new NPC("Wendigo", level, fur, 25 + (level * 2), 25 + (level * 2), 25 + (level * 3), 5 + level, 25 + (level * 3), 5 + level, "beast", 0, 30 * level, 0);
                break;
            }
            case 9: {
                enemy = new NPC("Golem", level, clay, 45 + (level * 5), 45 + (level * 5), 35 + (level * 3), 25 + (level * 2), 10 + level, 10 + level, null, 0, 60 * level, 0);
                break;
            }
            case 10: {
                enemy = new NPC("Cave lion", level, fur, 15 + level, 15 + level, 15 + level, 15 + level, 25 + (level * 2), 5 + (level * 2), "beast", 0, 15 * level, 0);
                break;
            }
            default: {
                enemy = new NPC("Soldier", level, createItem(), 50 + (level * 4), 50 + (level * 4), 25 + (level * 3), 15 + (level * 2), 5 + level, 20 + (level * 2), null, 15, 60 * level, 0);
                break;
            }
        }
        return enemy;
    }

}




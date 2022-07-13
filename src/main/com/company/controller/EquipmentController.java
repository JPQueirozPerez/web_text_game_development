package main.com.company.controller;

import main.com.company.model.EquippableItem;
import main.com.company.model.Item;
import main.com.company.model.Player;
import main.com.company.service.EquipmentService;
import main.com.company.utils.Utilities;

import java.util.Scanner;

public class EquipmentController {


    public static void equippingPlayer(Player player, Item item) {
        if (player.getEquipment().getQuantityEquippedItems() < 6) {
            switch (((EquippableItem) item).getPlace()) {
                case "head": {
                    if (player.getEquipment().isHead()){
                        EquipmentService.reEquippingPlayer(player, (EquippableItem) item);
                    }
                    else {
                        EquipmentService.equippingPlayer(player,item);
                        player.getEquipment().setHead(true);
                    }
                    break;
                }
                case "body": {
                    if (player.getEquipment().isBody()) {
                        EquipmentService.reEquippingPlayer(player, (EquippableItem) item);
                    }
                    else {
                        EquipmentService.equippingPlayer(player,item);
                        player.getEquipment().setBody(true);
                    }
                    break;
                }
                case "arms": {
                    if (player.getEquipment().isArms()) {
                        EquipmentService.reEquippingPlayer(player, (EquippableItem) item);
                    }
                    else{
                        EquipmentService.equippingPlayer(player,item);
                        player.getEquipment().setArms(true);
                    }
                    break;
                }
                case "legs": {
                    if (player.getEquipment().isLegs()) {
                        EquipmentService.reEquippingPlayer(player, (EquippableItem) item);
                    }
                    else {
                        EquipmentService.equippingPlayer(player,item);
                        player.getEquipment().setLegs(true);
                    }
                    break;
                }
                case "weapon": {
                    if (player.getEquipment().isWeapon1() && player.getEquipment().isWeapon2())
                    {
                        EquipmentService.reEquippingPlayer(player, (EquippableItem) item);
                    }
                    else if (player.getEquipment().isWeapon1()) {
                        EquipmentService.equippingPlayer(player,item);
                        player.getEquipment().setWeapon2(true);
                    }
                    else {
                        EquipmentService.equippingPlayer(player,item);
                        player.getEquipment().setWeapon1(true);
                    }
                    break;
                }
            }
        }
    }
}
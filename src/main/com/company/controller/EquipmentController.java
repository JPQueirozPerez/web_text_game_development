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
                        player.getEquipment().setHead(true);
                        EquipmentService.equippingPlayer(player,item);
                    }
                    break;
                }
                case "body": {
                    if (player.getEquipment().isBody()) {
                        EquipmentService.reEquippingPlayer(player, (EquippableItem) item);
                    }
                    else {
                        player.getEquipment().setBody(true);
                        EquipmentService.equippingPlayer(player,item);
                    }
                    break;
                }
                case "arms": {
                    if (player.getEquipment().isArms()) {
                        EquipmentService.reEquippingPlayer(player, (EquippableItem) item);
                    }
                    else{
                        player.getEquipment().setArms(true);
                        EquipmentService.equippingPlayer(player,item);
                    }
                    break;
                }
                case "legs": {
                    if (player.getEquipment().isLegs()) {
                        EquipmentService.reEquippingPlayer(player, (EquippableItem) item);
                    }
                    else {
                        player.getEquipment().setLegs(true);
                        EquipmentService.equippingPlayer(player,item);
                    }
                    break;
                }
                case "weapon": {
                    if (player.getEquipment().isWeapon1() && player.getEquipment().isWeapon2())
                    {
                        EquipmentService.reEquippingPlayer(player, (EquippableItem) item);
                    }
                    else if (player.getEquipment().isWeapon1()) {
                        player.getEquipment().setWeapon2(true);
                        EquipmentService.equippingPlayer(player,item);
                    }
                    else {
                        player.getEquipment().setWeapon1(true);
                        EquipmentService.equippingPlayer(player,item);
                    }
                    break;
                }
            }
        }
    }
}

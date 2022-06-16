package main.com.company.controller;

import main.com.company.model.EquippableItem;
import main.com.company.model.Item;
import main.com.company.model.Player;
import main.com.company.service.EquipmentService;

public class EquipmentController {


    public static void equippingPlayer(Player player, Item item) {

        if (player.getEquipment().getQuantityEquippedItems() < 6) {
            switch (((EquippableItem) item).getPlace()) {
                case "head": {
                    if (player.getEquipment().isHead()) System.out.println("You already have a helmet!");
                    else {
                        player.getEquipment().setHead(true);
                        EquipmentService.equippingPlayer(player,item);
                    }
                    break;
                }
                case "body": {
                    if (player.getEquipment().isBody()) System.out.println("You already have body armour!");
                    else {
                        player.getEquipment().setBody(true);
                        EquipmentService.equippingPlayer(player,item);
                    }
                    break;
                }
                case "arms": {
                    if (player.getEquipment().isArms()) System.out.println("You already have arm armour!");
                    else{
                        player.getEquipment().setArms(true);
                        EquipmentService.equippingPlayer(player,item);
                    }
                    break;
                }
                case "legs": {
                    if (player.getEquipment().isLegs()) System.out.println("You already have leg armour!");
                    else {
                        player.getEquipment().setLegs(true);
                        EquipmentService.equippingPlayer(player,item);
                    }
                    break;
                }
                case "weapon": {
                    if (player.getEquipment().isWeapon1() && player.getEquipment().isWeapon2())
                        System.out.println("You already have weapons!");
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

package main.com.company.service;

import main.com.company.controller.InventoryController;
import main.com.company.model.EquippableItem;
import main.com.company.model.Item;
import main.com.company.model.Player;
import main.com.company.utils.Utilities;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class EquipmentService {
    public static void equippingPlayer(Player player, Item item) {
        player.getEquipment().setQuantityEquippedItems(player.getEquipment().getQuantityEquippedItems() + 1);
        player.getEquipment().getEquipments().add((EquippableItem) item);
        setEquipmentTotalCharacteristics(player, player.getEquipment().getQuantityEquippedItems());
    }


    public static void reEquippingPlayer(Player player, EquippableItem item) {
        Scanner reader = new Scanner(System.in);
        Item equipmentItem = searchItemByPlace(player.getEquipment().getEquipments(), item.getPlace());


        System.out.println("You already have an item in that position!");
        String option = Utilities.ask(reader, "Do you want to change your item?");
        if (option.equalsIgnoreCase("yes")) {
            if (!item.getPlace().equals("weapon")) {
                removeEquipment(player, (EquippableItem) equipmentItem);
                EquipmentService.equippingPlayer(player, item);
            } else {
                Item weapon2 = searchWeaponByPlace(player.getEquipment().getEquipments(), "weapon");
                String name = Utilities.ask(reader, "Which weapon do you want to change?" +equipmentItem.getName()+" "+weapon2.getName());
                if (name.equalsIgnoreCase(equipmentItem.getName())) {
                    EquipmentService.equippingPlayer(player, item);
                    removeEquipment(player, (EquippableItem) equipmentItem);
                } else if (name.equalsIgnoreCase(weapon2.getName())) {
                    EquipmentService.equippingPlayer(player, item);
                    removeEquipment(player, (EquippableItem) weapon2);
                }else System.out.println("Invalid option!");
            }

        } else if (option.equalsIgnoreCase("no"))
            System.out.println("You don't change your " + equipmentItem.getName() + "!");
        else System.out.println("Invalid option");
    }

    public static void removeEquipment(Player player, EquippableItem item) {
        if (player.getInventory().getCapacity() == 0)
            System.out.println("You can't remove this equipment because you don't have capacity in your inventory");
        else {
//            if (index > 0 && index <= messages.size()) { //TODO https://stackoverflow.com/questions/16746572/linked-list-throws-an-indexoutofboundsexception
//                player.getEquipment().getEquipments().remove(item);
//                player.setInventory(InventoryController.addItemToInventory(player.getInventory(), item));
//            };
            //player.getInventory().getItems().add(item);//TODO
            //setEquipmentTotalCharacteristics(player,player.getInventory().getItems().size());//TODO
        }

    }

    public static Item searchItemByPlace(List<EquippableItem> items, String place) {
        return items.stream()
                .filter(i -> i.getPlace().equals(place))
                .findAny()
                .orElse(null);
    }

    public static Item searchWeaponByPlace(List<EquippableItem> items, String place) {
        return items.stream().filter(i -> i.getPlace().equals(place))
                .skip(items.size() - 1)
                .findAny()
                .orElse(null);
    }

    public static void setEquipmentTotalCharacteristics(Player player, int indexItemEquipment) {
        player.getEquipment().setTotalStrength(((EquippableItem) player.getEquipment().getEquipments().get(indexItemEquipment-1)).getStrength() + player.getEquipment().getTotalStrength());
        player.getEquipment().setTotalDefense(((EquippableItem) player.getEquipment().getEquipments().get(indexItemEquipment-1)).getDefense() + player.getEquipment().getTotalDefense());
        player.getEquipment().setTotalSpeed(((EquippableItem) player.getEquipment().getEquipments().get(indexItemEquipment-1)).getSpeed() + player.getEquipment().getTotalSpeed());
        CharacterService.setPlayerTotalCharacteristics(player);
    }
}

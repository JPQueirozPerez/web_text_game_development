package main.com.company.service;

import main.com.company.model.EquippableItem;
import main.com.company.model.Item;
import main.com.company.model.Player;

// Check numbers items Equipment and add items Equipment <= 10
public class EquipmentService {
    public static void equippingPlayer(Player player, Item item) {

        if (player.getEquipment().getQuantityEquippedItems() < 6) {
            switch (((EquippableItem) item).getPlace()) {
                case "head": {
                    if (player.getEquipment().isHead()) System.out.println("You already have a helmet!");
                    else player.getEquipment().setHead(true);
                    break;
                }
                case "body": {
                    if (player.getEquipment().isBody()) System.out.println("You already have body armour!");
                    else player.getEquipment().setBody(true);
                    break;
                }
                case "arms": {
                    if (player.getEquipment().isArms()) System.out.println("You already have arm armour!");
                    else player.getEquipment().setArms(true);
                    break;
                }
                case "legs": {
                    if (player.getEquipment().isLegs()) System.out.println("You already have leg armour!");
                    else player.getEquipment().setLegs(true);
                    break;
                }
                case "weapon": {
                    if (player.getEquipment().isWeapon1() && player.getEquipment().isWeapon2())
                        System.out.println("You already have weapons!");
                    else if (player.getEquipment().isWeapon1()) player.getEquipment().setWeapon2(true);
                    else player.getEquipment().setWeapon1(true);
                    break;
                }
            }
            player.getEquipment().setQuantityEquippedItems(player.getEquipment().getQuantityEquippedItems() + 1);
            player.getEquipment().getEquipments().add((EquippableItem) item);
            setEquipmentTotalCharacteristics(player, player.getEquipment().getQuantityEquippedItems());
        }
    }

    public static void setEquipmentTotalCharacteristics(Player player, int indexItemEquipment) {
        player.getEquipment().setTotalStrength((player.getEquipment().getEquipments().get(indexItemEquipment - 1)).getStrength() + player.getEquipment().getTotalStrength());
        player.getEquipment().setTotalDefense((player.getEquipment().getEquipments().get(indexItemEquipment - 1)).getDefense() + player.getEquipment().getTotalDefense());
        player.getEquipment().setTotalSpeed((player.getEquipment().getEquipments().get(indexItemEquipment - 1)).getSpeed() + player.getEquipment().getTotalSpeed());
        CharacterService.setPlayerTotalCharacteristics(player);
    }
}

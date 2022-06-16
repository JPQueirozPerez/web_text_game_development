package main.com.company.service;

import main.com.company.controller.InventoryController;
import main.com.company.model.EquippableItem;
import main.com.company.model.Item;
import main.com.company.model.Player;

// Check numbers items Equipment and add items Equipment <= 10
public class EquipmentService {
    public static void equippingPlayer(Player player, Item item) {
        InventoryController.removeItemFromInventory(player.getInventory(), item, 1);
        player.getEquipment().setQuantityEquippedItems(player.getEquipment().getQuantityEquippedItems() + 1);
        player.getEquipment().getEquipments().add((EquippableItem) item);
        setEquipmentTotalCharacteristics(player, player.getEquipment().getQuantityEquippedItems());
    }




    public static void setEquipmentTotalCharacteristics(Player player, int indexItemEquipment) {
        player.getEquipment().setTotalStrength((player.getEquipment().getEquipments().get(indexItemEquipment - 1)).getStrength() + player.getEquipment().getTotalStrength());
        player.getEquipment().setTotalDefense((player.getEquipment().getEquipments().get(indexItemEquipment - 1)).getDefense() + player.getEquipment().getTotalDefense());
        player.getEquipment().setTotalSpeed((player.getEquipment().getEquipments().get(indexItemEquipment - 1)).getSpeed() + player.getEquipment().getTotalSpeed());
        CharacterService.setPlayerTotalCharacteristics(player);
    }
}

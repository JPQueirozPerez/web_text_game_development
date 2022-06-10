package com.company.service;

import com.company.model.EquippableItem;
import com.company.model.Item;
import com.company.model.Player;

import static com.company.service.CharacterService.setPlayerTotalCharacteristics;

// Check numbers items Equipment and add items Equipment <= 10
public class EquipmentService {
    public static void equippingPlayer(Player player, Item item) {
        player.getEquipment().setQuantityEquippedItems(player.getEquipment().getQuantityEquippedItems() + 1);
        player.getEquipment().getEquipments().add((EquippableItem) item);
        setEquipmentTotalCharacteristics(player, player.getEquipment().getQuantityEquippedItems());
    }

    public static void setEquipmentTotalCharacteristics(Player player, int indexItemEquipment) {
        player.getEquipment().setTotalStrenght(((EquippableItem) player.getEquipment().getEquipments().get(indexItemEquipment-1)).getStrength() + player.getEquipment().getTotalStrenght());
        player.getEquipment().setTotalDefense(((EquippableItem) player.getEquipment().getEquipments().get(indexItemEquipment-1)).getDefense() + player.getEquipment().getTotalDefense());
        player.getEquipment().setTotalSpeed(((EquippableItem) player.getEquipment().getEquipments().get(indexItemEquipment-1)).getSpeed() + player.getEquipment().getTotalSpeed());
        setPlayerTotalCharacteristics(player);
    }
}

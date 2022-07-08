package main.com.company.service;

import main.com.company.model.EquippableItem;
import main.com.company.model.Item;
import main.com.company.model.Player;
import org.springframework.stereotype.Service;

@Service
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
        CharacterService.setPlayerTotalCharacteristics(player);
    }
}

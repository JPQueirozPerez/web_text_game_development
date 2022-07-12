package main.com.company.service;

import main.com.company.model.*;
import org.springframework.stereotype.Service;

import java.util.List;

import static main.com.company.view.CharacterView.moneyMessage;

@Service
public class CharacterService {

    public static void addingMoney(Player player, NPC enemy) {
        player.setMoney(player.getMoney() + enemy.getMoney());
        if (enemy.getMoney() > 0) moneyMessage("1", player, enemy);
    }

    // sum characteristics player + items equipments
    public static void setPlayerTotalCharacteristics(Player player) {
        player.setTotalStrength(player.getEquipment().getTotalStrength() + player.getStrength());
        player.setTotalDefense(player.getEquipment().getTotalDefense() + player.getDefense());
        player.setTotalSpeed(player.getEquipment().getTotalSpeed() + player.getSpeed());
    }

    // Polimorfismo
    public static Player createPlayer(List<Item> items, Item newItem, Player player, Inventory playerInventory) {
        items.add(newItem);
        player.getInventory().setItems(items);
        playerInventory.setCapacity(playerInventory.getCapacity() - 1);
        return player;
    }
}

package com.company.service;

import com.company.model.Inventory;
import com.company.model.Item;
import com.company.model.NPC;
import com.company.model.Player;

import java.util.List;

import static com.company.view.CharacterView.moneyMessage;

public class CharacterService {

    public static void addingMoney(Player player, NPC enemy) {
        player.setMoney(player.getMoney() + enemy.getMoney());
        if (enemy.getMoney() > 0) moneyMessage("1", player, enemy);
    }

    // sum characteristics player + items equipments
    public static void setPlayerTotalCharacteristics(Player player) {
        player.setTotalStrength(player.getEquipment().getTotalStrenght() + player.getStrength());
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

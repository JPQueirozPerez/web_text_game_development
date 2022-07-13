package main.com.company.service;

import main.com.company.controller.InventoryController;
import main.com.company.model.*;
import main.com.company.view.FightView;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

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
        playerInventory.setItems(items);
        playerInventory.setCapacity(playerInventory.getCapacity() - 1);
        return player;
    }

    public static void levelUp(Player player) {
        if (player.getExperiencePoints() == player.getMaxExperiencePoints() * player.getLevel()) {
            player.setExperiencePoints(0);
        } else if (player.getExperiencePoints() > player.getMaxExperiencePoints() * player.getLevel()) {
            player.setExperiencePoints(player.getExperiencePoints() - player.getMaxExperiencePoints() * player.getLevel());
        }
        player.setLevel(player.getLevel() + 1);
        player.setMaxHealthPoints(player.getMaxHealthPoints() + valueGained() * 5);
        player.setStrength(player.getStrength() + valueGained());
        player.setDefense(player.getDefense() + valueGained());
        player.setSpeed(player.getSpeed() + valueGained());
        player.setDexterity(player.getDexterity() + valueGained());
        setPlayerTotalCharacteristics(player);
        FightView.fightingMessages("9", null, player);
        FightView.fightingMessages("10", null, player);
    }

    public static int valueGained() {
        Random r = new Random();
        return r.nextInt(3 - 1) + 1;
    }
}

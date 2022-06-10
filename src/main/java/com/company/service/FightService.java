package com.company.service;

import com.company.model.Character;
import com.company.model.Item;
import com.company.model.NPC;
import com.company.model.Player;

import java.util.Random;

import static com.company.controller.InventoryController.addItemToInventory;
import static com.company.service.CharacterService.addingMoney;
import static com.company.service.CharacterService.setPlayerTotalCharacteristics;
import static com.company.view.FightView.fightingMessages;
import static com.company.view.IOView.gameLoopView;
import static com.company.view.IOView.mainLoopView;

public class FightService {

    public static void initialTurn(NPC enemy, Player player, boolean turn) {
        while (true) {
            if (player.getTotalSpeed() <= enemy.getTotalSpeed()) {
                if (turn) enemyTurn(enemy, player);
                else playerTurn(enemy, player);
            } else {
                if (turn) playerTurn(enemy, player);
                else enemyTurn(enemy, player);
            }
        }
    }

    public static void enemyTurn(NPC enemy, Player player) {
        if (!attackSuccess(enemy, player)) {
            fightingMessages("5", enemy, player);
            fightResult(enemy, player, "player");
        } else {
            fightingMessages("1", enemy, player);
            player.setHealthPoints(player.getHealthPoints() - fightDamage(enemy, player));
            fightingMessages("3", enemy, player);
            fightResult(enemy, player, "player");
        }
    }

    public static int fightDamage(Character attacker, Character defender) {
        return (attacker.getTotalStrength() * (attacker.getTotalStrength() / defender.getTotalDefense()) + 5);
    }

    public static void playerTurn(NPC enemy, Player player) {
        if (!attackSuccess(player, enemy)) {
            fightingMessages("6", enemy, player);
            fightResult(enemy, player, "enemy");
        } else {
            fightingMessages("2", enemy, player);
            enemy.setHealthPoints(enemy.getHealthPoints() - fightDamage(player, enemy));
            fightingMessages("4", enemy, player);
            fightResult(enemy, player, "enemy");
        }
    }

    public static void fightResult(NPC enemy, Player player, String nextTurn) {
        if (player.getHealthPoints() <= 0) mainLoopView();
        else if (enemy.getHealthPoints() <= 0) {
            levelUp(player);
            fightingMessages("9", enemy, player);
            fightingMessages("10", enemy, player);
            Item newItem = enemy.getTreasure();
            player.setInventory(addItemToInventory(player.getInventory().getItems(), player.getInventory(), newItem));
            addingMoney(player, enemy);
            gameLoopView(player);
        } else {
            switch (nextTurn) {
                case "enemy": {
                    enemyTurn(enemy, player);
                    break;
                }
                case "player": {
                    playerTurn(enemy, player);
                    break;
                }
            }
        }
    }

    public static boolean attackSuccess(Character attacker, Character defender) {
        Random r = new Random();
        int dexterityDif = attacker.getDexterity() - defender.getDexterity();
        double maxValue = 15 - (1.0 * dexterityDif) / 2;
        double probability;
        if (maxValue <= 1) probability = r.nextDouble(1);
        else probability = r.nextDouble(maxValue - 1) + 1;
        double result = 7.5 + (1.0 * dexterityDif) / 2;
        return (result >= probability);
    }

    public static void levelUp(Player player) {
        player.setLevel(player.getLevel() + 1);
        player.setMaxHealthPoints(player.getMaxHealthPoints() + valueGained() * 5);
        player.setStrength(player.getStrength() + valueGained());
        player.setDefense(player.getDefense() + valueGained());
        player.setSpeed(player.getSpeed() + valueGained());
        player.setDexterity(player.getDexterity() + valueGained());
        setPlayerTotalCharacteristics(player);
    }

    public static int valueGained() {
        Random r = new Random();
        return r.nextInt(3 - 1) + 1;
    }
}

package main.com.company.service;

import main.com.company.model.Character;
import main.com.company.model.Item;
import main.com.company.model.NPC;
import main.com.company.model.Player;
import main.com.company.controller.InventoryController;
import main.com.company.view.FightView;
import main.com.company.view.IOView;

import java.util.Random;

import static main.com.company.controller.FightController.duringFight;

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
            FightView.fightingMessages("5", enemy, player);
            fightResult(enemy, player, "player");
        } else {
            FightView.fightingMessages("1", enemy, player);
            player.setHealthPoints(player.getHealthPoints() - fightDamage(enemy, player));
            FightView.fightingMessages("3", enemy, player);
            fightResult(enemy, player, "player");
        }
    }

    public static int fightDamage(Character attacker, Character defender) {
        return (attacker.getTotalStrength() * (attacker.getTotalStrength() / defender.getTotalDefense()) + 5);
    }

    public static void playerTurn(NPC enemy, Player player) {


        // Menu Options during Fight
        duringFight(player,enemy);

        if (!attackSuccess(player, enemy)) {
            FightView.fightingMessages("6", enemy, player);
            fightResult(enemy, player, "enemy");
        } else {
            FightView.fightingMessages("2", enemy, player);
            enemy.setHealthPoints(enemy.getHealthPoints() - fightDamage(player, enemy));
            FightView.fightingMessages("4", enemy, player);
            fightResult(enemy, player, "enemy");
        }
    }

    public static void fightResult(NPC enemy, Player player, String nextTurn) {
        if(nextTurn.equals("exit")) IOView.gameLoopView(player);
        if (player.getHealthPoints() <= 0) IOView.mainLoopView();
        else if (enemy.getHealthPoints() <= 0) {
            levelUp(player);
            FightView.fightingMessages("9", enemy, player);
            FightView.fightingMessages("10", enemy, player);
            Item newItem = enemy.getTreasure();
            player.setInventory(InventoryController.addItemToInventory(player.getInventory().getItems(), player.getInventory(), newItem));
            CharacterService.addingMoney(player, enemy);
            IOView.gameLoopView(player);
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
        CharacterService.setPlayerTotalCharacteristics(player);
    }

    public static int valueGained() {
        Random r = new Random();
        return r.nextInt(3 - 1) + 1;
    }
}

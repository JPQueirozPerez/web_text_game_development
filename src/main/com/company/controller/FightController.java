package main.com.company.controller;

import main.com.company.model.NPC;
import main.com.company.model.Player;
import main.com.company.view.FightView;

import static main.com.company.service.FightService.initialTurn;

public class FightController {

    public static Player fighting(Player player) {
        int level = player.getLevel();
        NPC enemy = CharacterController.createEnemyPlaceholder(level);
        FightView.enemyPresentationMessage(enemy);
        FightView.enemyLevel(enemy.getLevel());
        initialTurn(enemy, player, true);
        return player;
    }
}



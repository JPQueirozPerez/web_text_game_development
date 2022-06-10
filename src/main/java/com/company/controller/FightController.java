package com.company.controller;

import com.company.model.NPC;
import com.company.model.Player;

import static com.company.controller.CharacterController.createEnemyPlaceholder;
import static com.company.service.FightService.initialTurn;
import static com.company.view.FightView.enemyPresentationMessage;

public class FightController {

    public static Player fighting(Player player) {
        NPC enemy = createEnemyPlaceholder();
        enemyPresentationMessage(enemy);
        initialTurn(enemy, player, true);
        return player;
    }
}



package main.com.company.controller;

import main.com.company.model.NPC;
import main.com.company.model.Player;
import main.com.company.view.FightView;

import static main.com.company.service.FightService.initialTurn;
import static main.com.company.view.FightView.*;

public class FightController {

    public static Player fighting(Player player) {
        int level = player.getLevel();
        NPC enemy = CharacterController.createEnemyPlaceholder(level);
        FightView.enemyPresentationMessage(enemy);
        initialTurn(enemy, player, true);
        return player;
    }

    public static void duringFight(Player player, NPC enemy) {
        showHeathMenu(player,enemy);
        menuDuringFight();
        actionOptionDuringFight(player,enemy);

    }


}



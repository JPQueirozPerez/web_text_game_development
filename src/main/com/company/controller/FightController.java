package main.com.company.controller;

import main.com.company.model.NPC;
import main.com.company.model.Player;
import main.com.company.service.FightService;
import main.com.company.view.FightView;
import org.springframework.stereotype.Controller;


import static main.com.company.view.FightView.*;

@Controller
public class FightController {

    public static Player fighting(Player player) {
        int level = player.getLevel();
        NPC enemy = CharacterController.createEnemyPlaceholder(level);
        FightView.enemyPresentationMessage(enemy);
        FightService.initialTurn(enemy, player, true);
        return player;
    }

    public void duringFight(Player player, NPC enemy) {
        showHeathMenu(player,enemy);
        menuDuringFight();
        actionOptionDuringFight(player,enemy);

    }


}



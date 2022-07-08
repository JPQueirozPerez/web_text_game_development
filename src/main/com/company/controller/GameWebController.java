package main.com.company.controller;

import main.com.company.model.NPC;
import main.com.company.model.Player;
import main.com.company.service.*;
import main.com.company.servicejpa.ServiceCharacterJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import static main.com.company.controller.CharacterController.createPlayer;

@Controller
@RequestMapping("/game")
@SessionAttributes({"player", "enemy"})
public class GameWebController {
    @Autowired
    CharacterService characterService;

    @Autowired
    CraftService craftService;

    @Autowired
    EquipmentService equipmentService;

    @Autowired
    FightService fightService;

    @Autowired
    InventoryService inventoryService;

    @Autowired
    ItemService itemService;

    @Autowired
    ShopService shopService;

    @Autowired
    ServiceCharacterJPA serviceCharacterJPA;

    @RequestMapping("/index")
    public String getWeb() {
        return "index";
    }

    @RequestMapping("/newGame")
    public String newGame(Model classesFromController) {
        classesFromController.addAttribute("classesFromController",
                serviceCharacterJPA.findAllClasses());
        return "newGame";
    }

    @RequestMapping("/newPlayer")
    public String newPlayer(@RequestParam("name") String name, @RequestParam("charClass") String charClass, Model playerFromController){
        Player player = createPlayer(name, charClass);
        playerFromController.addAttribute("player", player);
        return "redirect:mainGame";
    }

    @RequestMapping("/mainGame")
    public String mainGame(Model playerFromController) {
        playerFromController.getAttribute("player");
        return "game";
    }

    @RequestMapping("/inventory")
    public String inventory(Model playerFromController) {
        playerFromController.getAttribute("player");
        return "inventory";
    }

    @RequestMapping("/item")
    public String item(Model playerFromController) {
        playerFromController.getAttribute("player");
        InventoryService.equippingOrUsingObject((Player) playerFromController.getAttribute("player"), 0);
        return "redirect:inventory";
    }

    @RequestMapping("/character")
    public String character(Model playerFromController) {
        playerFromController.getAttribute("player");
        return "character";
    }

    @RequestMapping("/newEnemy")
    public String newEnemy(Model enemyFromController, Model playerFromController){
        Player player = (Player) playerFromController.getAttribute("player");
        NPC enemy = CharacterController.createEnemyPlaceholder(player.getLevel());
        playerFromController.addAttribute("enemy", enemy);
        return "redirect:fight";
    }

    @RequestMapping("/fight")
    public String fight(Model playerFromController, Model enemyFromController) {
        enemyFromController.getAttribute("enemy");
        playerFromController.getAttribute("player");
//        Player player = FightController.fighting((Player) playerFromController.getAttribute("player"));
//        playerFromController.addAttribute("player", player);
        return "fight";
    }

    @RequestMapping("/underConstruction")
    public String underConstruction() {
        return "underConstructionPage";
    }
}

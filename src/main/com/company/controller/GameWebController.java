package main.com.company.controller;

import main.com.company.model.Inventory;
import main.com.company.model.NPC;
import main.com.company.model.Player;
import main.com.company.service.*;
import main.com.company.servicejpa.ServiceCharacterJPA;
import main.com.company.servicejpa.ServiceCraftJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import static main.com.company.controller.CharacterController.createPlayer;

@Controller
@RequestMapping("/game")
@SessionAttributes({"player", "enemy", "shopInventory"})
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

    @Autowired
    ServiceCraftJPA serviceCraftJPA;

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
    public String mainGame() {
        return "game";
    }

    @RequestMapping("/inventory")
    public String inventory(Model playerFromController) {
        playerFromController.getAttribute("player");
        return "inventory";
    }

    @RequestMapping("/item")
    public String item(Model playerFromController, @RequestParam("option") int option) {
        Player player = (Player) playerFromController.getAttribute("player");
        InventoryService.equippingOrUsingObject(player, player.getInventory().getItems().get(option).getIndex());
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
        enemyFromController.addAttribute("enemy", enemy);
        return "redirect:fight";
    }

    @RequestMapping("/fight")
    public String fight(Model playerFromController, Model enemyFromController) {
        NPC enemy = (NPC) enemyFromController.getAttribute("enemy");
        Player player = (Player) playerFromController.getAttribute("player");
        if(player.getHealthPoints() <= 0) return "redirect:index";
        else if(enemy.getHealthPoints() <= 0) return "redirect:mainGame";
        else return "fight";
    }

    @RequestMapping("/attack")
    public String attack(Model playerFromController, Model enemyFromController){
        NPC enemy = (NPC) enemyFromController.getAttribute("enemy");
        Player player = (Player) playerFromController.getAttribute("player");
        if(player.getTotalSpeed() <= enemy.getTotalSpeed()) FightService.enemyTurn(enemy, player);
        else FightService.playerTurn(enemy, player);
        return "redirect:fight";
    }

    @RequestMapping("/shopInventory")
    public String shopInventory(Model shopInventoryFromController){
        Inventory inventory = ShopController.createShopInventory();
        shopInventoryFromController.addAttribute("shopInventory", inventory);
        return "shop";
    }


    @RequestMapping("/shop")
    public String shop(Model playerFromController, Model shopInventoryFromController){ //TODO problem with instanceOf
        Inventory shopInventory = (Inventory) shopInventoryFromController.getAttribute("shopInventory");
        Player player = (Player) playerFromController.getAttribute("player");
        return "shop"; //TODO Shop inventory only having 100 items and not 200
    }

    @RequestMapping("/buy")
    public String buy(Model playerFromController, Model shopInventoryFromController, @RequestParam("option") int option){
        Inventory shopInventory = (Inventory) shopInventoryFromController.getAttribute("shopInventory");
        Player player = (Player) playerFromController.getAttribute("player");
        ShopService.shopping(1, shopInventory, option, player, 1);
        return "redirect:shop";
    }

    @RequestMapping("/sell")
    public String sell(Model playerFromController, Model shopInventoryFromController, @RequestParam("option") int option){
        Inventory shopInventory = (Inventory) shopInventoryFromController.getAttribute("shopInventory");
        Player player = (Player) playerFromController.getAttribute("player");
        ShopService.shopping(2, shopInventory, option, player, 1);
        return "redirect:shop";
    }

    @RequestMapping("/craft") //TODO show recipes list
    public String craft(Model craftListFromController, Model playerFromController){
        Player player = (Player) playerFromController.getAttribute("player");
        craftListFromController.addAttribute("craftList", serviceCraftJPA.findAll());
        return "craft";
    }

    @RequestMapping("/underConstruction")
    public String underConstruction() {
        return "underConstructionPage";
    }
}

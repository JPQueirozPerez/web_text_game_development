package main.com.company;

import main.com.company.model.*;
import main.com.company.repository.RepositoryChar;
import main.com.company.repository.RepositoryItem;
import main.com.company.view.IOView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

import static main.com.company.controller.CharacterController.enemyLevelCalculation;
import static main.com.company.service.InventoryService.createItem;


@SpringBootApplication
public class DemoApplication {

	@Autowired
	static RepositoryChar repoChar;

	@Autowired
	static RepositoryItem repoitem;





	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);


	public static void main(String[] args)  {

		SpringApplication.run(DemoApplication.class, args);
		save(repoChar,repoitem);
		IOView.mainLoopView();
	}
	@Bean

	public  static CommandLineRunner save(RepositoryChar repoc,RepositoryItem repoitem)  {

		return args -> {
			List<Item> items = new ArrayList<>();
			Inventory playerInventory = new Inventory(10, items);
			List<EquippableItem> equipments = new ArrayList<>();
			Equipment playerEquipment = new Equipment(0, 0, 0, 0, equipments);


            Player player1 = new Player("null", 1, playerInventory, playerEquipment, 100, 100, 10, 15, 20, 20, "Cleric", 5, 0, 0,"Tunic", 100);
            Player player2 = new Player("null", 1, playerInventory, playerEquipment, 100, 100, 10, 15, 25, 15, "Mage", 5, 0, 0,"Tunic", 100);
            Player player3 = new Player("null", 1, playerInventory, playerEquipment, 90, 90, 15, 10, 25, 25, "Monk", 5, 0, 0,"Wooden stick", 100);
            Player player4 = new Player("null", 1, playerInventory, playerEquipment, 120, 120, 15, 15, 15, 10, "Paladin", 5, 0, 0,"Sword", 100);
            Player player5 = new Player("null", 1, playerInventory, playerEquipment, 100, 100, 10, 10, 20, 25, "Hunter", 5, 0, 0,"Bow", 100);
            Player player6 = new Player("null", 1, playerInventory, playerEquipment, 90, 90, 15, 15, 20, 25, "Rogue", 5, 0, 0,"Dagger", 100);
            Player player7 = new Player("null", 1, playerInventory, playerEquipment, 100, 100, 25, 15, 10, 15, "Warrior", 5, 0, 0,"Sword", 100);
			List<Player> players = new ArrayList<>();
			players.add(player1);
			players.add(player2);
			players.add(player3);
			players.add(player4);
			players.add(player5);
			players.add(player6);
			players.add(player7);


			repoc.saveAll(players);

			Player player = new Player();

			int level = enemyLevelCalculation(player.getLevel());

			Item newItem2 = new EquippableItem("Tunic", "cloth", "A simple tunic", 2, 1, 0, 0, 1, 0, 0,1);
			Item newItem3 = new EquippableItem("Wooden stick", "weapon", "A simple stick made of wood", 1, 1, 0, 0, 0, 0, 1,2);
			Item newItem4 = new EquippableItem("Sword", "weapon", "A simple sword", 7, 1, 0, 0, 0, 0, 4,3);
			Item newItem5 = new EquippableItem("Bow", "weapon", "A simple bow", 4, 1, 0, 0, 0, 0, 2,4);
			Item newItem6 = new EquippableItem("Dagger", "weapon", "A simple dagger", 3, 1, 0, 0, 0, 0, 2,7);
			EquippableItem reward1 = new EquippableItem("Great armour", "armour", "A heavy armour with a good defense", 15, 1, 0, 0, 10, -3, 0,5);
			EquippableItem reward2 = new EquippableItem("Helmet", "armour", "A basic iron helmet", 5, 1,0, 0, 2, 0, 0,6);
			repoitem.save(reward1);
			repoitem.save(reward2);
			repoitem.save(newItem2);
			repoitem.save(newItem3);
			repoitem.save(newItem4);
			repoitem.save(newItem5);
			repoitem.save(newItem5);
			repoitem.save(newItem6);


			Item fur = new Item("Fur", "material", "The fur of an wild animal", 1, 1);
			Item clay = new Item("Clay", "material", "A handful of clay", 1, 1);

			NPC enemy1 = new NPC("Goblin", level, createItem(), 20 + (level * 4), 20 + (level * 4), 20 + (level * 3), 5 + level, 25 + (level * 4), 25 + (level * 2), "enemy", 5, 40 * level, 0,1);
			NPC enemy2 = new NPC("Wolf", level, fur, 10 + level, 10 + level, 10 + (level * 2), 15 + (level * 2), 35 + (level * 4), 5 * level, "beast", 0, 5 * level, 0,2);
			NPC enemy3 = new NPC("Burglar", level, createItem(), 25 + (level * 2), 25 + (level * 2), 15 + (level * 2), 15 + (level * 2), 15 + (level * 2), 15 + (level * 2), "enemy", 20, 5 * level, 0,3);
			NPC enemy4 = new NPC("Witch", level, createItem(), 20 + (level * 3), 20 + (level * 3), 10 + level, 15 + level, 25 + (level * 2), 15 + (level * 2), "enemy", 5, 5 * level, 0,4);
			NPC enemy5 = new NPC("Ratman", level, fur, 25 + level, 25 + level, 20 + (level * 2), 10 + level, 20 + (level * 2), 10 + level, "beast", 0, 5 * level, 0,5);
			NPC enemy6 = new NPC("Wild boar", level, fur, 10 + level, 10 + level, 10 + level, 10 + level, 25 + (level * 3), 10 + level, "beast", 0, 5 * level, 0,6);
			NPC enemy7 = new NPC("Vampire", level, createItem(), 40  + (level * 4), 40  + (level * 4), 20  + (level * 2), 10 + level, 15 + level, 15 + level, "enemy", 10, 5  * level, 0,7);
			NPC enemy8 = new NPC("Wendigo", level, fur, 25  + (level * 2), 25  + (level * 2), 25 + level, 5  + (level * 3), 25 + level, 5  + (level * 3), "beast", 0, 5  * level, 0,8);
			NPC enemy9 = new NPC("Golem", level, clay, 45 + (level * 5), 45 + (level * 5), 35 + (level * 3), 25 + (level * 2), 10 + level, 10 + level, "golem", 0, 5  * level, 0,9);
			NPC enemy10 = new NPC("Cave lion", level, fur, 15 + level, 15 + level, 15 + level, 15 + level, 25  + (level * 2), 5  + (level * 2), "beast", 0, 5  * level, 0,10);
			NPC enemy11 = new NPC("Soldier", level, createItem(), 50 + (level * 4), 50 + (level * 4), 25 + (level * 3), 15  + (level * 2), 5 + level, 20  + (level * 2), "enemy", 15, 5  * level, 0,11);
			repoc.save(enemy1);
			repoc.save(enemy2);
			repoc.save(enemy3);
			repoc.save(enemy4);
			repoc.save(enemy5);
			repoc.save(enemy6);
			repoc.save(enemy7);
			repoc.save(enemy8);
			repoc.save(enemy9);
			repoc.save(enemy10);
			repoc.save(enemy11);





		};
	}


}

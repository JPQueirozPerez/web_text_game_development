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


            Player player1 = new Player("null", 1, playerInventory, playerEquipment, 100, 100, 10, 15, 20, 20, "Cleric", 5, 0, 0,"Tunic");
            Player player2 = new Player("null", 1, playerInventory, playerEquipment, 100, 100, 10, 15, 25, 15, "Mage", 5, 0, 0,"Tunic");
            Player player3 = new Player("null", 1, playerInventory, playerEquipment, 90, 90, 15, 10, 25, 25, "Monk", 5, 0, 0,"Wooden stick");
            Player player4 = new Player("null", 1, playerInventory, playerEquipment, 120, 120, 15, 15, 15, 10, "Paladin", 5, 0, 0,"Sword");
            Player player5 = new Player("null", 1, playerInventory, playerEquipment, 100, 100, 10, 10, 20, 25, "Hunter", 5, 0, 0,"Bow");
            Player player6 = new Player("null", 1, playerInventory, playerEquipment, 90, 90, 15, 15, 20, 25, "Rogue", 5, 0, 0,"Dagger");
            Player player7 = new Player("null", 1, playerInventory, playerEquipment, 100, 100, 25, 15, 10, 15, "Warrior", 5, 0, 0,"Sword");
			List<Player> players = new ArrayList<>();
			players.add(player1);
			players.add(player2);
			players.add(player3);
			players.add(player4);
			players.add(player5);
			players.add(player6);
			players.add(player7);


			repoc.saveAll(players);



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

			NPC enemy1 = new NPC("Goblin", 5, createItem(), 20, 20, 20, 5, 25, 25, "enemy", 5, 5, 0,1);
			NPC enemy2 = new NPC("Wolf", 5, fur, 10, 10, 10, 15, 35, 5, "beast", 0, 5, 0,2);
			NPC enemy3 = new NPC("Burglar", 5, createItem(), 25, 25, 15, 15, 15, 15, "enemy", 20, 5, 0,3);
			NPC enemy4 = new NPC("Witch", 5, createItem(), 20, 20, 10, 15, 25, 15, "enemy", 5, 5, 0,4);
			NPC enemy5 = new NPC("Ratman", 5, fur, 25, 25, 20, 10, 20, 10, "beast", 0, 5, 0,5);
			NPC enemy6 = new NPC("Wild boar", 5, fur, 10, 10, 10, 10, 25, 10, "beast", 0, 5, 0,6);
			NPC enemy7 = new NPC("Vampire", 5, createItem(), 40, 40, 20, 10, 15, 15, "enemy", 10, 5, 0,7);
			NPC enemy8 = new NPC("Wendigo", 5, fur, 25, 25, 25, 5, 25, 5, "beast", 0, 5, 0,8);
			NPC enemy9 = new NPC("Golem", 5, clay, 45, 45, 35, 25, 10, 10, "golem", 0, 5, 0,9);
			NPC enemy10 = new NPC("Cave lion", 5, fur, 15, 15, 15, 15, 25, 5, "beast", 0, 5, 0,10);
			NPC enemy11 = new NPC("Soldier", 5, createItem(), 50, 50, 25, 15, 5, 20, "enemy", 15, 5, 0,11);
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

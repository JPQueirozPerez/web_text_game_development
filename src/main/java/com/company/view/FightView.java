package com.company.view;

import com.company.model.NPC;
import com.company.model.Player;
import com.company.service.FightService;


public class FightView {

    public static void fightingMessages(String value, NPC enemy, Player player) {
        switch (value) {
            case "1": {
                System.out.println("Your enemy successes their attack!");
                break;
            }
            case "2": {
                System.out.println("You successes your attack!");
                break;
            }
            case "3": {
                System.out.println("The enemy makes you "  + FightService.fightDamage(enemy, player) + " points "  + "of damage!");
                break;
            }
            case "4": {
                System.out.println("You makes "  + FightService.fightDamage(player, enemy) + " points "  + "of damage to your enemy!");
                break;
            }
            case "5": {
                System.out.println("Your enemy has failed, now is your turn!");
                break;
            }
            case "6": {
                System.out.println("You have failed, now is your enemy's turn!");
                break;
            }
            case "7": {
                System.out.println("You have failed, try again!");
                break;
            }
            case "8": {
                System.out.println("Your enemy has failed, they will try again!");
                break;
            }
            case "9": {
                System.out.println("You have leveled up! Your level is now "  + player.getLevel() );
                break;
            }
            case "10": {
                System.out.println("You're stronger! Now your strength is " + player.getStrength()  + ", your defense is "
                         + player.getDefense()  + ", your speed is "  + player.getSpeed()  + ", your dexterity is "
                         + player.getDexterity()  + " and you have "  + player.getMaxHealthPoints() + " HP");
                break;
            }
            case "11": {
                System.out.println("You need to attack again");
                break;
            }
        }
    }

    public static void enemyPresentationMessage(NPC enemy) {
        switch (enemy.getName()) {
            case "Goblin": {
                System.out.println("\nYou found a greenish creature; is somewhat an caricature of a human, with a long bulbous nose, big pointy ears and a enormous mouth. You found yourself facing a " +  enemy.getName() +  ".");
                break;
            }
            case "Wolf": {
                System.out.println("\nIn front of you theres a rabid "  + enemy.getName()  + ". Maybe you don't like killing innocent creatures, but this one stopped being so a long time ago.");
                break;
            }
            case "Burglar": {
                System.out.println("\nThe evil can take many forms; for example the "  + enemy.getName() + " in front of you, motivated by greed and willing to kill you for whatever you have on you.");
                break;
            }
            case "Witch": {
                System.out.println("\nThere are some corrupt magic users; servants of dark gods who do bloody rituals. Before you stands one of them, a "  + enemy.getName()  + ".");
                break;
            }
            case "Ratman": {
                System.out.println("\nIs that a man, or perhaps a beast? It doesn't matter, that "  + enemy.getName()  + " only wants to kill you.");
                break;
            }
            case "Wild boar": {
                System.out.println("\nNormally a "  + enemy.getName()  + " like the one in front of you can be dangerous, but the rabies in this one makes it deadly.");
                break;
            }
            case "Vampire": {
                System.out.println("\nSometimes the dead cannot rest. So they come out of their graves and look for prey to feed on; if you don't kill this "  + enemy.getName()  + " you will be that prey.");
                break;
            }
            case "Wendigo": {
                System.out.println("\nHunger can drive a man to do crazy things, but certain lines must not be crossed, even if one is desperate. When a man decides to feed on a fellow, he becomes a grotesque and unreal creature; a "  + enemy.getName()  + ", like the one before you.");
                break;
            }
            case "Soldier": {
                System.out.println("\nNot everyone trusts you and your mission; this " + enemy.getName()  + " before you is going to give his life to prevent you from carrying it out. Are you going to kill him or will you prefer to escape and spare his life?");
                break;
            }
            case "Golem": {
                System.out.println("\nThe once inanimate now walks; this "  + enemy.getName()  + " is a demonstration of the infinite possibilities of magic, but if you marvel too much, you may end up falling victim to its inhuman strength.");
                break;
            }
            case "Cave lion": {
                System.out.println("\nFrom the frozen southern mountains has came this "  + enemy.getName()  + ". Aforetime it was a magnificent animal, but nowadays is only a rabid bloodthirsty beast.");
                break;
            }
        }
    }
}

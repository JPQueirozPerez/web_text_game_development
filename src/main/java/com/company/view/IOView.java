
package com.company.view;

import com.company.model.Player;

import java.util.Scanner;

import static com.company.frontcontroller.FrontController.gameLoopController;
import static com.company.frontcontroller.FrontController.mainLoopController;
import static com.company.utils.Utilities.ask;
//import static com.company.view.Menu.mainMenuView;
//import static com.company.view.Menu.menuNewGameView;

public class IOView {

    public static void mainLoopView() {

        while (true) {
            Menu.mainMenuView();
            String option = menuOption();
            switch (option) {
                case "1": {
                    mainLoopController("1");
                    break;
                }
                case "0": {
                    finishGameView();
                    break;
                }
                default: {
                    System.out.println("Unknown option. Try again");
                    break;
                }
            }
        }
    }

    public static void gameLoopView(Player player) {

        while (true) {
            Menu.menuNewGameView();
            String option = menuOption();

            switch (option) {

                case "1": {
                    gameLoopController("1", player);
                    break;
                }
                case "2": {
                    gameLoopController("2", player);
                    break;
                }
                case "3": {
                    gameLoopController("3", player);
                    break;
                }
                case "4": {
                    gameLoopController("4", player);
                    break;
                }
                case "5": {
                    gameLoopController("5", player);
                    break;
                }
                case "0": {
                    mainLoopView();
                    break;
                }
                default: {
                    System.out.println("Unknown option. Try again");
                    break;
                }
            }
        }
    }

    public static String menuOption(){
        Scanner reader = new Scanner(System.in);
        String option;
        return option = ask(reader, "Choose an option");
    }

    public static void finishGameView() {
        //Exit program
        System.out.println("We hope to see you soon, adventurer!");
        System.exit(0);
    }
}


package com.company.view;

import com.company.model.Player;
import com.company.utils.Utilities;

import java.util.Scanner;

import static com.company.controller.CharacterController.createPlayer;
import static com.company.frontcontroller.FrontController.gameLoopController;
import static com.company.utils.Utilities.*;
import static com.company.view.CharacterView.showClass;
import static com.company.view.Menu.*;


import static com.company.frontcontroller.FrontController.mainLoopController;

public class IOView {

    public static void mainLoopView() {
        Scanner reader = new Scanner(System.in);

        while (true) {
            mainMenuView();
            String keyMenuMain = reader.nextLine();
            switch (keyMenuMain) {
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

        Scanner reader = new Scanner(System.in);

        while (true) {
            menuNewGameView();
            String keyMenuNewGame = reader.nextLine();

            switch (keyMenuNewGame) {

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

    public static void finishGameView() {
        //Exit program
        System.out.println("We hope to see you soon, adventurer!");
        System.exit(0);
    }
}

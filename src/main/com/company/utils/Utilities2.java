package main.com.company.utils;

import java.util.Scanner;

public class Utilities2 {

        public static String ask(Scanner scanner, String text) {
        System.out.println(text);
        return scanner.next();
    }
}
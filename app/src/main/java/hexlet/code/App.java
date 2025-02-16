package hexlet.code;

//import java.util.InputMismatchException;
import hexlet.code.games.*;

import java.util.Scanner;

class App {
    static String userName4Print;
//    enum MENU_OPTIONS {
//        EXIT,
//        GREET,
//        EVEN,
//        CALC,
//        GCD,
//        PROGRESSION,
//        PRIME
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int userGameChoice;
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet\n" +
                           "2 - Even\n" +
                           "3 - Calc\n" +
                           "4 - GCD\n" +
                           "5 - Progression\n" +
                           "6 - Prime\n" +
                           "0 - Exit"
        );
        System.out.print("Your choice: ");
        userGameChoice = sc.nextInt();
//        try {
//            userGameChoice = sc.nextInt();
//        } catch (InputMismatchException e) {
//            System.out.println("That's not a number, try again.");
//        }
        if (userGameChoice != 0) {
            System.out.println("Welcome to the Brain Games!");
            System.out.print("May I have your name? ");
            userName4Print = sc.next() + "!"; // сразу добавляем '!', чтобы не прибавлять при каждой печати
            System.out.println("Hello, " + userName4Print);
        }
//        sc.close();
        switch (userGameChoice) {
            case 2:
                Even.start();
                break;
            case 3:
                Calc.start();
                break;
            case 4:
                GCD.start();
                break;
            case 5:
                Progression.start();
                break;
            case 6:
                Prime.start();
                break;
        }
    }
}

package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;
//import java.util.InputMismatchException;

class App {
//    enum MENU_OPTIONS {
//        EXIT,
//        GREET,
//        EVEN,
//        CALC,
//        GCD,
//        PROGRESSION,
//        PRIME
    //    }
    private static Scanner sc;
    public static Scanner getScanner() {
        return sc;
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        final int evenOption = 2;
        final int calcOption = 3;
        final int gcdOption = 4;
        final int progOption = 5;
        final int primeOption = 6;
        int userGameChoice;
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet\n"
                        + "2 - Even\n"
                        + "3 - Calc\n"
                        + "4 - GCD\n"
                        + "5 - Progression\n"
                        + "6 - Prime\n"
                        + "0 - Exit"
        );
        System.out.print("Your choice: ");
        userGameChoice = sc.nextInt();
//        try {
//            userGameChoice = sc.nextInt();
//        } catch (InputMismatchException e) {
//            System.out.println("That's not a number, try again.");
//        }
        if (userGameChoice != 0) {
            Engine.introduction();
        }
        switch (userGameChoice) {
            case evenOption:
                Even.start();
                break;
            case calcOption:
                Calc.start();
                break;
            case gcdOption:
                GCD.start();
                break;
            case progOption:
                Progression.start();
                break;
            case primeOption:
                Prime.start();
                break;
            default:
        }
        sc.close();
    }
}

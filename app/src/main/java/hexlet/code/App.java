package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;

class App {
    private static String username4Print;
    public static String getUsername() {
        return username4Print;
    }
    private static Scanner sc;
    public static Scanner getScanner() {
        return sc;
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        final int exitOption = 0;
        final int greetOption = 1;
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

        if (userGameChoice != exitOption) {
            System.out.println("Welcome to the Brain Games!");
            System.out.print("May I have your name? ");
            username4Print = App.getScanner().next() + "!"; // сразу добавляем '!', чтобы не прибавлять при каждой печати
            System.out.println("Hello, " + username4Print);
        }

        switch (userGameChoice) {
            case exitOption:
            case greetOption:
                break;
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
                throw new RuntimeException("Unknown game choice: " + userGameChoice);
        }
        sc.close();
    }
}

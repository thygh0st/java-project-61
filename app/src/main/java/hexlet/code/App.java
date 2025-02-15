package hexlet.code;

//import java.util.InputMismatchException;
import hexlet.code.games.Calc;
import hexlet.code.games.Engine;
import hexlet.code.games.Even;

import java.util.Scanner;

class App {
    public static void main(String[] args) {
        Engine pGame = null;
        Scanner sc = new Scanner(System.in);
        String userName4Print = "";
        int userGameChoice = 0;
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet\n" +
                           "2 - Even\n" +
                           "3 - Calc\n" +
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
                pGame = new Even(userName4Print);
                break;
            case 3:
                pGame = new Calc(userName4Print);
                break;
        }
        if (pGame != null)
            pGame.start();
    }
}

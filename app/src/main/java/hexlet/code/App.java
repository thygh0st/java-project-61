package hexlet.code;

import java.util.Scanner;

class App {
//    private String userName;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet\n0 - Exit");
        System.out.print("Your choice: ");
        int userGameChoice = sc.nextInt();
        if (userGameChoice != 0) {
            System.out.println("Welcome to the Brain Games!");
            System.out.print("May I have your name? ");
            String userName = sc.next();
            System.out.println("Hello, " + userName + "!");
        }
    }
}

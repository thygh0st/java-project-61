package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int NUMBER_OF_ROUNDS = 3;

    public static void runQuestions(String description, String[][] qaPairs) {
        String userAnswer;
        String username4Print;
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        username4Print = sc.next() + "!";
        System.out.println("Hello, " + username4Print);

        System.out.println(description);
        for (String[] pair : qaPairs) {
            System.out.println("Question: " + pair[0]);
            System.out.print("Your answer: ");
            userAnswer = sc.next();

            if (userAnswer.trim().equals(pair[1])) {
                System.out.println("Correct!");
            } else {
                System.out.println(
                        "'" + userAnswer + "'"
                        + " is wrong answer ;(. Correct answer was "
                        + "'" + pair[1] + "'."
                );
                System.out.println("Let's try again, " + username4Print);
                sc.close();
                return;
            }
        }
        System.out.println("Congratulations, " + username4Print);
        sc.close();
    }
}

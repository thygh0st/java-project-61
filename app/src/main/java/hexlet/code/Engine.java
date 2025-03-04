package hexlet.code;

import java.util.Random;

public class Engine {
    public static final int NUMBER_OF_ROUNDS = 3;
    public static final Random RAND_GEN = new Random();

    public static void runQuestions(String greeting, String[][] pairs) {
        String userAnswer;

        System.out.println(greeting);
        for (String[] pair : pairs) {
            System.out.println("Question: " + pair[0]);
            System.out.print("Your answer: ");
            userAnswer = App.getScanner().next();

            if (userAnswer.trim().equals(pair[1])) {
                System.out.println("Correct!");
            } else {
                System.out.println(
                        "'" + userAnswer + "'"
                        + " is wrong answer ;(. Correct answer was "
                        + "'" + pair[1] + "'."
                );
                System.out.println("Let's try again, " + App.getUsername());
                return;
            }
        }
        System.out.println("Congratulations, " + App.getUsername());
    }
}

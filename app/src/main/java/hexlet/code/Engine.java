package hexlet.code;

import java.util.Random;

public class Engine {
    private static final String WRONG_ANSWER_STR = " is wrong answer ;(. Correct answer was ";
    private static String username4Print;
    public static final int NUMBER_OF_ROUNDS = 3;
    public static final Random RAND_GEN = new Random();

    public static void introduction() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        username4Print = App.getScanner().next() + "!"; // сразу добавляем '!', чтобы не прибавлять при каждой печати
        System.out.println("Hello, " + username4Print);
    }
    public static void runQuestions(String greeting, String[][] pairs) {
        String userAnswer;
        int iter;

        System.out.println(greeting);
        for (iter = 0; iter < NUMBER_OF_ROUNDS; iter++) {
            System.out.println("Question: " + pairs[0][iter]);
            System.out.print("Your answer: ");
            userAnswer = App.getScanner().next();
            if (userAnswer.trim().equals(pairs[1][iter])) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "'" + WRONG_ANSWER_STR + "'" + pairs[1][iter] + "'.");
                break;
            }
        }
        if (iter == NUMBER_OF_ROUNDS) {
            System.out.println("Congratulations, " + username4Print);
        } else {
            System.out.println("Let's try again, " + username4Print);
        }
    }
}

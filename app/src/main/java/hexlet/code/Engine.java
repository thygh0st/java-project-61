package hexlet.code;

import java.util.Scanner;
import java.util.Random;

public class Engine {
    private static final String WRONG_ANSWER_STR = " is wrong answer ;(. Correct answer was ";
    public static final int NUMBER_OF_ROUNDS = 3;
    public static final Random RAND_GEN = new Random();

    public static boolean runQuestion(String question, String calculatedAnswer) {
        int iter;
        String userAnswer;

        System.out.println("Question: " + question);
        Scanner sc = new Scanner(System.in);
        System.out.print("Your answer: ");
        userAnswer = sc.next();
        if (calculatedAnswer.equals(userAnswer)) {
            System.out.println("Correct!");
            return true;
        } else {
            System.out.println("'" + userAnswer + "'" + WRONG_ANSWER_STR + "'" + calculatedAnswer + "'.");
            return false;
        }
    }

    public static void success() {
        System.out.println("Congratulations, " + App.getUserName());
    }
    public static void failure() {
        System.out.println("Let's try again, " + App.getUserName());
    }
}

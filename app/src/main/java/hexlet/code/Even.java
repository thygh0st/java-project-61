package hexlet.code;

import java.util.Random;
import java.util.Scanner;

class Even {
    public static void start(String userName) {
        Random randGenerator = new Random();
        int randNumber;
        int iter;
        final int MAX_GAME_VALUE = 200;
        String userAnswer;
        String calculatedAnswer;
        String wrongAnswerString = " is wrong answer ;(. Correct answer was ";

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        for (iter = 0; iter < 3; iter++) {
            randNumber = randGenerator.nextInt(MAX_GAME_VALUE);
            if (randNumber % 2 == 1)
                calculatedAnswer = "no";
            else
                calculatedAnswer = "yes";
            System.out.println("Question: " + randNumber);
            Scanner sc = new Scanner(System.in);
            System.out.print("Your answer: ");
            userAnswer = sc.next();
//            if (calculatedAnswer.equalsIgnoreCase()) { // TODO: какой уровень паранойи?
            if (calculatedAnswer.equals(userAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "'" + wrongAnswerString + "'" + calculatedAnswer + "'.");
                System.out.println("Let's try again, " + userName);
                break;
            }
        }
        if (iter == 3)
            System.out.println("Congratulations, " + userName);
    }
}

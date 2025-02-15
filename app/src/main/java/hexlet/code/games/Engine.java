package hexlet.code.games;

import java.util.Scanner;
import java.util.Random;

public abstract class Engine {
    String userName;
    String wrongAnswerString = " is wrong answer ;(. Correct answer was ";
    String gameGreetingString;
    String calculatedAnswer;
    Random randGenerator = new Random();

    abstract String generateQuestion();
    abstract boolean compareResult(String result/*, String reference*/);

    Engine(String userName, String gameGreetingString) {
        this.userName = userName;
        this.gameGreetingString = gameGreetingString;
    }
    public void start() {
        int iter;
        String userAnswer;

        System.out.println(gameGreetingString);
        for (iter = 0; iter < 3; iter++) {
            String question = generateQuestion(); // FIXME + и вычисление ответа?
            System.out.println("Question: " + question);
            Scanner sc = new Scanner(System.in);
            System.out.print("Your answer: ");
            userAnswer = sc.next();
            if (compareResult(userAnswer)) {
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

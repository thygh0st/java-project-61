package hexlet.code.games;

import  hexlet.code.Engine;


public class Even {
    private static String question;
    private static String calculatedAnswer;

    private static void runGameLogic() {
        int randNumber;
        final int maxGameValue = 200;
        randNumber = Engine.randGenerator.nextInt(maxGameValue);
        if (randNumber % 2 == 1) {
            calculatedAnswer = "no";
        } else {
            calculatedAnswer = "yes";
        }
        question = Integer.toString(randNumber);
    }

    public static void start() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        boolean isRightAnswer = true;
        int iter = 0;

        for (iter = 0; iter < Engine.NUMBER_OF_ROUNDS; iter++) {
            runGameLogic();
            isRightAnswer = Engine.runQuestion(question, calculatedAnswer);
            if (!isRightAnswer) {
                break;
            }
        }

        if (iter == Engine.NUMBER_OF_ROUNDS) {
            Engine.success();
        } else {
            Engine.failure();
        }
    }
}

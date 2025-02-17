package hexlet.code.games;

import hexlet.code.Engine;

public class GCD {
    private static String question;
    private static String calculatedAnswer;

    private static void runGameLogic() {
        final int maxDivisorValue = 10;

        // простые числа + 1
        final int[] primesPlus = {1, 2, 3, 5, 7, 11, 13, 17};

        int randIndex1 = Engine.randGenerator.nextInt(primesPlus.length);
        int randIndex2;
        do {
            randIndex2 = Engine.randGenerator.nextInt(primesPlus.length);
        } while (randIndex2 == randIndex1);
        int randDivisor = Engine.randGenerator.nextInt(maxDivisorValue) + 1;

        calculatedAnswer = Integer.toString(randDivisor); // алгоритм от обратного, чтобы пользователям было проще
        question = (primesPlus[randIndex1] * randDivisor) + " " + (primesPlus[randIndex2] * randDivisor);
    }

    public static void start() {
        System.out.println("Find the greatest common divisor of given numbers.");
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

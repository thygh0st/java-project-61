package hexlet.code.games;

import hexlet.code.Engine;

public class Progression {
    private static String question;
    private static String calculatedAnswer;

    private static void runGameLogic() {
        final int maxStartNumber = 50;
        final int progressionLength = 10;
        final int maxIncrement = 13;
        int startNumber = Engine.RAND_GEN.nextInt(maxStartNumber);
        int missingIndex = Engine.RAND_GEN.nextInt(progressionLength);
        int increment = Engine.RAND_GEN.nextInt(maxIncrement) + 1;
        StringBuilder resultProg = new StringBuilder();

        calculatedAnswer = Integer.toString(startNumber + missingIndex * increment);

        for (int i = 0; i < progressionLength; i++) {
            if (i == missingIndex) {
                resultProg.append("..");
            } else {
                    resultProg.append(startNumber + i * increment);
            }
            resultProg.append(" ");
        }
        question = resultProg.toString();
    }

    public static void start() {
        System.out.println("What number is missing in the progression?");
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

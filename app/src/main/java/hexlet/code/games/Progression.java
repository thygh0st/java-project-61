package hexlet.code.games;

import hexlet.code.Engine;

public class Progression {
    private static final String[][] QA_PAIRS = new String[2][Engine.NUMBER_OF_ROUNDS];
    private static int missingElem;

    private static int[] genProgArray() {
        final int maxStartNumber = 50;
        final int maxIncrement = 13;
        final int progressionLength = 10;
        int startNumber = Engine.RAND_GEN.nextInt(maxStartNumber);
        int increment = Engine.RAND_GEN.nextInt(maxIncrement) + 1;

        int[] intArray = new int[progressionLength];
        for (int i = 0; i < progressionLength; i++) {
            intArray[i] = startNumber + i * increment;
        }
        return intArray;
    }
    private static String generateQuestion() {
        var initialProg = genProgArray();
        int missingIndex = Engine.RAND_GEN.nextInt(initialProg.length);

        missingElem = initialProg[missingIndex];

        StringBuilder resultProg = new StringBuilder();
        for (int i = 0; i < initialProg.length; i++) {
            if (i == missingIndex) {
                resultProg.append("..");
            } else {
                resultProg.append(initialProg[i]);
            }
            resultProg.append(" ");
        }

        return resultProg.toString();
    }

    public static void start() {
        for (int iter = 0; iter < Engine.NUMBER_OF_ROUNDS; iter++) {
            QA_PAIRS[0][iter] = generateQuestion();
            QA_PAIRS[1][iter] = Integer.toString(missingElem); // переписываем переменную каждую итерацию
        }
        Engine.runQuestions("What number is missing in the progression?", QA_PAIRS);
    }
}

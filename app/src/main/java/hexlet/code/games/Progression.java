package hexlet.code.games;

import hexlet.code.Engine;

public class Progression {
    private static final String[][] QA_PAIRS = new String[Engine.NUMBER_OF_ROUNDS][2];
    private static int missingElem;

    private static int[] genProgArray(int startNumber, int increment, int progressionLength) {
        int[] intArray = new int[progressionLength];
        for (int i = 0; i < progressionLength; i++) {
            intArray[i] = startNumber + i * increment;
        }
        return intArray;
    }
    private static String generateQuestion() {
        final int maxStartNumber = 50;
        final int maxIncrement = 13;
        final int progressionLength = 10;
        int startNumber = Engine.RAND_GEN.nextInt(maxStartNumber);
        int increment = Engine.RAND_GEN.nextInt(maxIncrement) + 1;

        var initialProg = genProgArray(startNumber, increment, progressionLength);
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
        for (var pair : QA_PAIRS) {
            pair[0] = generateQuestion();
            pair[1] = Integer.toString(missingElem); // переписываем переменную каждую итерацию
        }
        Engine.runQuestions("What number is missing in the progression?", QA_PAIRS);
    }
}

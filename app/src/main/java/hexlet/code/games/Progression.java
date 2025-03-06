package hexlet.code.games;

import hexlet.code.Engine;
import static hexlet.code.Utils.generateNumber;

public class Progression {
    private static final String[][] QA_PAIRS = new String[Engine.NUMBER_OF_ROUNDS][2];

    private static String[] genProgArray(int startNumber, int increment, int progressionLength) {
        String[] progStrArray = new String[progressionLength];
        for (int i = 0; i < progressionLength; i++) {
            progStrArray[i] = Integer.toString(startNumber + i * increment);
        }
        return progStrArray;
    }
    private static String[] generatePair() {
        final int maxStartNumber = 50;
        final int maxIncrement = 13;
        final int progressionLength = 10;
        int startNumber = generateNumber(0, maxStartNumber);
        int increment = generateNumber(1, maxIncrement);

        var initialProg = genProgArray(startNumber, increment, progressionLength);
        int missingIndex = generateNumber(0, initialProg.length);

        String[] pairQA = new String[2];
        
        pairQA[1] = initialProg[missingIndex];
        initialProg[missingIndex] = "..";

        pairQA[0] = String.join(" ", initialProg);

        return pairQA;
    }

    public static void start() {
        for (String[] pair : QA_PAIRS) {
            var tempQAPair = generatePair();
            pair[0] = tempQAPair[0];
            pair[1] = tempQAPair[1];
        }
        Engine.runQuestions("What number is missing in the progression?", QA_PAIRS);
    }
}

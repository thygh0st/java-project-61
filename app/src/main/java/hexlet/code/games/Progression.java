package hexlet.code.games;

import hexlet.code.Engine;
import static hexlet.code.Utils.generateNumber;

public class Progression {
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

        String answer = initialProg[missingIndex];
        initialProg[missingIndex] = "..";

        String question = String.join(" ", initialProg);

        return new String[]{question, answer};
    }

    public static void start() {
        String[][] qaPairs = new String[Engine.NUMBER_OF_ROUNDS][2];
        for (String[] pair : qaPairs) {
            var tempQAPair = generatePair();
            pair[0] = tempQAPair[0];
            pair[1] = tempQAPair[1];
        }
        Engine.runQuestions("What number is missing in the progression?", qaPairs);
    }
}

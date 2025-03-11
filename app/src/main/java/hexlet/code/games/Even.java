package hexlet.code.games;

import  hexlet.code.Engine;
import static hexlet.code.Utils.generateNumber;

public class Even {
    private static boolean isEven(int number) {
        return (number % 2 != 1);
    }
    private static String[] generatePair() {
        int randNumber;
        final int maxGameValue = 200;
        randNumber = generateNumber(1, maxGameValue);
        String question = Integer.toString(randNumber);
        String answer = isEven(randNumber) ? "yes" : "no";

        return new String[]{question, answer};
    }

    public static void start() {
        String[][] qaPairs = new String[Engine.NUMBER_OF_ROUNDS][2];
        for (var pair : qaPairs) {
            var tempQAPair = generatePair();
            pair[0] = tempQAPair[0];
            pair[1] = tempQAPair[1];
        }
        Engine.runQuestions("Answer 'yes' if the number is even, otherwise answer 'no'.", qaPairs);
    }
}

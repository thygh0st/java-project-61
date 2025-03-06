package hexlet.code.games;

import  hexlet.code.Engine;
import static hexlet.code.Utils.generateNumber;

public class Even {
    private static final String[][] QA_PAIRS = new String[Engine.NUMBER_OF_ROUNDS][2];

    private static boolean isEven(String number) {
        if (Integer.parseInt(number) % 2 == 1) {
            return false;
        }
        return true;
    }
    private static String generateQuestion() {
        int randNumber;
        final int maxGameValue = 200;
        randNumber = generateNumber(1, maxGameValue);

        return Integer.toString(randNumber);
    }

    public static void start() {
        for (var pair : QA_PAIRS) {
            pair[0] = generateQuestion();
            pair[1] = isEven(pair[0]) ? "yes" : "no";
        }
        Engine.runQuestions("Answer 'yes' if the number is even, otherwise answer 'no'.", QA_PAIRS);
    }
}

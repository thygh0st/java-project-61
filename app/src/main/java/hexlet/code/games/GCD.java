package hexlet.code.games;

import hexlet.code.Engine;
import static hexlet.code.Utils.generateNumber;

public class GCD {
    private static int getPrime() {
        // простые числа + 1
        final int[] primesPlus = {1, 2, 3, 5, 7, 11, 13, 17};
        int randIndex = generateNumber(0, primesPlus.length);
        return primesPlus[randIndex];
    }

    private static String[] generatePair() {
        final int maxDivisorValue = 10;

        int prime1 = getPrime();
        int prime2;
        do {
            prime2 = getPrime();
        } while (prime1 == prime2);
        // алгоритм от обратного, чтобы пользователям было проще
        int divisor = generateNumber(1, maxDivisorValue);

        String question = (prime1 * divisor) + " " + (prime2 * divisor);
        String answer = Integer.toString(divisor);

        return new String[]{question, answer};
    }

    public static void start() {
        String[][] qaPairs = new String[Engine.NUMBER_OF_ROUNDS][2];
        for (var pair : qaPairs) {
            var tempQAPair = generatePair();
            pair[0] = tempQAPair[0];
            pair[1] = tempQAPair[1];
        }
        Engine.runQuestions("Find the greatest common divisor of given numbers.", qaPairs);
    }
}

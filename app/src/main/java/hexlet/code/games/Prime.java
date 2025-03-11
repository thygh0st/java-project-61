package hexlet.code.games;

import hexlet.code.Engine;
import static hexlet.code.Utils.generateNumber;

public class Prime {
    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if ((num % i) == 0) {
                return false;
            }
        }
        return true;
    }
    private static String[] generatePair() {
        int k;
        final int maxKValue = 20;
        final int baseMult = 6;
        // простое число = 6k +- 1;
        // при некоторых k число будет не простое, но будет делиться либо на 5, либо на 7 (в нашем диапазоне k)
        // ограничиваем k > 1, чтобы не добавлять проверку через цикл
        // генерируем числа: 6k - 1 | 6k | 6k + 1
        k = generateNumber(2, maxKValue);
        int baseNum = baseMult * k;
        int offset = generateNumber(0, 2);
        int randNumber = ((generateNumber(0, 2) == 1) ? (baseNum + offset) : (baseNum - offset));

        String question = Integer.toString(randNumber);
        String answer = isPrime(randNumber) ? "yes" : "no";

        return new String[]{question, answer};
    }

    public static void start() {
        String[][] qaPairs = new String[Engine.NUMBER_OF_ROUNDS][2];
        for (var pair : qaPairs) {
            var tempQAPair = generatePair();
            pair[0] = tempQAPair[0];
            pair[1] = tempQAPair[1];
        }
        Engine.runQuestions("Answer 'yes' if given number is prime. Otherwise answer 'no'.", qaPairs);
    }
}

package hexlet.code.games;

import hexlet.code.Engine;
import static hexlet.code.Utils.generateNumber;

public class Prime {
    private static final String[][] QA_PAIRS = new String[Engine.NUMBER_OF_ROUNDS][2];

    private static boolean isPrime(String num) {
        int numInt = Integer.parseInt(num);

        if (numInt < 2) {
            return false;
        }
        for (int i = 2; i < numInt; i++) {
            if ((numInt % i) == 0) {
                return false;
            }
        }
        return true;
    }
    private static String generateQuestion() {
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

        return Integer.toString(randNumber);
    }

    public static void start() {
        for (var pair : QA_PAIRS) {
            pair[0] = generateQuestion();
            pair[1] = isPrime(pair[0]) ? "yes" : "no";
        }
        Engine.runQuestions("Answer 'yes' if given number is prime. Otherwise answer 'no'.", QA_PAIRS);
    }
}

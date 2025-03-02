package hexlet.code.games;

import hexlet.code.Engine;

public class Prime {
    private static final String[][] QA_PAIRS = new String[2][Engine.NUMBER_OF_ROUNDS];

    private static String isPrime(String num) {
        // при некоторых k число будет не простое, но будет делиться либо на 5, либо на 7 (в нашем диапазоне k)
        // при offset == 0 число будет четным
        final int possibleDivisor1 = 5;
        final int possibleDivisor2 = 7;
        final int possibleDivisor3 = 2;
        int numInt = Integer.parseInt(num);

        if ((numInt % possibleDivisor1 == 0) || (numInt % possibleDivisor2 == 0) || (numInt % possibleDivisor3 == 0)) {
            return "no";
        }
        return "yes";
    }
    private static String generateQuestion() {
        int k;
        final int maxKValue = 20;
        final int baseMult = 6; // какой же агрессивный линтер...
        // простое число = 6k +- 1;
        // при некоторых k число будет не простое, но будет делиться либо на 5, либо на 7 (в нашем диапазоне k)
        // ограничиваем k > 1, чтобы не добавлять проверку через цикл
        // генерируем числа: 6k - 1 | 6k | 6k + 1
        k = Engine.RAND_GEN.nextInt(maxKValue) + 2;
        int baseNum = baseMult * k;
        int offset = Engine.RAND_GEN.nextInt(2);
        int randNumber = ((Engine.RAND_GEN.nextInt(2) == 1) ? (baseNum + offset) : (baseNum - offset));

        return Integer.toString(randNumber);
    }

    public static void start() {
        for (int iter = 0; iter < Engine.NUMBER_OF_ROUNDS; iter++) {
            QA_PAIRS[0][iter] = generateQuestion();
            QA_PAIRS[1][iter] = isPrime(QA_PAIRS[0][iter]); // переписываем переменную каждую итерацию
        }
        Engine.runQuestions("Answer 'yes' if given number is prime. Otherwise answer 'no'.", QA_PAIRS);
    }
}

package hexlet.code.games;

import hexlet.code.Engine;

public class GCD {
    private static final String[][] QA_PAIRS = new String[Engine.NUMBER_OF_ROUNDS][2];
    private static int currentDivisor; // переменная для временного хранения НОД,

    // простые числа + 1
    private static final int[] PRIMES_PLUS = {1, 2, 3, 5, 7, 11, 13, 17};

    private static int getPrime() {
        int randIndex = Engine.RAND_GEN.nextInt(PRIMES_PLUS.length);
        return PRIMES_PLUS[randIndex];
    }

    private static String generateQuestion() {
        final int maxDivisorValue = 10;

        int prime1 = getPrime();
        int prime2;
        do {
            prime2 = getPrime();
        } while (prime1 == prime2);
        // алгоритм от обратного, чтобы пользователям было проще
        currentDivisor = Engine.RAND_GEN.nextInt(maxDivisorValue) + 1;

        return (prime1 * currentDivisor) + " " + (prime2 * currentDivisor);
    }

    public static void start() {
        for (var pair : QA_PAIRS) {
            pair[0] = generateQuestion();
            pair[1] = Integer.toString(currentDivisor); // переписываем переменную каждую итерацию
        }
        Engine.runQuestions("Find the greatest common divisor of given numbers.", QA_PAIRS);
    }
}

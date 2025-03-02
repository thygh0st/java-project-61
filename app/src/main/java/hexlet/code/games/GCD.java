package hexlet.code.games;

import hexlet.code.Engine;

public class GCD {
    private static final String[][] QA_PAIRS = new String[2][Engine.NUMBER_OF_ROUNDS];
    private static int currentDivisor; // переменная для временного хранения НОД,
    // пока не придумал способа лучше (с учетом моего алгоритма) для разделения генерации вопроса и ответа

    private static String generateQuestion() {
        final int maxDivisorValue = 10;

        // простые числа + 1
        final int[] primesPlus = {1, 2, 3, 5, 7, 11, 13, 17};

        int randIndex1 = Engine.RAND_GEN.nextInt(primesPlus.length);
        int randIndex2;
        do {
            randIndex2 = Engine.RAND_GEN.nextInt(primesPlus.length);
        } while (randIndex2 == randIndex1);
        // алгоритм от обратного, чтобы пользователям было проще
        currentDivisor = Engine.RAND_GEN.nextInt(maxDivisorValue) + 1;

        return (primesPlus[randIndex1] * currentDivisor) + " " + (primesPlus[randIndex2] * currentDivisor);
    }

    public static void start() {
        for (int iter = 0; iter < Engine.NUMBER_OF_ROUNDS; iter++) {
            QA_PAIRS[0][iter] = generateQuestion();
            QA_PAIRS[1][iter] = Integer.toString(currentDivisor); // переписываем переменную каждую итерацию
        }
        Engine.runQuestions("Find the greatest common divisor of given numbers.", QA_PAIRS);
    }
}

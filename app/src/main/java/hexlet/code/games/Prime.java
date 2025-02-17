package hexlet.code.games;

import hexlet.code.Engine;

public class Prime {
    private static String question;
    private static String calculatedAnswer;

    private static void runGameLogic() {
        int k;
        final int maxKValue = 20;
        final int baseMult = 6; // какой же агрессивный линтер...
        final int possibleDivisor1 = 5;
        final int possibleDivisor2 = 7;
        // простое число = 6k +- 1;
        // при некоторых k число будет не простое, но будет делиться либо на 5, либо на 7 (в нашем диапазоне k)
        // ограничиваем k > 1, чтобы не добавлять проверку через цикл
        // генерируем числа: 6k - 1 | 6k | 6k + 1
        k = Engine.randGenerator.nextInt(maxKValue) + 2;
        int baseNum = 6 * k;
        int offset = Engine.randGenerator.nextInt(2);
        int randNumber = ((Engine.randGenerator.nextInt(2) == 1) ? (baseNum + offset) : (baseNum - offset));
        if ((randNumber % possibleDivisor1 == 0) || (randNumber % possibleDivisor2 == 0) || (offset == 0)) {
            calculatedAnswer = "no";
        } else {
            calculatedAnswer = "yes";
        }
        question = Integer.toString(randNumber);
    }

    public static void start() {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        boolean isRightAnswer = true;
        int iter = 0;

        for (iter = 0; iter < Engine.NUMBER_OF_ROUNDS; iter++) {
            runGameLogic();
            isRightAnswer = Engine.runQuestion(question, calculatedAnswer);
            if (!isRightAnswer) {
                break;
            }
        }

        if (iter == Engine.NUMBER_OF_ROUNDS) {
            Engine.success();
        } else {
            Engine.failure();
        }
    }
}

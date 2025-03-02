package hexlet.code.games;

import  hexlet.code.Engine;


public class Even {
    private static final String[][] pairs = new String[2][Engine.NUMBER_OF_ROUNDS];

    private static String isEven(String number) {
        if (Integer.parseInt(number) % 2 == 1) {
            return "no";
        }
        return "yes";
    }
    private static String generateQuestion() {
        int randNumber;
        final int maxGameValue = 200;
        randNumber = Engine.RAND_GEN.nextInt(maxGameValue);

        return Integer.toString(randNumber);
    }

    public static void start() {
        for (int iter = 0; iter < Engine.NUMBER_OF_ROUNDS; iter++) {
            pairs[0][iter] = generateQuestion();
            pairs[1][iter] = isEven(pairs[0][iter]);
        }
        Engine.runQuestions("Answer 'yes' if the number is even, otherwise answer 'no'.", pairs);
    }
}

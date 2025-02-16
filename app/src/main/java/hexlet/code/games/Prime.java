package hexlet.code.games;

public class Prime extends Engine {
    public Prime(String userName) {
        super(userName, "Answer 'yes' if given number is prime. Otherwise answer 'no'.");
    }

    @Override
    String generateQuestion() {
        int k;
        final int MAX_K_VALUE = 20;
        // простое число = 6k +- 1;
        // при некоторых k число будет не простое, но будет делиться либо на 5, либо на 7 (в нашем диапазоне k)
        // ограничиваем k > 1, чтобы не добавлять проверку через цикл
        // генерируем числа: 6k - 1 | 6k | 6k + 1
        k = randGenerator.nextInt(MAX_K_VALUE) + 2;
        int baseNum = 6 * k;
        int offset = randGenerator.nextInt(2);
        int randNumber = ((randGenerator.nextInt(2) == 1) ? (baseNum + offset) : (baseNum - offset));
        if ((randNumber % 5 == 0) || (randNumber % 7 == 0) || (offset == 0))
            calculatedAnswer = "no";
        else
            calculatedAnswer = "yes";
        return Integer.toString(randNumber);
    }
}

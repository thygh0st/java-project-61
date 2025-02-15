package hexlet.code.games;

public class Even extends Engine {
    public Even(String userName) {
        super(userName, "Answer 'yes' if the number is even, otherwise answer 'no'.");
    }

    @Override
    String generateQuestion() {
        int randNumber;
        final int MAX_GAME_VALUE = 200;
        randNumber = randGenerator.nextInt(MAX_GAME_VALUE);
        if (randNumber % 2 == 1)
            calculatedAnswer = "no";
        else
            calculatedAnswer = "yes";
        return Integer.toString(randNumber);
    }
}

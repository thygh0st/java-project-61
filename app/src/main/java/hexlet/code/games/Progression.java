package hexlet.code.games;

public class Progression extends Engine {
    public Progression(String userName) {
        super(userName, "What number is missing in the progression?");
    }

    @Override
    String generateQuestion() {
        final int MAX_START_NUMBER = 50;
        final int PROG_LENGTH = 10;
        final int MAX_INCREMENT = 14;
        int startNumber = randGenerator.nextInt(MAX_START_NUMBER);
        int missingIndex = randGenerator.nextInt(PROG_LENGTH);
        int increment = randGenerator.nextInt(MAX_INCREMENT);
        StringBuilder resultProg = new StringBuilder();

        calculatedAnswer = Integer.toString(startNumber + missingIndex * increment);

        for (int i = 0; i < PROG_LENGTH; i++) {
            if (i == missingIndex)
                resultProg.append("..");
            else
                resultProg.append(startNumber + i * increment);
            resultProg.append(" ");
        }
        return resultProg.toString();
    }
}

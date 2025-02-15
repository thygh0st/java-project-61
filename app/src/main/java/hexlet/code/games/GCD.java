package hexlet.code.games;

public class GCD extends Engine {
    public GCD(String userName) {
        super(userName, "Find the greatest common divisor of given numbers.");
    }

    @Override
    String generateQuestion() {
        final int MAX_DIVISOR_VALUE = 10;

        int[] primes = {1, 2, 3, 5, 7, 11, 13, 17};

        int randIndex1 = randGenerator.nextInt(primes.length);
        int randIndex2;
        do {
            randIndex2 = randGenerator.nextInt(primes.length);
        } while (randIndex2 == randIndex1);
        int randDivisor = randGenerator.nextInt(MAX_DIVISOR_VALUE) + 1;

        calculatedAnswer = Integer.toString(randDivisor); // алгоритм от обратного, чтобы пользователям было проще
        return (primes[randIndex1] * randDivisor) + " " + (primes[randIndex2] * randDivisor);
    }
}

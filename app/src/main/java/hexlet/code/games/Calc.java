package hexlet.code.games;

public class Calc extends Engine {

    Calc(String userName) {
        super(userName, "What is the result of the expression?");
    }

    @Override
    String generateQuestion() {
        return "";
    }

    @Override
    boolean compareResult(String result) {
        return false;
    }
}

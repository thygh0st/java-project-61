package hexlet.code.games;

public class Calc extends Engine {

    public Calc(String userName) {
        super(userName, "What is the result of the expression?");
    }

    @Override
    String generateQuestion() {
        final int MAX_OPERAND_VALUE = 150;
        final int MAX_OPERAND_VALUE_MULT = 15;
        char[] operators = {'*', '+', '-'};
        int operand1, operand2;
        int operatorIndex = randGenerator.nextInt(operators.length);
        if (operatorIndex > 0) {
            operand1 = randGenerator.nextInt(MAX_OPERAND_VALUE);
            operand2 = randGenerator.nextInt(MAX_OPERAND_VALUE);
            int result = (operatorIndex == 1) ? (operand1 + operand2) : (operand1 - operand2);
            calculatedAnswer = Integer.toString(result);
        } else {
            operand1 = randGenerator.nextInt(MAX_OPERAND_VALUE_MULT);
            operand2 = randGenerator.nextInt(MAX_OPERAND_VALUE_MULT);
            calculatedAnswer = Integer.toString(operand1 * operand2);
        }
        return (Integer.toString(operand1) + operators[operatorIndex] + Integer.toString(operand2));
    }
}

package hexlet.code.games;

import hexlet.code.Engine;
import static hexlet.code.Utils.generateNumber;

public class Calc {
    private static final String[][] QA_PAIRS = new String[Engine.NUMBER_OF_ROUNDS][2];
    private static int calculatedResult;

    private static int calculate(int operand1, int operand2, char operator) {
        int result;

        switch (operator) {
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            default:
                throw new RuntimeException("Unknown operator: " + operator);
        }
        return result;
    }
    private static String generateQuestion() {
        final int maxOperandValue = 150;
        final int maxOperandValueMult = 15;
        char[] operators = {'*', '+', '-'};
        int operand1;
        int operand2;
        int operatorIndex = generateNumber(0, operators.length);
        if (operatorIndex > 0) {
            operand1 = generateNumber(0, maxOperandValue);
            operand2 = generateNumber(0, maxOperandValue);
        } else {
            operand1 = generateNumber(0, maxOperandValueMult);
            operand2 = generateNumber(0, maxOperandValueMult);
        }
        calculatedResult = calculate(operand1, operand2, operators[operatorIndex]);
        return Integer.toString(operand1) + " " + operators[operatorIndex] + " " + Integer.toString(operand2);
    }

    public static void start() {
        for (var pair : QA_PAIRS) {
            pair[0] = generateQuestion();
            pair[1] = Integer.toString(calculatedResult);
        }
        Engine.runQuestions("What is the result of the expression?", QA_PAIRS);
    }
}

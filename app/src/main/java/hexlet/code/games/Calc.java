package hexlet.code.games;

import hexlet.code.Engine;
import static hexlet.code.Utils.generateNumber;

public class Calc {
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
    private static String[] generatePair() {
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
        String question = operand1 + " " + operators[operatorIndex] + " " + operand2;
        String answer = Integer.toString(calculate(operand1, operand2, operators[operatorIndex]));

        return new String[]{question, answer};
    }

    public static void start() {
        String[][] qaPairs = new String[Engine.NUMBER_OF_ROUNDS][2];
        for (var pair : qaPairs) {
            var tempQAPair = generatePair();
            pair[0] = tempQAPair[0];
            pair[1] = tempQAPair[1];
        }
        Engine.runQuestions("What is the result of the expression?", qaPairs);
    }
}

package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {
    private static final String[][] QA_PAIRS = new String[2][Engine.NUMBER_OF_ROUNDS];

    private static String calculate(String expr) {
        var exprSplit = expr.split(" ");
        int operand1 = Integer.parseInt(exprSplit[0]);
        int operand2 = Integer.parseInt(exprSplit[2]);
        int result;

        switch (exprSplit[1]) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            default:
                return "";
        }
        return Integer.toString(result);
    }
    private static String generateQuestion() {
        final int maxOperandValue = 150;
        final int maxOperandValueMult = 15;
        char[] operators = {'*', '+', '-'};
        int operand1;
        int operand2;
        int operatorIndex = Engine.RAND_GEN.nextInt(operators.length);
        if (operatorIndex > 0) {
            operand1 = Engine.RAND_GEN.nextInt(maxOperandValue);
            operand2 = Engine.RAND_GEN.nextInt(maxOperandValue);
        } else {
            operand1 = Engine.RAND_GEN.nextInt(maxOperandValueMult);
            operand2 = Engine.RAND_GEN.nextInt(maxOperandValueMult);
        }
        return Integer.toString(operand1) + " " + operators[operatorIndex] + " " + Integer.toString(operand2);
    }

    public static void start() {
        for (int iter = 0; iter < Engine.NUMBER_OF_ROUNDS; iter++) {
            QA_PAIRS[0][iter] = generateQuestion();
            QA_PAIRS[1][iter] = calculate(QA_PAIRS[0][iter]);
        }
        Engine.runQuestions("What is the result of the expression?", QA_PAIRS);
    }
}

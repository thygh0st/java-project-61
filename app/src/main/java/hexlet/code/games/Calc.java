package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {
    private static String question;
    private static String calculatedAnswer;

    private static void runGameLogic() {
        final int maxOperandValue = 150;
        final int maxOperandValueMult = 15;
        char[] operators = {'*', '+', '-'};
        int operand1, operand2;
        int operatorIndex = Engine.randGenerator.nextInt(operators.length);
        if (operatorIndex > 0) {
            operand1 = Engine.randGenerator.nextInt(maxOperandValue);
            operand2 = Engine.randGenerator.nextInt(maxOperandValue);
            int result = (operatorIndex == 1) ? (operand1 + operand2) : (operand1 - operand2);
            calculatedAnswer = Integer.toString(result);
        } else {
            operand1 = Engine.randGenerator.nextInt(maxOperandValueMult);
            operand2 = Engine.randGenerator.nextInt(maxOperandValueMult);
            calculatedAnswer = Integer.toString(operand1 * operand2);
        }
        question = Integer.toString(operand1) + " " + operators[operatorIndex] + " " + Integer.toString(operand2);
    }

    public static void start() {
        System.out.println("What is the result of the expression?");
        boolean isRightAnswer = true;
        int iter = 0;

        for (iter = 0; iter < Engine.NUMBER_OF_ROUNDS; iter++) {
            runGameLogic();
            isRightAnswer = Engine.runQuestion(question, calculatedAnswer);
            if (!isRightAnswer)
                break;
        }

        if (iter == Engine.NUMBER_OF_ROUNDS) {
            Engine.success();
        } else {
            Engine.failure();
        }
    }
}

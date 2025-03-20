package manage;

import operation.*;

public class Calculator {
    private String input;

    public Calculator(String input) {
        this.input = input;
    }

    private char identifyOperation() {
        for (int i = 1; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                return c;
            }
        }
        throw new IllegalArgumentException("\nInvalid operation!\n");
    }

    private double[] extractNumbers() {
        char operation = identifyOperation();
        String regex = "([-]?[0-9]+(?:[.,][0-9]+)?)";

        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
        java.util.regex.Matcher matcher = pattern.matcher(input);

        double[] numbers = new double[2];
        int index = 0;

        while (matcher.find()) {
            numbers[index++] = Double.parseDouble(matcher.group(1).replace(",", "."));
            if (index == 2) break;
        }

        if (index < 2) {
            throw new IllegalArgumentException("\nInvalid input!\n");
        }

        return numbers;
    }

    private Operation createOperation(char operation) {
        switch (operation) {
            case '+':
                return new Addition();

            case '-':
                return new Subtraction();

            case '*':
                return new Multiplication();

            case '/':
                return new Division();

            default:
                throw new IllegalArgumentException("\nInvalid operation!\n");
        }
    }

    public double calculate() {
        try {
            char operation = identifyOperation();
            double[] numbers = extractNumbers();
            double num1 = numbers[0];
            double num2 = numbers[1];

            Operation operationInstance = createOperation(operation);
            return operationInstance.calculate(num1, num2);

        } catch (NumberFormatException nfe) {
            throw new NumberFormatException("\nInvalid operation!\n");
        }
    }

    public String formatResult(double result) {
        return String.valueOf(result).replace(".", ",");
    }
}

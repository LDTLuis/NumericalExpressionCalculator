package manage;

import operation.*;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private String input;
    private static List<OperationHistory> history = new ArrayList<>();

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

    public static void addToHistory(String expression, double result) {
        history.add(new OperationHistory(expression, result));
    }

    public static void listHistory() {
        if (history.isEmpty()) {
            System.out.println("\nHistory's empty!!\n");
        } else {
            for (OperationHistory operationHistory : history) {
                System.out.println(operationHistory);
            }
        }
    }

    public static void updateOperation(int id, String newExpression) {
        for (OperationHistory operationHistory : history) {
            if (operationHistory.getId() == id) {
                Calculator calc = new Calculator(newExpression);
                double newResult = calc.calculate();
                operationHistory.setExpression(newExpression);
                operationHistory.setResult(newResult);
                System.out.println("\nOperation updated!");
                return;
            }
        }
        System.out.println("\nID not found.\n");
    }

    public static void removeOperation(int id) {
        history.removeIf(operationHistory -> operationHistory.getId() == id);
        System.out.println("\nOperation removed sucessfully!");
    }

    public String formatResult(double result) {
        return String.valueOf(result).replace(".", ",");
    }
}

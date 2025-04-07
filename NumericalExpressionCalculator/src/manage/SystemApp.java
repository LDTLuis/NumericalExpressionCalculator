package manage;

import java.util.Scanner;

import static manage.Calculator.*;

public class SystemApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add operation");
            System.out.println("2. List history");
            System.out.println("3. Update operation");
            System.out.println("4. Remove operation");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Enter the operation: ");
                    String expression = scanner.nextLine();
                    Calculator calc = new Calculator(expression);
                    double result = calc.calculate();
                    addToHistory(expression, result);
                    System.out.println("Result: " + result);
                    break;
                case 2:
                    listHistory();
                    break;
                case 3:
                    System.out.print("Enter the ID of the operation to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter the new operation: ");
                    String newExpression = scanner.nextLine();
                    updateOperation(updateId, newExpression);
                    break;
                case 4:
                    System.out.print("Enter the ID of the operation to remove: ");
                    int removeId = scanner.nextInt();
                    removeOperation(removeId);
                    break;
                case 5:
                    System.out.println("\nExiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("\nInvalid option!");
            }
        }
    }
}
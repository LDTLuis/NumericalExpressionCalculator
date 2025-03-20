package manage;

import java.util.Scanner;

public class SystemApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean flag = true;

        do {
            System.out.println("To exit, type EXIT.");
            System.out.println("Examples of operations (5 + 3; -2 - 2; 10 / -2; -3.5 * 2)");
            System.out.print("Enter the operation you want to perform: ");
            String inputOp = sc.nextLine();

            if (inputOp.equalsIgnoreCase("exit")) {
                System.out.println("\nProgram terminated!");
                break;
            }

            Calculator calc = new Calculator(inputOp);

            try {
                double result = calc.calculate();
                String formattedResult = calc.formatResult(result);
                System.out.println("Result: " + formattedResult + "\n");

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } while (flag);

        sc.close();
    }
}

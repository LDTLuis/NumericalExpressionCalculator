import gerenciar.Calculadora;

import java.util.Scanner;

public class Sistema {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean flag = true;

        do {
            System.out.println("Para finalizar digite SAIR.");
            System.out.print("Digite a operação que deseja realizar: ");
            String entradaOp = sc.nextLine();

            if (entradaOp.equalsIgnoreCase("sair")) {
                System.out.println("\nPrograma finalizado!");
                break;
            }

            Calculadora calc = new Calculadora(entradaOp);

            try {
                double resultado = calc.calcular();
                String resultadoFormat = calc.formatarResultado(resultado);
                System.out.println("Resultado: " + resultadoFormat + "\n");

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } while (flag);

        sc.close();

    }
}

package operacao;

public class Divisao implements Operacao {
    public double calcular(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Não existe divisão por 0 burro!");
        }

        return num1 / num2;
    }
}

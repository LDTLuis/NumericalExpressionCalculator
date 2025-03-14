package operacao;

import gerenciar.Operacao;

public class Soma extends Operacao {
    @Override
    public double calcular(double num1, double num2) {
        return num1 + num2;
    }
}

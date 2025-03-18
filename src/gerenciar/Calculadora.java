package gerenciar;

import operacao.*;

public class Calculadora {
    private String entrada;

    public Calculadora(String entrada) {
        this.entrada = entrada;
    }

    private char identificarOperacao() {
        if (entrada.contains("+")) {
            return '+';
        } else if (entrada.contains("-")) {
            return '-';
        } else if (entrada.contains("*")) {
            return '*';
        } else if (entrada.contains("/")) {
            return '/';
        } else {
            throw new IllegalArgumentException("\nOperação Inválida!\n");
        }
    }

    private double[] extrairNumeros() {
        char operacao = identificarOperacao();
        String[] numeros = entrada.split("[" + operacao + "]");
        double num1 = Double.parseDouble(numeros[0].trim().replace("," , "."));
        double num2 = Double.parseDouble(numeros[1].trim().replace("," , "."));
        return new double[]{num1, num2};
    }

    private Operacao criarOperacao(char operacao) {
        switch (operacao) {
            case '+':
                return new Soma();

            case '-':
                return new Subtracao();

            case '*':
                return new Multiplicacao();

            case '/':
                return new Divisao();

            default:
            throw new IllegalArgumentException("\nOperação Inválida!\n");
        }
    }

    public double calcular() {
        try {
            char operacao = identificarOperacao();
            double[] numeros = extrairNumeros();
            double num1 = numeros[0];
            double num2 = numeros[1];

            Operacao operacao1 = criarOperacao(operacao);
            return operacao1.calcular(num1, num2);

        } catch (NumberFormatException nfe) {
            throw new NumberFormatException("\nOperação Inválida!\n");
        }
    }

    public String formatarResultado(double resultado) {
        return String.valueOf(resultado).replace(".", ",");
    }

}

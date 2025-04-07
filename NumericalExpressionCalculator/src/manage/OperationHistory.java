package manage;

public class OperationHistory {
    private static int idCounter = 1;
    private int id;
    private String expression;
    private double result;

    public OperationHistory(String expression, double result) {
        this.id = idCounter++;
        this.expression = expression;
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public String getExpression() {
        return expression;
    }

    public double getResult() {
        return result;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public void setResult(double result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return  "ID: " + id + ", Expression: " + expression + ", Result: " + result;
    }
}

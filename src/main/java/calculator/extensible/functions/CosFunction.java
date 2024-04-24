package calculator.extensible.functions;

public class CosFunction implements CalculatorFunction {
    @Override
    public double calculate(double parameter) {
        return Math.cos(parameter);
    }

    @Override
    public String getCaption() {
        return "cos(x)";
    }
}

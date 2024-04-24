package calculator.extensible.functions;

public class SinFunction implements CalculatorFunction {
    @Override
    public double calculate(double parameter) {
        return Math.sin(parameter);
    }

    @Override
    public String getCaption() {
        return "sin(x)";
    }
}

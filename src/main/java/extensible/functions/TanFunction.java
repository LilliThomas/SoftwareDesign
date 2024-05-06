package extensible.functions;

public class TanFunction implements CalculatorFunction {
    @Override
    public double calculate(double parameter) {
        return Math.tan(parameter);
    }

    @Override
    public String getCaption() {
        return "tan(x)";
    }
}

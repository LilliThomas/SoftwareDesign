package extensible.functions;

public class TanFunction implements CalculatorFunction {
    public static final String TAN_FUNCTION = "TanFunction";
    @Override
    public double calculate(double parameter) {
        return Math.tan(parameter);
    }

    @Override
    public String getCaption() {
        return "tan(x)";
    }
}

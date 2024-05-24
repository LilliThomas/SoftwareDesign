package extensible.functions;

public class SinFunction implements CalculatorFunction {
    public static final String SIN_FUNCTION = "SinFunction";
    @Override
    public double calculate(double parameter) {
        return Math.sin(parameter);
    }

    @Override
    public String getCaption() {
        return "sin(x)";
    }
}

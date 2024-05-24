package extensible.functions;

public class CosFunction implements CalculatorFunction {
    public static final String COS_FUNCTION = "CosFunction";
    @Override
    public double calculate(double parameter) {
        return Math.cos(parameter);
    }

    @Override
    public String getCaption() {
        return "cos(x)";
    }
}

package functions.extensible;

public class CosFunction implements CalculatorFunction {
    @Override
    public double calculate(double p1, double p2) {
        return this.calculate(p1);
    }

    @Override
    public double calculate(double parameter) {
        return Math.cos(parameter);
    }

    @Override
    public String getCaption() {
        return "cos(x)";
    }
}

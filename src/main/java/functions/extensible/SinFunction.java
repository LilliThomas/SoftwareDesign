package functions.extensible;

public class SinFunction implements CalculatorFunction {
    @Override
    public double calculate(double p1, double p2) {
        return this.calculate(p1);
    }

    @Override
    public double calculate(double parameter) {
        return Math.sin(parameter);
    }

    @Override
    public String getCaption() {
        return "sin(x)";
    }
}

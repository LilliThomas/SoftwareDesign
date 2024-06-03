package functions.basic;

import functions.extensible.CalculatorFunction;

public class InverseFunction implements CalculatorFunction {
    @Override
    public double calculate(double p1, double p2) {
        return calculate(p1);
    }

    @Override
    public double calculate(double parameter) {
        return parameter * (-1);
    }

    @Override
    public String getCaption() {
        return "(-x)";
    }
}

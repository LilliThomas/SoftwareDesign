package functions.basic;

import functions.extensible.CalculatorFunction;

public class MinusFunction implements CalculatorFunction {
    @Override
    public double calculate(double p1, double p2) {
        return p1 - p2;
    }

    @Override
    public double calculate(double parameter) {
        return 0;
    }

    @Override
    public String getCaption() {
        return "-";
    }
}

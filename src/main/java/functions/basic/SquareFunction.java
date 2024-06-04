package functions.basic;

import functions.extensible.CalculatorFunction;

public class SquareFunction implements CalculatorFunction {
    @Override
    public double calculate(double p1, double p2) {

        return calculate(p1);
    }

    @Override
    public double calculate(double parameter) {
        return Math.pow(parameter, 2);
    }

    @Override
    public String getCaption() {
        return "(x)^2";
    }
}

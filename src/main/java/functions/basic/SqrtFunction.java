package functions.basic;

import functions.extensible.CalculatorFunction;

public class SqrtFunction implements CalculatorFunction {
    @Override
    public double calculate(double p1, double p2) {

        return calculate(p1);
    }

    @Override
    public double calculate(double parameter) {
        return Math.sqrt(parameter);
    }

    @Override
    public String getCaption() {
        return "sqrt(x)";
    }
}

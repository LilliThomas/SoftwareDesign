package functions.basic;

import functions.extensible.CalculatorFunction;

public class PlusFunction implements CalculatorFunction {
    @Override
    public double calculate(double p1, double p2) {
        return p1 + p2;
    }

    @Override
    public double calculate(double parameter) {
        return parameter + parameter;
    }

    @Override
    public String getCaption() {
        return "+";
    }
}

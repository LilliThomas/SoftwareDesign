package functions.basic;

import exceptions.DivisionException;
import functions.extensible.CalculatorFunction;

public class DivideFunction implements CalculatorFunction {
    @Override
    public double calculate(double p1, double p2) {
        if (p2 == 0) {
            throw new DivisionException("Nicht durch 0 teilen!");
        }
        return p1 / p2;
    }

    @Override
    public double calculate(double parameter) {
        return 0;
    }

    @Override
    public String getCaption() {
        return "/";
    }
}

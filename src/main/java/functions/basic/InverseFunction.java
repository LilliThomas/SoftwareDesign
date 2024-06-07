package functions.basic;

import functions.extensible.CalculatorFunction;

/**
 * Class for inverting a number.
 */
public class InverseFunction implements CalculatorFunction {
    /**
     * @inheritDoc
     */
    @Override
    public double calculate(double p1, double p2) {
        return calculate(p1);
    }

    /**
     * @inheritDoc
     */
    @Override
    public double calculate(double parameter) {
        return parameter * (-1);
    }

    /**
     * @inheritDoc
     */
    @Override
    public String getCaption() {
        return "(-x)";
    }
}

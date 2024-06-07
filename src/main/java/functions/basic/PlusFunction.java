package functions.basic;

import functions.extensible.CalculatorFunction;

/**
 * Class for adding two numbers.
 */
public class PlusFunction implements CalculatorFunction {
    /**
     * @inheritDoc
     */
    @Override
    public double calculate(double p1, double p2) {
        return p1 + p2;
    }

    /**
     * @inheritDoc
     */
    @Override
    public double calculate(double parameter) {
        return parameter + parameter;
    }

    /**
     * @inheritDoc
     */
    @Override
    public String getCaption() {
        return "+";
    }
}

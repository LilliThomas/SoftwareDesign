package functions.basic;

import functions.extensible.CalculatorFunction;

/**
 * Class for calculating the square root of a number.
 */
public class SqrtFunction implements CalculatorFunction {
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
        return Math.sqrt(parameter);
    }

    /**
     * @inheritDoc
     */
    @Override
    public String getCaption() {
        return "sqrt(x)";
    }
}

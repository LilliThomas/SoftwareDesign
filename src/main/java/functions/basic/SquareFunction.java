package functions.basic;

import functions.extensible.CalculatorFunction;

/**
 * Class for squaring a number.
 */
public class SquareFunction implements CalculatorFunction {
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
        return Math.pow(parameter, 2);
    }

    /**
     * @inheritDoc
     */
    @Override
    public String getCaption() {
        return "(x)^2";
    }
}

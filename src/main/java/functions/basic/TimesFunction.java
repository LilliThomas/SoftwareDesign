package functions.basic;

import functions.extensible.CalculatorFunction;

/**
 * Class for multiplying two numbers.
 */
public class TimesFunction implements CalculatorFunction {
    /**
     * @inheritDoc
     */
    @Override
    public double calculate(double p1, double p2) {
        return p1 * p2;
    }

    /**
     * @inheritDoc
     */
    @Override
    public double calculate(double parameter) {
        return 0;
    }

    /**
     * @inheritDoc
     */
    @Override
    public String getCaption() {
        return "*";
    }
}

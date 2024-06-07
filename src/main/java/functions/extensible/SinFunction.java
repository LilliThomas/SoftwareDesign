package functions.extensible;

/**
 * Class for calculating the sine of a number.
 */
public class SinFunction implements CalculatorFunction {
    /**
     * @inheritDoc
     */
    @Override
    public double calculate(double p1, double p2) {
        return this.calculate(p1);
    }

    /**
     * @inheritDoc
     */
    @Override
    public double calculate(double parameter) {
        return Math.sin(parameter);
    }

    /**
     * @inheritDoc
     */
    @Override
    public String getCaption() {
        return "sin(x)";
    }
}

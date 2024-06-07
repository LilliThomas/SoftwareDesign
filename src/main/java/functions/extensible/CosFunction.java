package functions.extensible;

/**
 * Class for calculating the cosine of a number.
 */
public class CosFunction implements CalculatorFunction {
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
        return Math.cos(parameter);
    }

    /**
     * @inheritDoc
     */
    @Override
    public String getCaption() {
        return "cos(x)";
    }
}

package functions.extensible;

/**
 * Class for calculating the tangent of a number.
 */
public class TanFunction implements CalculatorFunction {
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
        return Math.tan(parameter);
    }

    /**
     * @inheritDoc
     */
    @Override
    public String getCaption() {
        return "tan(x)";
    }
}

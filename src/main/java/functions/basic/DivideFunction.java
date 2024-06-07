package functions.basic;

import exceptions.DivisionException;
import functions.extensible.CalculatorFunction;

/*+
 * Class for dividing two numbers.
 */
public class DivideFunction implements CalculatorFunction {
    /**
     * @inheritDoc
     */
    @Override
    public double calculate(double p1, double p2) throws DivisionException {
        if (p2 == 0) {
            throw new DivisionException("Nicht durch 0 teilen!");
        }
        return p1 / p2;
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
        return "/";
    }
}

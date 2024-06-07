package functions.extensible;

/**
 * The CalculatorFunction interface represents a mathematical function that can be calculated.
 */
public interface CalculatorFunction {
    /**
     * Calculates the result of the function with two parameters.
     * @param p1 The first parameter of the function.
     * @param p2 The second parameter of the function.
     * @return The result of the function.
     */
    double calculate(double p1, double p2);

    /**
     * Calculates the result of the function with one parameter.
     * @param parameter The parameter of the function.
     * @return The result of the function.
     */
    double calculate(double parameter);
    /**
     * Returns the caption of the function.
     * @return The caption of the function.
     */
    String getCaption();
}

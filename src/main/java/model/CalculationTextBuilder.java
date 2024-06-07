package model;

/**
 * The CalculationTextBuilder class is used to build instances of the CalculationText class.
 */
public class CalculationTextBuilder {
    private String n1;
    private String n2;
    private String operation;

    /**
     * Default constructor for the CalculationTextBuilder class.
     * This is necessary for the Builder pattern.
     */
    public CalculationTextBuilder() {}

    /**
     * Sets the value of the first number entered for the CalculationText object.
     * @param n1 The first number to be used in the calculation.
     * @return The current CalculationTextBuilder instance.
     */
    public CalculationTextBuilder setN1(String n1) {
        this.n1 = n1;
        return this;
    }

    /**
     * Sets the value of the second number entered for the CalculationText object.
     * @param n2 The second number to be used in the calculation.
     * @return The current CalculationTextBuilder instance.
     */
    public CalculationTextBuilder setN2(String n2) {
        this.n2 = n2;
        return this;
    }

    /**
     * Sets the operation to be performed on the two numbers entered for the CalculationText object.
     * @param operation The operation to be performed on the two entered numbers.
     * @return The current CalculationTextBuilder instance.
     */
    public CalculationTextBuilder setOperation(String operation) {
        this.operation = operation;
        return this;
    }


    /**
     * Builds a new CalculationText object with the values set in the builder.
     * @return A new CalculationText object with the values set in the builder.
     */
    public CalculationText build() {
        return new CalculationText(n1, n2, operation);
    }
}

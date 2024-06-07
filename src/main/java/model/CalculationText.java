package model;

/**
 * The CalculationText class is used to represent the text that is displayed in the calculator display.
 */
public class CalculationText {

    private String n1;
    private String n2;
    private String operation;

    /**
     * Constructor for the CalculationText class.
     * @param n1 The first number to be used in the calculation.
     * @param n2 The second number to be used in the calculation.
     * @param operation The operation to be performed on the two entered numbers.
     */
    public CalculationText(String n1, String n2, String operation) {
        this.n1 = n1;
        this.n2 = n2;
        this.operation = operation;
    }

    /**
     * Default constructor for the CalculationText class.
     * This is necessary for the Builder pattern.
     */
    public CalculationText() {}

    /**
     * Returns a new CalculationTextBuilder for building instances of CalculationText.
     * @return A new CalculationTextBuilder.
     */
    public CalculationTextBuilder builder() {
        return new CalculationTextBuilder();
    }

    /**
     * Returns a string representation of the calculation text.
     * @param isDirect A Boolean value that specifies whether the calculation consists of one or two numbers
     *                 (e.g. sin(x) or 1+2)
     * @return A string representation of the calculation text.
     */
    public String getCalculationText(boolean isDirect) {
        if (isDirect) {
            String[] operationParts = operation.split("x");
            this.n1 = String.format("%s%s%s", operationParts[0], n1, operationParts[1]);
        }

        if (operation == null) {
            return String.format("%s =", this.n1);
        } else if (n2 == null && !isDirect) {
            return String.format("%s %s", this.n1, this.operation);
        } else if (isDirect && n1 != null) {
            return String.format("%s ", this.n1);
        } else if (n2 != null) {
            if (isDirect) {
                return String.format("%s %s %s", this.n1, this.operation, this.n2);
            }
            return String.format("%s %s %s =", this.n1, this.operation, this.n2);
        }
        return this.n1;
    }
}

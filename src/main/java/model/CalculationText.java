package model;

public class CalculationText {

    private String n1;
    private String n2;
    private String operation;

    public CalculationText(String n1, String n2, String operation) {
        this.n1 = n1;
        this.n2 = n2;
        this.operation = operation;
    }

    public CalculationText() {}

    public CalculationTextBuilder builder() {
        return new CalculationTextBuilder();
    }

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

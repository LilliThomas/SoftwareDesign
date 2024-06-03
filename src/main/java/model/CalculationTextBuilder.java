package model;

public class CalculationTextBuilder {

    private String n1;
    private String n2;
    private String operation;

    public CalculationTextBuilder() {
        // necessary for Builder pattern
    }

    public CalculationTextBuilder setN1(String n1) {
        this.n1 = n1;
        return this;
    }

    public CalculationTextBuilder setN2(String n2) {
        this.n2 = n2;
        return this;
    }

    public CalculationTextBuilder setOperation(String operation) {
        this.operation = operation;
        return this;
    }



    public CalculationText build() {
        return new CalculationText(n1, n2, operation);
    }
}

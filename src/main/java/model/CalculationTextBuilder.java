package model;

public class CalculationTextBuilder {

    private double ans;
    private double enteredNumber;
    private String operationSign;
    private boolean isEqualState;
    private boolean hasEnterdNumber;

    public CalculationTextBuilder() {

    }

    public CalculationTextBuilder setAns(double ans) {
        this.ans = ans;
        return this;
    }

    public CalculationTextBuilder setEnteredNumber(double enteredNumber) {
        this.enteredNumber = enteredNumber;
        return this;
    }

    public CalculationTextBuilder setOperationSign(String operationSign) {
        this.operationSign = operationSign;
        return this;
    }

    public CalculationTextBuilder setIsEqualState(boolean isEqualState) {
        this.isEqualState = isEqualState;
        return this;
    }

    public CalculationTextBuilder setHasEnteredNumber(boolean hasEnteredNumber) {
        this.hasEnterdNumber = hasEnteredNumber;
        return this;
    }



    public CalculationText build() {
        return new CalculationText(ans, enteredNumber, operationSign, isEqualState, hasEnterdNumber);
    }
}

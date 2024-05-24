package model;

public class CalculationText {

    private double ans;
    private double enteredNumber;
    private String operationSign;
    private boolean isEqualState;
    private boolean hasEnterdNumber;

    public CalculationText(double ans, double enteredNumber, String operationSign, boolean isEqualState, boolean hasEnterdNumber) {
        this.ans = ans;
        this.enteredNumber = enteredNumber;
        this.operationSign = operationSign;
        this.isEqualState = isEqualState;
        this.hasEnterdNumber = hasEnterdNumber;
    }

    public CalculationText() {}

    public CalculationTextBuilder builder() {
        return new CalculationTextBuilder();
    }

    public String getCalculationText() {
        StringBuilder stringBuilder =  new StringBuilder();
        stringBuilder.append(ans).append(" ");
        stringBuilder.append(operationSign).append(" ");

        if (enteredNumber != 0) {
            stringBuilder.append(enteredNumber).append(" =");
        }

        return stringBuilder.toString();
    }

    public void setAns(double ans) {
        this.ans = ans;
    }

    public void setEnteredNumber(double enteredNumber) {
        this.enteredNumber = enteredNumber;
    }

    public void setOperationSign(String operationSign) {
        this.operationSign = operationSign;
    }

    public void setEqualState(boolean equalState) {
        isEqualState = equalState;
    }

    public void setHasEnterdNumber(boolean hasEnterdNumber) {
        this.hasEnterdNumber = hasEnterdNumber;
    }
}

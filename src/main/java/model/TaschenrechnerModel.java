package model;

public class TaschenrechnerModel {

    private float ans;
    private float enteredNumber;

    public TaschenrechnerModel() {
        this.ans = 0;
        this.enteredNumber = 0;
    }

    public void resetAll() {
        ans = 0;
    }

    public void resetEnteredNumber() {
        enteredNumber = 0;
    }

    public float calculate(Operation operation) {
        switch (operation) {
            case PLUS -> ans += enteredNumber;
            case MINUS -> ans -= enteredNumber;
            case TIMES -> ans *= enteredNumber;
            case DIVIDE, RECIPROCAL -> ans = divide(operation);
            case ROOT -> ans = (float) Math.pow(ans, 0.5);
            case SQUARE -> ans = (float) Math.pow(ans, 2);
        }
        return ans;
    }

    private float divide(Operation operation) {
        if (enteredNumber == 0) {
            throw new DivisionException("Versucht durch 0 zu teilen!");
        }
        if (operation == Operation.RECIPROCAL) {
            return 1 / ans;
        }
        return ans / enteredNumber;
    }

    // Getter and Setter
    public float getAns() {
        return ans;
    }

    public void setAns(float ans) {
        this.ans = ans;
    }

    public float getEnteredNumber() {
        return enteredNumber;
    }

    public void setEnteredNumber(float enteredNumber) {
        this.enteredNumber = enteredNumber;
    }
}

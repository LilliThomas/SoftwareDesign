package model;

import exceptions.DivisionException;
import extensible.functions.CalculatorFunction;
import extensible.functions.CosFunction;
import extensible.functions.SinFunction;
import extensible.functions.TanFunction;
import reflection.ExtensibleFunctionsLoader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

public class TaschenrechnerModel {

    private double ans;
    private double enteredNumber;
    private ExtensibleFunctionsLoader extensibleFunctionsLoader;
    private static final String CALCULATE = "calculate";
    private static final String GET_CAPTION = "getCaption";

    public TaschenrechnerModel() {
        this.ans = 0;
        this.enteredNumber = 0;
    }

    public void resetAll() {
        ans = 0;
        enteredNumber = 0;
    }

    public void resetEnteredNumber() {
        enteredNumber = 0;
    }

    public double calculate(Operation operation) {
        switch (operation) {
            case PLUS -> ans += enteredNumber;
            case MINUS -> ans -= enteredNumber;
            case TIMES -> ans *= enteredNumber;
            case DIVIDE, RECIPROCAL -> ans = divide(operation);
            case ROOT -> ans = Math.pow(ans, 0.5);
            case SQUARE -> ans = Math.pow(ans, 2);
        }
        return ans;
    }

    private double divide(Operation operation) {
        if (enteredNumber == 0) {
            throw new DivisionException("Versucht durch 0 zu teilen!");
        }
        if (operation == Operation.RECIPROCAL) {
            return 1 / ans;
        }
        return ans / enteredNumber;
    }

    // Getter and Setter
    public double getAns() {
        return ans;
    }

    public void setAns(float ans) {
        this.ans = ans;
    }

    public double getEnteredNumber() {
        return enteredNumber;
    }

    public void setEnteredNumber(float enteredNumber) {
        this.enteredNumber = enteredNumber;
    }
}

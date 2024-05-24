package model;

import exceptions.DivisionException;
import extensible.functions.CosFunction;
import extensible.functions.SinFunction;
import extensible.functions.TanFunction;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TaschenrechnerModel {

    private double ans;
    private double enteredNumber;
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
            case COS -> {
                try {
                    ans = cos();
                } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                    System.out.println(e.getMessage());
                }
            }
            case SIN -> {
                try {
                    ans = sin();
                } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                    System.out.println(e.getMessage());
                }
            }
            case TAN -> {
                try {
                    ans = tan();
                } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                    System.out.println(e.getMessage());
                }
            }
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

    private double sin() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        SinFunction sinFunction = new SinFunction();
        Method calculateSinFunc = sinFunction.getClass().getDeclaredMethod("calculate", double.class);
        return (double) calculateSinFunc.invoke(sinFunction, enteredNumber);
    }

    private double cos() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        CosFunction cosFunction = new CosFunction();
        Method calculateCosFunc = cosFunction.getClass().getDeclaredMethod("calculate", double.class);
        return (double) calculateCosFunc.invoke(cosFunction, enteredNumber);
    }

    private double tan() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        TanFunction tanFunction = new TanFunction();
        Method calculateTanFunc = tanFunction.getClass().getDeclaredMethod("calculate", double.class);
        return (double) calculateTanFunc.invoke(tanFunction, enteredNumber);
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

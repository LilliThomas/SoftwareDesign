package model;

import exceptions.DivisionException;
import extensible.functions.CosFunction;
import extensible.functions.SinFunction;
import extensible.functions.TanFunction;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CalculatorModel {

    private PropertyChangeSupport pclSupport;

    private String calculationString;
    private double ans;
    private double enteredNumber;

    private Operation operation;
    public CalculatorModel() {
        this.calculationString = "";
        this.ans = 0;
        this.enteredNumber = 0;
        operation = null;

        this.pclSupport = new PropertyChangeSupport(this);
    }

    public void resetAll() {
        pclSupport.firePropertyChange("ans", this.ans, 0);
        pclSupport.firePropertyChange("enteredNumber", this.enteredNumber, 0);
        calculationString = "";
        ans = 0;
        enteredNumber = 0;
        pclSupport.firePropertyChange("calculationString", this.calculationString, calculationString);
    }

    public void resetEnteredNumber() {
        pclSupport.firePropertyChange("enteredNumber", this.enteredNumber, 0);
        enteredNumber = 0;
    }

    public double calculate() {
        double ans = this.ans;
        switch (operation) {
            case PLUS -> ans += enteredNumber;
            case MINUS -> ans -= enteredNumber;
            case TIMES -> ans *= enteredNumber;
            case DIVIDE -> ans = divide(operation);
            case ROOT -> ans = Math.pow(ans, 0.5);
            case SQUARE -> ans = Math.pow(ans, 2);
        }
        //calculationString = ans + " " + operation.getSign() + " " + enteredNumber + " =";
        //pclSupport.firePropertyChange("calculationString", this.calculationString, calculationString);
        pclSupport.firePropertyChange("ans", this.ans, ans);
        return ans;
    }

    private double divide(Operation operation) {
        if (enteredNumber == 0) {
            throw new DivisionException("Versucht durch 0 zu teilen!");
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
        pclSupport.firePropertyChange("ans", this.ans, ans);
        this.ans = ans;
    }
    public double getEnteredNumber() {
        return enteredNumber;
    }

    public void setEnteredNumber(float enteredNumber) {
        pclSupport.firePropertyChange("enteredNumber", this.enteredNumber, enteredNumber);
        this.enteredNumber = enteredNumber;
    }
    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        pclSupport.firePropertyChange("ans", null, operation.getSign());
        this.operation = operation;
        resetEnteredNumber();

    }

    public String getCalculationString() {
        return calculationString;
    }

    public void setCalculationString() {
        String string = ans + " " + operation.getSign();
        if (enteredNumber != 0) {
            string = string + " " + enteredNumber + " =";
        }
        pclSupport.firePropertyChange("calculationString", this.calculationString, string);
        this.calculationString = string;
    }

    public void addToCalculationString(String calculationString) {
        if (calculationString.contains("=")) {
            this.calculationString = "";
            return;
        }
        calculationString = this.getCalculationString() + " " + calculationString;
        pclSupport.firePropertyChange("calculationString", this.calculationString, calculationString);
        this.calculationString = calculationString;
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        pclSupport.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        pclSupport.removePropertyChangeListener(pcl);
    }
}

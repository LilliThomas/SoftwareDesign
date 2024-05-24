package model;

import exceptions.DivisionException;
import extensible.functions.CosFunction;
import extensible.functions.SinFunction;
import extensible.functions.TanFunction;
import util.Constants;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CalculatorModel {

    private final PropertyChangeSupport pclSupport;

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
        pclSupport.firePropertyChange(Constants.PCL_ANS, this.ans, 0);
        pclSupport.firePropertyChange(Constants.PCL_ENTERED_NUMBER, this.enteredNumber, 0);
        pclSupport.firePropertyChange(Constants.PCL_CALCULATION_STRING, this.calculationString, "");
        calculationString = "";
        ans = 0;
        enteredNumber = 0;
    }

    public void resetEnteredNumber() {
        pclSupport.firePropertyChange(Constants.PCL_ENTERED_NUMBER, this.enteredNumber, 0);
        enteredNumber = 0;
    }

    public double calculate() {
        double oldAns = this.ans;
        switch (operation) {
            case PLUS -> ans += enteredNumber;
            case MINUS -> ans -= enteredNumber;
            case TIMES -> ans *= enteredNumber;
            case DIVIDE -> ans = divide();
            case ROOT -> ans = Math.pow(ans, 0.5);
            case SQUARE -> ans = Math.pow(ans, 2);
        }
        pclSupport.firePropertyChange("ans", oldAns, ans);
        return ans;
    }

    private double divide() {
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

    public void setAns(double ans) {
        pclSupport.firePropertyChange(Constants.PCL_ANS, this.ans, ans);
        this.ans = ans;
    }
    public double getEnteredNumber() {
        return enteredNumber;
    }

    public void setEnteredNumber(double enteredNumber) {
        pclSupport.firePropertyChange(Constants.PCL_ENTERED_NUMBER, this.enteredNumber, enteredNumber);
        this.enteredNumber = enteredNumber;
    }
    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        pclSupport.firePropertyChange(Constants.PCL_ANS, this.operation, operation.getSign());
        this.operation = operation;
    }

    public void setCalculationString(CalculationText calculationText) {

/*
        String string = ans + " " + operation.getSign();
        if (enteredNumber != 0) {
            string = string + " " + enteredNumber + " =";
        }*/
        pclSupport.firePropertyChange(Constants.PCL_CALCULATION_STRING, this.calculationString, calculationText.getCalculationText());
        this.calculationString = calculationText.getCalculationText();
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        pclSupport.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        pclSupport.removePropertyChangeListener(pcl);
    }
}

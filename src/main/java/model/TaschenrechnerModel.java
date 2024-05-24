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
        loadExtensibleFunctions();
    }

    // TODO: brauchen wir überhaupt so eine Methode?
    private Set<Class<? extends CalculatorFunction>> loadExtensibleFunctions() {
        this.extensibleFunctionsLoader = new ExtensibleFunctionsLoader();
        return extensibleFunctionsLoader.loadCalculatorFunctionSubClasses();
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
                } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
                    System.out.println(e.getMessage());
                }
            }
            case SIN -> {
                try {
                    ans = sin();
                } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
                    System.out.println(e.getMessage());
                }
            }
            case TAN -> {
                try {
                    ans = tan();
                } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
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

    private double sin() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Class sinFunctionClass = extensibleFunctionsLoader.getSpecificClass(SinFunction.SIN_FUNCTION);
        // TODO eigentlich wollte ich hier keine Klasse instanzieren, aber ich kriege es anders nicht hin, denn für die invoke Methode, braucht man eine Instanz des jeweiligen Objektes - also hier SinFunction
        SinFunction sinFunction = new SinFunction();
        return (double) getMethod(SinFunction.SIN_FUNCTION, CALCULATE).invoke(sinFunction, enteredNumber);
    }

    public String getSinCaption() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        SinFunction sinFunction = new SinFunction();
        return (String) getMethod(SinFunction.SIN_FUNCTION, GET_CAPTION).invoke(sinFunction);
    }

    private double cos() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Class cosFunctionClass = extensibleFunctionsLoader.getSpecificClass(CosFunction.COS_FUNCTION);
        CosFunction cosFunction = new CosFunction();
        return (double) getMethod(CosFunction.COS_FUNCTION, CALCULATE).invoke(cosFunction, enteredNumber);
    }

    public String getCosCaption() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        CosFunction cosFunction = new CosFunction();
        return (String) getMethod(CosFunction.COS_FUNCTION, GET_CAPTION).invoke(cosFunction);
    }

    private double tan() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Class tanFunctionClass = extensibleFunctionsLoader.getSpecificClass(TanFunction.TAN_FUNCTION);
        TanFunction tanFunction = new TanFunction();
        return (double) getMethod(TanFunction.TAN_FUNCTION, CALCULATE).invoke(tanFunction, enteredNumber);
    }

    public String getTanCaption() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        TanFunction tanFunction = new TanFunction();
        return (String) getMethod(TanFunction.TAN_FUNCTION, GET_CAPTION).invoke(tanFunction);
    }

    private Method getMethod(String className, String methodName) throws NoSuchMethodException {
        // get calculate method from given class
        return extensibleFunctionsLoader.getSpecificMethodFromSpecificClass(className, methodName);
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

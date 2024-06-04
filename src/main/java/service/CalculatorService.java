package service;

import exceptions.DivisionException;
import functions.extensible.CalculatorFunction;
import reflection.ExtensibleFunctionsLoader;

import java.lang.reflect.InvocationTargetException;

public class CalculatorService {

    private final double n1;
    private final double n2;

    public CalculatorService(double n1, double n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    public double calculate(String operationSign, boolean isDirect) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        if (operationSign.equals("/") && n2 == 0) {
            throw new DivisionException("Nicht durch 0 teilen!");
        }
        Class<? extends CalculatorFunction> function = getFunction(operationSign);
        double answer;
        if (isDirect) {
            answer = (double) function.getDeclaredMethod("calculate", double.class).invoke(function.getDeclaredConstructor().newInstance(), n1);
        } else {
            answer = (double) function.getDeclaredMethod("calculate", double.class, double.class).invoke(function.getDeclaredConstructor().newInstance(), n1, n2);
        }
        return answer;

    }

    private Class<? extends CalculatorFunction> getFunction(String sign) {
        ExtensibleFunctionsLoader loader = new ExtensibleFunctionsLoader();

        return loader.getFunctionByCaption(sign);
    }
}

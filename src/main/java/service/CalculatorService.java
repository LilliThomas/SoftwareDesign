package service;

import exceptions.DivisionException;
import functions.extensible.CalculatorFunction;
import reflection.ExtensibleFunctionsLoader;

import java.lang.reflect.InvocationTargetException;

/**
 * Service to calculate the answer from the numbers {this.n1} and {this.n2} based on the entered operation.
 */
public class CalculatorService {

    private final double n1;
    private final double n2;

    /**
     * Constructor of CalculatorService that only sets the numbers for the calculation.
     * @param n1    first number of calculation
     * @param n2    second number of calculation
     */
    public CalculatorService(double n1, double n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    /**
     * Calculates the result of numbers entered in constructor with the operation that is parsed from the operationSign.
     * @param operationSign                 sign of the operation, e.g. "+" or "sin(x)"
     * @param isDirect                      if the operator only needs one number to calculate, e.g. sin(x)
     * @return                              the result of the calculation
     * @throws NoSuchMethodException        possible if error in reflections
     * @throws InvocationTargetException    possible if error in reflections
     * @throws IllegalAccessException       possible if error in reflections
     * @throws InstantiationException       possible if error in reflections
     */
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

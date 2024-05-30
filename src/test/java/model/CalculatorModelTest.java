package model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorModelTest {

    private static CalculatorModel model;

    @BeforeAll
    static void before() {
        model = new CalculatorModel();
    }

    @Test
    void resetAll() {
        model.resetAll();
        assertEquals(0, model.getAns());
        assertEquals(0, model.getEnteredNumber());
    }

    @Test
    void resetEnteredNumber() {
        model.resetEnteredNumber();
        assertEquals(0, model.getEnteredNumber());
    }

    @Test
    void calculatePlus() {
        model.setAns(2);
        model.setEnteredNumber(2);
        assertEquals(4, model.calculate(Operation.PLUS));
    }

    @Test
    void calculateMinus() {
        model.setAns(2);
        model.setEnteredNumber(2);
        assertEquals(0, model.calculate(Operation.MINUS));
    }

    @Test
    void calculateTimes() {
        model.setAns(2);
        model.setEnteredNumber(2);
        assertEquals(4, model.calculate(Operation.TIMES));
    }

    @Test
    void calculateDivide() {
        model.setAns(2);
        model.setEnteredNumber(2);
        assertEquals(1, model.calculate(Operation.DIVIDE));
    }

    @Test
    void calculateRoot() {
        model.setAns(4);
        model.setEnteredNumber(2);
        assertEquals(2, model.calculate(Operation.ROOT));
    }

    @Test
    void calculateSquare() {
        model.setAns(2);
        model.setEnteredNumber(2);
        assertEquals(4, model.calculate(Operation.SQUARE));
    }

    @Test
    void calculateReciprocal() {
        model.setAns(2);
        model.setEnteredNumber(2);
        assertEquals(0.5, model.calculate(Operation.RECIPROCAL));
    }

    /*@ParameterizedTest
    @ValueSource(floats = {-3, -1, 0, 1,2.5f,3, Float.MAX_VALUE})
    void testCalculateCosEnteredNumberSuccessful(float parameter) {
        double expectedResult = Math.cos(parameter);
        model.setEnteredNumber(parameter);
        double actualResult = model.calculate(Operation.COS);
        assertEquals(expectedResult, actualResult);
    }
    @ParameterizedTest
    @ValueSource(floats = {-3, -1, 0, 1,2.5f,3, Float.MAX_VALUE})
    void testCalculateSinEnteredNumberSuccessful(float parameter) {
        double expectedResult = Math.sin(parameter);
        model.setEnteredNumber(parameter);
        double actualResult = model.calculate(Operation.SIN);
        assertEquals(expectedResult, actualResult);
    }
    @ParameterizedTest
    @ValueSource(floats = {-3, -1, 0, 1,2.5f,3, Float.MAX_VALUE})
    void testCalculateTanEnteredNumberSuccessful(float parameter) {
        double expectedResult = Math.tan(parameter);
        model.setEnteredNumber(parameter);
        double actualResult = model.calculate(Operation.TAN);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getSinCaption() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        String expectedCaption = "sin(x)";
        String actualCaption = model.getSinCaption();
        assertEquals(expectedCaption, actualCaption);
    }

    @Test
    void getCosCaption() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        String expectedCaption = "cos(x)";
        String actualCaption = model.getCosCaption();
        assertEquals(expectedCaption, actualCaption);
    }

    @Test
    void getTanCaption() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        String expectedCaption = "tan(x)";
        String actualCaption = model.getTanCaption();
        assertEquals(expectedCaption, actualCaption);
    }*/
}
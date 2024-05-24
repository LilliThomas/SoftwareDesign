package model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorModelTest {

    private CalculatorModel model;

    @BeforeEach
    void before() {
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
        model.setEnteredNumber(2);
        model.setAns(2);
        model.setOperation(Operation.PLUS);
        assertEquals(4, model.calculate());
    }

    @Test
    void calculateMinus() {
        model.setAns(2);
        model.setEnteredNumber(2);
        model.setOperation(Operation.MINUS);
        assertEquals(0, model.calculate());
    }

    @Test
    void calculateTimes() {
        model.setAns(2);
        model.setEnteredNumber(2);
        model.setOperation(Operation.TIMES);
        assertEquals(4, model.calculate());
    }

    @Test
    void calculateDivide() {
        model.setAns(2);
        model.setEnteredNumber(2);
        model.setOperation(Operation.DIVIDE);
        assertEquals(1, model.calculate());
    }

    @Test
    void calculateRoot() {
        model.setAns(4);
        model.setEnteredNumber(2);
        model.setOperation(Operation.ROOT);
        assertEquals(2, model.calculate());
    }

    @Test
    void calculateSquare() {
        model.setAns(2);
        model.setEnteredNumber(2);
        model.setOperation(Operation.SQUARE);
        assertEquals(4, model.calculate());
    }
/*
    @ParameterizedTest
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
    }*/
}
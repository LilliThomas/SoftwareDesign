package model;

import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorModelTest {

    private static CalculatorModel model;

    @BeforeAll
    static void before() {
        model = new CalculatorModel();
    }

    @org.junit.jupiter.api.Test
    void resetAll() {
        model.resetAll();
        assertEquals(0, model.getAns());
        assertEquals(0, model.getEnteredNumber());
    }

    @org.junit.jupiter.api.Test
    void resetEnteredNumber() {
        model.resetEnteredNumber();
        assertEquals(0, model.getEnteredNumber());
    }

    @org.junit.jupiter.api.Test
    void calculatePlus() {
        model.setAns(2);
        model.setEnteredNumber(2);
        assertEquals(4, model.calculate(Operation.PLUS));
    }

    @org.junit.jupiter.api.Test
    void calculateMinus() {
        model.setAns(2);
        model.setEnteredNumber(2);
        assertEquals(0, model.calculate(Operation.MINUS));
    }

    @org.junit.jupiter.api.Test
    void calculateTimes() {
        model.setAns(2);
        model.setEnteredNumber(2);
        assertEquals(4, model.calculate(Operation.TIMES));
    }

    @org.junit.jupiter.api.Test
    void calculateDivide() {
        model.setAns(2);
        model.setEnteredNumber(2);
        assertEquals(1, model.calculate(Operation.DIVIDE));
    }

    @org.junit.jupiter.api.Test
    void calculateRoot() {
        model.setAns(4);
        model.setEnteredNumber(2);
        assertEquals(2, model.calculate(Operation.ROOT));
    }

    @org.junit.jupiter.api.Test
    void calculateSquare() {
        model.setAns(2);
        model.setEnteredNumber(2);
        assertEquals(4, model.calculate(Operation.SQUARE));
    }

    @org.junit.jupiter.api.Test
    void calculateReciprocal() {
        model.setAns(2);
        model.setEnteredNumber(2);
        assertEquals(0.5, model.calculate(Operation.RECIPROCAL));
    }
}
package service;

import exceptions.DivisionException;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceTest {

    private CalculatorService service;

    @Before
    public void setUp() {
        service = new CalculatorService(100, 2);
    }


    @Test
    public void calculatePlus() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        double actual = service.calculate("+", false);
        assertEquals(102, actual);
    }

    @Test
    public void calculateMinus() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        double actual = service.calculate("-", false);
        assertEquals(98, actual);
    }

    @Test
    public void calculateTimes() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        double actual = service.calculate("*", false);
        assertEquals(200, actual);
    }

    @Test
    public void calculateDivide() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        double actual = service.calculate("/", false);
        assertEquals(50, actual);
    }

    @Test
    public void calculateDivide_Wrong() {
        service = new CalculatorService(10, 0);
        assertThrows(DivisionException.class, () -> service.calculate("/", false));
    }

    @Test
    public void calculateInverse() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        double actual = service.calculate("(-x)", true);
        assertEquals(-100, actual);
    }

    @Test
    public void calculateSqrt() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        double actual = service.calculate("sqrt(x)", true);
        assertEquals(10, actual);
    }

    @Test
    public void calculateSquare() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        double actual = service.calculate("(x)^2", true);
        assertEquals(10000, actual);
    }

}
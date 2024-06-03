package reflection;

import functions.basic.*;
import functions.extensible.CalculatorFunction;
import functions.extensible.CosFunction;
import functions.extensible.SinFunction;
import functions.extensible.TanFunction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.util.LinkedHashSet;

import java.util.Set;


import static org.junit.jupiter.api.Assertions.*;

class ExtensibleFunctionsLoaderTest {

    private static ExtensibleFunctionsLoader objectUnderTest;

    @BeforeAll
    static void setUp() {
        objectUnderTest = new ExtensibleFunctionsLoader();
    }

    @Test
    void loadExtensibleFunctionSubClasses() {
        Set<Class<? extends CalculatorFunction>> expectedResult = new LinkedHashSet<>();
        expectedResult.add(SinFunction.class);
        expectedResult.add(CosFunction.class);
        expectedResult.add(TanFunction.class);
        Set<Class<? extends CalculatorFunction>> actualResult = objectUnderTest.loadCalculatorFunctionSubClasses();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void loadAllFunctionSubClasses() {
        Set<Class<? extends CalculatorFunction>> expectedResult = new LinkedHashSet<>();
        expectedResult.add(SinFunction.class);
        expectedResult.add(CosFunction.class);
        expectedResult.add(TanFunction.class);
        expectedResult.add(DivideFunction.class);
        expectedResult.add(InverseFunction.class);
        expectedResult.add(MinusFunction.class);
        expectedResult.add(PlusFunction.class);
        expectedResult.add(SqrtFunction.class);
        expectedResult.add(SquareFunction.class);
        expectedResult.add(TimesFunction.class);
        Set<Class<? extends CalculatorFunction>> actualResult = objectUnderTest.loadCalculatorFunctionSubClasses();
        assertEquals(expectedResult, actualResult);
    }


}
package extensiblefunctions;

import functions.extensible.CalculatorFunction;
import functions.extensible.CosFunction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CosFunctionTest {

    private final CalculatorFunction objectUnderTest = new CosFunction();

    @ParameterizedTest
    @ValueSource(doubles = {-3, -1, 0,1,2.5,3, Double.MAX_VALUE})
    void testCalculateSuccessful(double parameter) {
        double expectedResult = Math.cos(parameter);
        double actualResult = objectUnderTest.calculate(parameter);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetCaption() {
        String actualResult = objectUnderTest.getCaption();
        String CAPTION_COS = "cos(x)";
        Assertions.assertEquals(CAPTION_COS, actualResult);
    }
}
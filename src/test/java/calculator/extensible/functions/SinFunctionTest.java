package calculator.extensible.functions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SinFunctionTest {
    private final SinFunction objectUnderTest = new SinFunction();
    private final String CAPTION_SIN = "sin(x)";

    @ParameterizedTest
    @ValueSource(doubles = {-3, -1, 0,1,2.5,3, Double.MAX_VALUE})
    void testCalculateSuccessful(double parameter) {
        double expectedResult = Math.sin(parameter);
        double actualResult = objectUnderTest.calculate(parameter);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetCaption() {
        String actualResult = objectUnderTest.getCaption();
        Assertions.assertEquals(CAPTION_SIN, actualResult);
    }
}
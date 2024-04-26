package extensible.functions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TanFunctionTest {
    private final TanFunction objectUnderTest = new TanFunction();
    private final String CAPTION_TAN = "tan(x)";

    @ParameterizedTest
    @ValueSource(doubles = {-3, -1, 0,1,2.5,3, Double.MAX_VALUE})
    void testCalculateSuccessful(double parameter) {
        double expectedResult = Math.tan(parameter);
        double actualResult = objectUnderTest.calculate(parameter);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void testGetCaption() {
        String actualResult = objectUnderTest.getCaption();
        Assertions.assertEquals(CAPTION_TAN, actualResult);
    }
}
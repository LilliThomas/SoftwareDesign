package reflection;

import extensible.functions.CalculatorFunction;
import extensible.functions.CosFunction;
import extensible.functions.SinFunction;
import extensible.functions.TanFunction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Stream;

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

    @ParameterizedTest
    @ValueSource(strings = {"SinFunction", "CosFunction", "TanFunction"})
    void getSpecificClass(String className) {
        Class<?> clazz = objectUnderTest.getSpecificClass(className);
        assertEquals(className, clazz.getSimpleName());
    }

    @Test
    void getSpecificClass_wrongClass() {
        assertThrows(NoSuchElementException.class, () -> objectUnderTest.getSpecificClass("foo"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"SinFunction", "CosFunction", "TanFunction"})
    void getMethodsFromSpecificClass(String className) {
        Method[] actualMethods = objectUnderTest.getMethodsFromSpecificClass(className);
        assertAll(
                () -> assertEquals(2, actualMethods.length),
                () -> assertEquals("calculate", actualMethods[0].getName()),
                () -> assertEquals("getCaption", actualMethods[1].getName())
        );
    }

    @Test
    void getMethodsFromSpecificClass_WrongClass() {
        assertThrows(NoSuchElementException.class, () -> objectUnderTest.getMethodsFromSpecificClass("foo"));
    }

    @ParameterizedTest
    @MethodSource("stringArrayProvider")
    void getSpecificMethodFromSpecificClass(String[] data) throws NoSuchMethodException {
        String className = data[0];
        String methodName = data[1];
        Method actualMethod = objectUnderTest.getSpecificMethodFromSpecificClass(className, methodName);
        assertEquals(methodName, actualMethod.getName());
    }

    static Stream<Arguments> stringArrayProvider() {
        return Stream.of(
                Arguments.of((Object) new String[]{"SinFunction", "calculate"}),
                Arguments.of((Object) new String[]{"SinFunction", "getCaption"}),
                Arguments.of((Object) new String[]{"CosFunction", "calculate"}),
                Arguments.of((Object) new String[]{"CosFunction", "getCaption"}),
                Arguments.of((Object) new String[]{"TanFunction", "calculate"}),
                Arguments.of((Object) new String[]{"TanFunction", "getCaption"})
        );
    }

    @Test
    void getSpecificMethodFromSpecificClass_wrongClass() {
        assertThrows(NoSuchElementException.class, () -> objectUnderTest.getSpecificMethodFromSpecificClass("foo", "calculate"));
    }

    @Test
    void getSpecificMethodFromSpecificClass_wrongMethod() {
        assertThrows(NoSuchMethodException.class, () -> objectUnderTest.getSpecificMethodFromSpecificClass("SinFunction", "foo"));
    }
}
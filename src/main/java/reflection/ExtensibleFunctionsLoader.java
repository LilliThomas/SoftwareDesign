package reflection;

import java.lang.reflect.Method;
import java.util.NoSuchElementException;
import java.util.Set;

import extensible.functions.CalculatorFunction;
import org.reflections.Reflections;

public class ExtensibleFunctionsLoader {
    private static final String COULD_NOT_BE_FOUND = " could not be found.";
    CalculatorFunction calculatorFunction;

    public Set<Class<? extends CalculatorFunction>> loadCalculatorFunctionSubClasses() {
        Reflections reflections = new Reflections(CalculatorFunction.class);
        return reflections.getSubTypesOf(CalculatorFunction.class);
    }

    public Class<? extends CalculatorFunction> getSpecificClass(String className) {
        Set<Class<? extends CalculatorFunction>> subClasses = loadCalculatorFunctionSubClasses();
        for (Class clazz : subClasses) {
            if (clazz.getSimpleName().equals(className)) {
                return clazz;
            }
        }
        throw new NoSuchElementException("The class " + COULD_NOT_BE_FOUND);
    }

    public Method[] getMethodsFromSpecificClass(String clazz) {
        for (Class c : loadCalculatorFunctionSubClasses()) {
            if (c.getSimpleName().equals(clazz)) {
                return c.getDeclaredMethods();
            }
        }
        throw new NoSuchElementException("The class " + clazz + COULD_NOT_BE_FOUND);
    }

    public Method getSpecificMethodFromSpecificClass(String clazz, String method) throws NoSuchMethodException {
        Method[] methods = getMethodsFromSpecificClass(clazz);
        for (Method m : methods) {
            if (m.getName().equals(method)) {
                return m;
            }
        }
        throw new NoSuchMethodException("The method " + method + COULD_NOT_BE_FOUND);
    }
}

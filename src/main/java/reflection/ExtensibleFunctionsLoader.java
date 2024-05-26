package reflection;

import extensible.functions.CalculatorFunction;
import org.reflections.Reflections;

import java.lang.reflect.Method;
import java.util.NoSuchElementException;
import java.util.Set;

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
            if (hasClassName(clazz, className)) {
                return clazz;
            }
        }
        throw new NoSuchElementException("The class " + COULD_NOT_BE_FOUND);
    }

    private static boolean hasClassName(Class clazz, String className) {   /* oder wie auch immer die Methode heißen soll*/
        return className.equals(clazz.getSimpleName());
    }

    public Method[] getMethodsFromSpecificClass(String classname) {
        for (Class c : loadCalculatorFunctionSubClasses()) {
            if (hasClassName(c, classname)) {
                //TODO achtung NPE Exception
                return c.getDeclaredMethods();
            }
        }
        throw new NoSuchElementException("The class " + classname + COULD_NOT_BE_FOUND);
    }

    public Method getSpecificMethodFromSpecificClass(String clazz, String methodName) throws NoSuchMethodException {
        Method[] methods = getMethodsFromSpecificClass(clazz);
        for (Method m : methods) {
            if (hasMethodName(m, methodName)) {
                return m;
            }
        }
        throw new NoSuchMethodException("The method " + methodName + COULD_NOT_BE_FOUND);
    }

    private static boolean hasMethodName(Method method, String methodName) {
        return method.getName().equals(methodName);
    }
}

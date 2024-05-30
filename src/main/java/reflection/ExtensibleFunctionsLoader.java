package reflection;

import extensible.functions.CalculatorFunction;
import org.reflections.Reflections;

import java.lang.reflect.Method;
import java.util.NoSuchElementException;
import java.util.Set;

public class ExtensibleFunctionsLoader {
    private static final String COULD_NOT_BE_FOUND = " could not be found.";

    public Set<Class<? extends CalculatorFunction>> loadCalculatorFunctionSubClasses() {
        Reflections reflections = new Reflections(CalculatorFunction.class);
        return reflections.getSubTypesOf(CalculatorFunction.class);
    }

    public Object[][] getMethodsFromAllClasses(Set<Class<? extends CalculatorFunction>> classes) throws NoSuchMethodException {
        if (classes.isEmpty()) {
            throw new NoSuchMethodException("CalculatorFunction has no sub classes!");
        }

        Object[][] classesAndMethodsArray = new Object[classes.size()][2];
        int index = 0;

        for (Class<?> classMethods : classes) {
            classesAndMethodsArray[index++] = new Method[] {
                    classMethods.getDeclaredMethod("getCaption"),
                    classMethods.getDeclaredMethod("calculate")
            };
        }

        return classesAndMethodsArray;
    }

    // TODO: ist eigentlich nicht mehr nötig, da die Methode getMethodsFromAllClasses() nur benötigt wird
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

package reflection;

import exceptions.ReflectionException;
import functions.extensible.CalculatorFunction;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The ExtensibleFunctionsLoader class is responsible for loading and managing extensible calculator functions.
 * It uses reflection to discover and instantiate classes that extend the CalculatorFunction class.
 */
public class ExtensibleFunctionsLoader {
    private static final String COULD_NOT_BE_FOUND = " could not be found.";

    /**
     * Loads all subclasses of CalculatorFunction from the "functions" package.
     * @return A set of classes that extend CalculatorFunction.
     */
    public Set<Class<? extends CalculatorFunction>> loadCalculatorFunctionSubClasses() {
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forPackage("functions"))
                .setScanners(Scanners.SubTypes));
        return reflections.getSubTypesOf(CalculatorFunction.class);
    }

    /**
     * Loads all extensible function classes, excluding those in the "functions.basic" package.
     * @return A set of extensible function classes.
     */
    public Set<Class<? extends CalculatorFunction>> loadExtensibleFunctionsClasses() {
        Set<Class<? extends CalculatorFunction>> allSubclasses = this.loadCalculatorFunctionSubClasses();
        return allSubclasses.stream().filter(aClass -> !shouldIgnorePackage(aClass)).collect(Collectors.toSet());
    }

    private boolean shouldIgnorePackage(Class<?> aClass) {
        String packageName = aClass.getPackageName();
        return packageName.equals("functions.basic");
    }

    /**
     * Finds a function class by its caption.
     * @param caption The caption of the function.
     * @return The function class with the given caption, or null if no such class exists.
     */
    public Class<? extends CalculatorFunction> getFunctionByCaption(String caption) {
        Set<Class<? extends CalculatorFunction>> classes = this.loadCalculatorFunctionSubClasses();
        return classes.stream().filter(aClass -> {
            try {
                return aClass.getDeclaredMethod("getCaption").invoke(aClass.getDeclaredConstructor().newInstance()).equals(caption);
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException |
                     InstantiationException e) {
                throw new ReflectionException(COULD_NOT_BE_FOUND);
            }
        }).findFirst().orElse(null);
    }

    /**
     * Gets the names of all extensible functions.
     * @return A list of the names of the extensible function classes.
     */
    public List<String> getExtensibleFunctionNames() {
        return this.loadExtensibleFunctionsClasses().stream().map(aClass -> {
            try {
                return  (String) aClass.getDeclaredMethod("getCaption").invoke(aClass.getDeclaredConstructor().newInstance());
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException |
                     InstantiationException e) {
                throw new ReflectionException(COULD_NOT_BE_FOUND);
            }
        }).toList();
    }
}

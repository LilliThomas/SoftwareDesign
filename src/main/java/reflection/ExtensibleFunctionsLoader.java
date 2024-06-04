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

public class ExtensibleFunctionsLoader {
    private static final String COULD_NOT_BE_FOUND = " could not be found.";

    public Set<Class<? extends CalculatorFunction>> loadCalculatorFunctionSubClasses() {
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forPackage("functions"))
                .setScanners(Scanners.SubTypes));
        return reflections.getSubTypesOf(CalculatorFunction.class);
    }

    public Set<Class<? extends CalculatorFunction>> loadExtensibleFunctionsClasses() {
        Set<Class<? extends CalculatorFunction>> allSubclasses = this.loadCalculatorFunctionSubClasses();
        return allSubclasses.stream().filter(aClass -> !shouldIgnorePackage(aClass)).collect(Collectors.toSet());
    }

    private boolean shouldIgnorePackage(Class<?> aClass) {
        String packageName = aClass.getPackageName();
        return packageName.equals("functions.basic");
    }

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

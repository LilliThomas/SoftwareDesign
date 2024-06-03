package functions.extensible;

public interface CalculatorFunction {
    double calculate(double p1, double p2);

    double calculate(double parameter);
    String getCaption();
}

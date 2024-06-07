package model;

import exceptions.DivisionException;
import reflection.ExtensibleFunctionsLoader;
import service.CalculatorService;
import util.Constants;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * The model of the MVC-pattern and calculates numbers, builds texts, sets content of text.
 */
public class CalculatorModel {

    private final PropertyChangeSupport pcSupport;

    private String bigText;
    private String smallText;

    private final List<String> extensibleFunctionNames;

    private String operation;
    private boolean isDirect;

    private String answer;
    private String prevAnswer;
    private String lastEnteredNumber;

    /**
     * Constructor for CalculatorModel, sets default for all values and initialises {@link PropertyChangeSupport}-Object.
     */
    public CalculatorModel() {
        this.extensibleFunctionNames = new ExtensibleFunctionsLoader().getExtensibleFunctionNames();

        this.bigText = "";
        this.smallText = "";
        this.operation = "";
        this.answer = "0";
        this.prevAnswer = "0";
        this.lastEnteredNumber = "";
        this.pcSupport = new PropertyChangeSupport(this);

    }

    /**
     * Parses the numbers from strings to doubles, creates {@link CalculatorService} and updates texts.
     * @param isFullCalculation             if the "="-button as already been clicked, so the sign should appear in smalltext.
     * @throws InvocationTargetException    possible if error from reflections
     * @throws NoSuchMethodException        possible if error from reflections
     * @throws IllegalAccessException       possible if error from reflections
     * @throws InstantiationException       possible if error from reflections
     */
    public void calculate(boolean isFullCalculation) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        if (lastEnteredNumber.isBlank()) {
            return;
        }
        double p1 = Double.parseDouble(prevAnswer);
        double p2 = Double.parseDouble(lastEnteredNumber);
        CalculatorService service = new CalculatorService(p1, p2);
        try {
            this.answer = String.valueOf(service.calculate(operation, isDirect));
        } catch (DivisionException e) {
            this.answer = e.getMessage();
        }
        this.setBigText(this.answer);
        this.updateSmallText(isFullCalculation);
        this.prevAnswer = this.answer;
    }

    /**
     * Sets content of textfields and variables to default.
     */
    public void resetEverything() {
        this.setBigText("0");
        this.setSmallText("");
        this.operation = "";
        this.answer = "0";
        this.prevAnswer = "0";
        this.lastEnteredNumber = "";
    }

    /**
     * Sets the big textfield to the string that is entered as param and notifies the controller.
     * @param bigText   string that the big textfield should display
     */
    public void setBigText(String bigText) {
        pcSupport.firePropertyChange(Constants.PCL_BIGTEXT, this.bigText, bigText);
        this.bigText = bigText;
    }

    /**
     * Adds the entered string to the existing text in the big textfield.
     * @param bigText   string that should be added to existing text
     */
    public void addToBigText(String bigText) {
        String newBigText = bigText;
        if (!this.bigText.equals("0")) {
            newBigText = this.bigText + bigText;
        }
        pcSupport.firePropertyChange(Constants.PCL_BIGTEXT, this.bigText, newBigText);
        this.bigText = newBigText;
        if (!this.operation.isBlank()) {
            this.lastEnteredNumber = this.bigText;
        } else {
            this.prevAnswer = this.bigText;
        }
    }

    /**
     * Adds a decimal point (german style) to the content in the big textfield.
     */
    public void addDecimalPointToBigText() {
        if (!this.bigText.contains(",")) {
            this.addToBigText(",");
        }
    }

    /**
     * Deletes the last character from the content in the big textfield.
     */
    public void deleteFromBigText() {
        String newBigText = this.bigText.substring(0, bigText.length() - 1);
        if (newBigText.isEmpty()) {
            newBigText = "0";
        }
        pcSupport.firePropertyChange(Constants.PCL_BIGTEXT, this.bigText, newBigText);
        this.bigText = newBigText;
    }

    /**
     * Sets the content of the small textfield and notifies the controller.
     * @param smallText     string that should be displayed
     */
    public void setSmallText(String smallText) {
        pcSupport.firePropertyChange(Constants.PCL_SMALLTEXT, this.smallText, smallText);
        this.smallText = smallText;
    }

    /**
     * Updates the content of the small textfield based on the current calculation.
     * @param fullCalculation   if the "="-button has been clicked
     */
    public void updateSmallText(boolean fullCalculation) {
        CalculationText calculationText;
        if (!fullCalculation) {
            if (!this.operation.isBlank()) {
                calculationText = new CalculationText().builder()
                        .setN1(this.prevAnswer)
                        .setOperation(this.operation)
                        .build();
            } else {
                calculationText = new CalculationText().builder()
                        .setN1(this.lastEnteredNumber)
                        .build();
            }
        } else {
            calculationText = new CalculationText().builder()
                    .setN1(this.prevAnswer)
                    .setN2(this.lastEnteredNumber)
                    .setOperation(this.operation)
                    .build();
        }
        this.setSmallText(calculationText.getCalculationText(isDirect));
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setDirect(boolean direct) {
        this.isDirect = direct;
    }

    public String[] getExtensibleFunctionNames() {
        return this.extensibleFunctionNames.toArray(new String[0]);
    }

    /**
     * Adds a {@link PropertyChangeListener} to the existing {@link PropertyChangeSupport}-object.
     * @param pcl   {@link PropertyChangeListener} to listen to changes for the textfields
     */
    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        pcSupport.addPropertyChangeListener(pcl);
    }
}

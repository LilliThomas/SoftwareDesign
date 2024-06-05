package model;

import reflection.ExtensibleFunctionsLoader;
import service.CalculatorService;
import util.Constants;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

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

    public void calculate(boolean isFullCalculation) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        if (lastEnteredNumber.isBlank()) {
            return;
        }
        double p1 = Double.parseDouble(prevAnswer);
        double p2 = Double.parseDouble(lastEnteredNumber);
        CalculatorService service = new CalculatorService(p1, p2);
        this.answer = String.valueOf(service.calculate(operation, isDirect));
        this.setBigText(this.answer);
        this.updateSmallText(isFullCalculation);
        this.prevAnswer = this.answer;
    }

    public void resetEverything() {
        this.setBigText("0");
        this.setSmallText("");
        this.operation = "";
        this.answer = "0";
        this.prevAnswer = "0";
        this.lastEnteredNumber = "";
    }

    public void setBigText(String bigText) {
        pcSupport.firePropertyChange(Constants.PCL_BIGTEXT, this.bigText, bigText);
        this.bigText = bigText;
    }

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

    public void addDecimalPointToBigText() {
        if (!this.bigText.contains(",")) {
            this.addToBigText(",");
        }
    }

    public void deleteFromBigText() {
        String newBigText = this.bigText.substring(0, bigText.length() - 1);
        if (newBigText.isEmpty()) {
            newBigText = "0";
        }
        pcSupport.firePropertyChange(Constants.PCL_BIGTEXT, this.bigText, newBigText);
        this.bigText = newBigText;
    }


    public void setSmallText(String smallText) {
        pcSupport.firePropertyChange(Constants.PCL_SMALLTEXT, this.smallText, smallText);
        this.smallText = smallText;
    }

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

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        pcSupport.addPropertyChangeListener(pcl);
    }
}

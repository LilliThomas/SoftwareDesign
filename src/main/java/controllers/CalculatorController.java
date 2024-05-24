package controllers;

import exceptions.DivisionException;
import model.CalculationText;
import model.CalculatorModel;
import model.Operation;
import view.CalculatorView;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CalculatorController implements PropertyChangeListener {

    /**
     * State pattern nutzen für views
     * https://www.tutorialspoint.com/design_pattern/state_pattern.htm
     *
     * Builder pattern nutzen für calculationString (erweiterung vom stringbuilder)
     *
     * observer pattern ist drinne
     *
     *
     */

    private final CalculatorView view;
    private final CalculatorModel model;

    // States (vlt. Design pattern dazu???)
    private boolean hasEnteredNumber = false;
    private boolean isInEqualsMode = false;
    private boolean hasDecimalPoint = false;

    public CalculatorController(CalculatorView view, CalculatorModel model) {
        this.view = view;
        this.model = model;

        model.addPropertyChangeListener(this);

        addListeners();
    }

    private void addListeners() {
        view.addClearButtonListener(l -> model.resetAll());
        view.addDeleteButtonListener(l -> model.resetEnteredNumber());

        view.addNumberButtonListener(l -> {
            if (isInEqualsMode) {
                model.resetAll();
                isInEqualsMode = false;
            }
            hasEnteredNumber = true;
            String addedNumber = ((JButton) l.getSource()).getText();
            if (!view.getTextAreaResult().equals("0")) {
                addedNumber = view.getTextAreaResult() + ((JButton) l.getSource()).getText();
            }
            view.setTextResult(addedNumber);
        });

        view.addOperationButtonListener(l -> {
            if (!hasEnteredNumber && !isInEqualsMode) {
                return;
            }
            String clickedOperation = ((JButton) l.getSource()).getText();
            double enteredNumber = Double.parseDouble(view.getTextAreaResult());
            double ans = Double.parseDouble(view.getTextAreaResult());
            Operation operation = mapInputToOperation(clickedOperation);

            model.setEnteredNumber(enteredNumber);
            model.setAns(ans);
            model.setOperation(operation);
            model.resetEnteredNumber();

            CalculationText calculationText = new CalculationText().builder()
                    .setAns(ans)
                    .setEnteredNumber(enteredNumber)
                    .setOperationSign(operation.getSign())
                    .build();

            model.setCalculationString(calculationText);
            hasEnteredNumber = false;
            isInEqualsMode = false;
        });

        view.addEqualsButtonListener(l -> {
            isInEqualsMode = true;

            double enteredNumber = Double.parseDouble(view.getTextAreaResult());
            double ans = Double.parseDouble(view.getTextAreaResult());

            if (hasEnteredNumber) {
                model.setEnteredNumber(enteredNumber);
            } else {
                model.setAns(ans);
            }

            CalculationText calculationText = new CalculationText().builder()
                    .setAns(ans)
                    .setEnteredNumber(enteredNumber)
                    .build();

            model.setCalculationString(calculationText);

            model.calculate();

            hasEnteredNumber = false;
        });

        view.addInverseButtonListener(l -> {
            model.setEnteredNumber(Double.parseDouble(view.getTextAreaResult()) * (-1));
        });

        view.addDirectOperationButtonListener(l -> {
            isInEqualsMode = true;

            String clickedOperation = ((JButton) l.getSource()).getText();
            double ans = Double.parseDouble(view.getTextAreaResult());
            Operation operation = mapInputToOperation(clickedOperation);

            model.setAns(ans);
            model.setOperation(operation);
            model.resetEnteredNumber();

            CalculationText calculationText = new CalculationText().builder()
                    .setAns(ans)
                    .setOperationSign(operation.getSign())
                    .build();

            model.setCalculationString(calculationText);

            model.calculate();
        });

        // kritisch
        view.addDecimalPointButtonListener(l -> {
            hasDecimalPoint = true;

        });
    }

    private Operation mapInputToOperation(String input) {
        return Operation.getBySign(input);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case "enteredNumber", "ans" -> view.setTextResult(String.valueOf(evt.getNewValue()));
            case "calculationString" -> view.setTextCalculation(String.valueOf(evt.getNewValue()));
            default -> throw new RuntimeException();
        }
    }
}

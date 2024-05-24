package controllers;

import model.CalculatorModel;
import model.Operation;
import view.CalculatorView;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CalculatorController implements PropertyChangeListener {

    private final CalculatorView view;
    private final CalculatorModel model;

    private boolean hasEnteredNumber = false;
    private boolean isInEqualsMode = false;

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

            model.setEnteredNumber(Float.parseFloat(view.getTextAreaResult()));
            model.setAns(Float.parseFloat(view.getTextAreaResult()));

            model.addToCalculationString(view.getTextAreaResult());
            model.addToCalculationString(clickedOperation);

            model.setOperation(mapInputToOperation(clickedOperation));
            model.setCalculationString();
            hasEnteredNumber = false;
        });

        view.addEqualsButtonListener(l -> {
            isInEqualsMode = true;
            if (hasEnteredNumber) {
                model.setEnteredNumber(Float.parseFloat(view.getTextAreaResult()));
            } else {
                model.setAns(Float.parseFloat(view.getTextAreaResult()));
            }

            model.setCalculationString();
            model.calculate();

            hasEnteredNumber = false;
        });

        view.addInverseButtonListener(l -> {
            model.setEnteredNumber(Float.parseFloat(view.getTextAreaResult()) * (-1));
        });
    }

    private Operation mapInputToOperation(String input) {
        return Operation.getBySign(input);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case "enteredNumber" -> view.setTextResult(String.valueOf(evt.getNewValue()));
            case "ans" -> view.setTextResult(String.valueOf(evt.getNewValue()));
            case "calculationString" -> view.setTextCalculation(String.valueOf(evt.getNewValue()));
            default -> throw new RuntimeException();
        }
    }
}

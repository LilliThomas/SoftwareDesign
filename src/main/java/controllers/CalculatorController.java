package controllers;

import exceptions.DivisionException;
import model.CalculatorModel;
import model.Operation;
import view.CalculatorView;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CalculatorController implements PropertyChangeListener {

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

            model.setEnteredNumber(Float.parseFloat(view.getTextAreaResult()));
            model.setAns(Float.parseFloat(view.getTextAreaResult()));
            model.setOperation(mapInputToOperation(clickedOperation));
            model.resetEnteredNumber();

            model.setCalculationString();
            hasEnteredNumber = false;
            isInEqualsMode = false;
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

        view.addDirectOperationButtonListener(l -> {
            isInEqualsMode = true;
            String clickedOperation = ((JButton) l.getSource()).getText();

            model.setAns(Float.parseFloat(view.getTextAreaResult()));
            model.setOperation(mapInputToOperation(clickedOperation));
            model.resetEnteredNumber();
            model.setCalculationString();
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
            case "enteredNumber" -> view.setTextResult(String.valueOf(evt.getNewValue()));
            case "ans" -> view.setTextResult(String.valueOf(evt.getNewValue()));
            case "calculationString" -> view.setTextCalculation(String.valueOf(evt.getNewValue()));
            default -> throw new RuntimeException();
        }
    }
}

package controllers;

import model.CalculatorModel;
import util.Constants;
import view.CalculatorView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.InvocationTargetException;

public class CalculatorController implements PropertyChangeListener {

    private final CalculatorView view;
    private final CalculatorModel model;

    public CalculatorController(CalculatorView view, CalculatorModel model) {
        this.view = view;
        this.model = model;

        model.addPropertyChangeListener(this);

        addListeners();
        addExtensibleFunctionNames();
    }

    private void addListeners() {
        view.addClearButtonListener(l -> model.resetEverything());

        view.addDeleteButtonListener(l -> model.deleteFromBigText());

        view.addDecimalPointButtonListener(l-> model.addDecimalPointToBigText());

        view.addDirectOperationButtonListener(l -> {
            String operation = getClickedButtonText(l);
            model.setOperation(operation);
            model.setDirect(true);
            try {
                model.calculate(false);
            } catch (InvocationTargetException | NoSuchMethodException | InstantiationException |
                     IllegalAccessException e) {
                view.displayErrorMessage("Ups");
            }
        });

        view.addEqualsButtonListener(l -> {
            try {

                model.calculate(true);
            } catch (InvocationTargetException | InstantiationException | IllegalAccessException |
                     NoSuchMethodException e) {
                view.displayErrorMessage("Ups");
            }
        });

        view.addMoreFunctionsDropDownListener(l -> {
            String operation = (String) l.getItem();
            model.setOperation(operation);
            model.setDirect(true);
            try {
                model.calculate(false);
            } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException |
                     InstantiationException e) {
                view.displayErrorMessage("Ups");
            }
        });

        view.addNumberButtonListener(l -> {
            model.setDirect(false);
            model.addToBigText(getClickedButtonText(l));
        });

        view.addOperationButtonListener(l -> {
            String operation = getClickedButtonText(l);

            model.setOperation(operation);
            model.setDirect(false);

            try {
                model.calculate(false);
            } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException |
                     InstantiationException e) {
                view.displayErrorMessage("Ups");
            }
            model.updateSmallText(false);
            model.setBigText("0");
        });

    }

    private void addExtensibleFunctionNames() {
        view.setBtnMoreFunctionsOptions(model.getExtensibleFunctionNames());
    }

    private String getClickedButtonText(ActionEvent event) {
        return ((JButton) event.getSource()).getText();
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        switch (event.getPropertyName()) {
            case Constants.PCL_BIGTEXT -> view.setTextResult(String.valueOf(event.getNewValue()));
            case Constants.PCL_SMALLTEXT -> view.setTextCalculation(String.valueOf(event.getNewValue()));
            default -> view.displayErrorMessage("Ups");
        }
    }


}

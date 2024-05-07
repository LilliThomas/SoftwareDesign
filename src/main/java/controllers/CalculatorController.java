package controllers;

import model.CalculatorModel;
import views.CalculatorView;

public class CalculatorController {

    private final CalculatorView view;
    private final CalculatorModel model;

    public CalculatorController(CalculatorView view, CalculatorModel model) {
        this.view = view;
        this.model = model;

        // add listener implementation in controller
    }
}

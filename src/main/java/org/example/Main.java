package org.example;

import controllers.CalculatorController;
import model.CalculatorModel;
import views.CalculatorView;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        CalculatorModel model = new CalculatorModel();
        CalculatorView view = new CalculatorView();
        CalculatorController controller = new CalculatorController(view, model);
    }
}
package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorView extends JFrame{
    private final JButton btn1 = new JButton("1");
    private final JButton btn2 = new JButton("2");
    private final JButton btn3 = new JButton("3");
    private final JButton btn4 = new JButton("4");
    private final JButton btn5 = new JButton("5");
    private final JButton btn6 = new JButton("6");
    private final JButton btn7 = new JButton("7");
    private final JButton btn8 = new JButton("8");
    private final JButton btn9 = new JButton("9");
    private final JButton btn0 = new JButton("0");
    private final JButton btnPlus = new JButton("+");
    private final JButton btnMinus = new JButton("-");
    private final JButton btnMultiply = new JButton("*");
    private final JButton btnDiv = new JButton("/");
    private final JButton btnEqual = new JButton("=");
    private final JButton btnComma = new JButton(".");
    private final JButton btnSign = new JButton("(-)");
    private final JButton btnSqrt = new JButton("sqrt");
    private final JButton btnHistory = new JButton("history");
    private final JButton btnClear = new JButton("clear");
    private final JButton btnMoreFunctions = new JButton("weitere Funktionen");
    private final JButton btnQuadrat = new JButton("^2");
    private final JButton btnDel = new JButton("del");
    private final JTextArea textAreaResult = new JTextArea();
    private final JTextArea textAreaCalculation = new JTextArea();



    public CalculatorView() {

        setTitle("Taschenrechner");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 280);
        JPanel panelText = new JPanel(new GridLayout(4, 1));

        JPanel panelFunction = new JPanel(new GridLayout(1, 1));

        panelText.add(textAreaCalculation);
        panelText.add(textAreaResult);
        add(panelText, BorderLayout.NORTH);

        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(6, 4));

        panelFunction.add(btnMoreFunctions);
        //panelFunction.add(btnHistory);
        add(panelFunction);


        //grid.add(btnSin);
        //grid.add(btnCos);
        grid.add(btnClear);
        grid.add(btnDel);

        //grid.add(btnTan);
        grid.add(btnQuadrat);
        grid.add(btnSqrt);
        grid.add(btnDiv);
        grid.add(btn7);
        grid.add(btn8);
        grid.add(btn9);
        grid.add(btnMultiply);
        grid.add(btn4);
        grid.add(btn5);
        grid.add(btn6);
        grid.add(btnMinus);
        grid.add(btn1);
        grid.add(btn2);
        grid.add(btn3);
        grid.add(btnPlus);
        grid.add(btnSign);
        grid.add(btn0);
        grid.add(btnComma);
        grid.add(btnEqual);
        add(grid, BorderLayout.SOUTH);


        setLocationRelativeTo(null);

        setVisible(true);

        textAreaCalculation.setForeground(Color.RED);
    }
    public void setTextResult(String text) {
        textAreaResult.setText(text);
    }
    public void setTextCalculation(String text) {
        textAreaCalculation.setText(text);
    }

    public void addOperationButtonListener(ActionListener listener) {
        btnPlus.addActionListener(listener);
        btnMinus.addActionListener(listener);
        btnMultiply.addActionListener(listener);
        btnDiv.addActionListener(listener);

    }

    public void addDirectOperationButtonListener(ActionListener listener) {
        btnSqrt.addActionListener(listener);
        btnQuadrat.addActionListener(listener);
    }

    public void addNumberButtonListener(ActionListener listener) {
        btn1.addActionListener(listener);
        btn2.addActionListener(listener);
        btn3.addActionListener(listener);
        btn4.addActionListener(listener);
        btn5.addActionListener(listener);
        btn6.addActionListener(listener);
        btn7.addActionListener(listener);
        btn8.addActionListener(listener);
        btn9.addActionListener(listener);
        btn0.addActionListener(listener);
        btnComma.addActionListener(listener);

    }

    public void addEqualsButtonListener(ActionListener listener) {
        btnEqual.addActionListener(listener);
    }

    public void addDecimalPointButtonListener(ActionListener listener) {
        btnComma.addActionListener(listener);
    }

    public void addInverseButtonListener(ActionListener listener) {
        btnSign.addActionListener(listener);
    }

    public void addDeleteButtonListener(ActionListener listener) {
        btnDel.addActionListener(listener);
    }

    public void addClearButtonListener(ActionListener listener) {
        btnClear.addActionListener(listener);
    }

    public void addMoreFunctionsDropDownListener(ActionListener listener) {
        btnMoreFunctions.addActionListener(listener);
    }


    public void displayErrorMessage(String errorMessage){
         JOptionPane.showMessageDialog(this, errorMessage);
    }

    public String getTextAreaResult() {
        return textAreaResult.getText();
    }
}

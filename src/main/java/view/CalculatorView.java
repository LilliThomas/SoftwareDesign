package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorView extends JFrame {
    JButton btn1 = new JButton("1");
    JButton btn2 = new JButton("2");
    JButton btn3 = new JButton("3");
    JButton btn4 = new JButton("4");
    JButton btn5 = new JButton("5");
    JButton btn6 = new JButton("6");
    JButton btn7 = new JButton("7");
    JButton btn8 = new JButton("8");
    JButton btn9 = new JButton("9");
    JButton btn0 = new JButton("0");
    JButton btnPlus = new JButton("+");
    JButton btnMinus = new JButton("-");
    JButton btnMultiply = new JButton("*");
    JButton btnDiv = new JButton("/");
    JButton btnEqual = new JButton("=");
    JButton btnComma = new JButton(".");
    JButton btnSign = new JButton("(-)");
    JButton btnSqrt = new JButton("sqrt");
    JButton btnClear = new JButton("clear");
    JButton btnMoreFunctions = new JButton("weitere Funktionen");
    JButton btnQuadrat = new JButton("^2");
    JButton btnDel = new JButton("del");
    JTextArea textAreaResult = new JTextArea();
    JTextArea textAreaCalculation = new JTextArea();

    public CalculatorView() {
        setTitle("Taschenrechner");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 280);


        btn1.setName("btn1");
        btn2.setName("btn2");
        btn3.setName("btn3");
        btn4.setName("btn4");
        btn5.setName("btn5");
        btn6.setName("btn6");
        btn7.setName("btn7");
        btn8.setName("btn8");
        btn9.setName("btn9");
        btn0.setName("btn0");
        btnPlus.setName("btnPlus");
        btnMinus.setName("btnMinus");
        btnMultiply.setName("btnMultiply");
        btnDiv.setName("btnDiv");
        btnEqual.setName("btnEqual");
        btnComma.setName("btnComma");
        btnSign.setName("btnSign");
        btnSqrt.setName("btnSqrt");
        btnClear.setName("btnClear");
        btnMoreFunctions.setName("btnMoreFunctions");
        btnQuadrat.setName("btnQuadrat");
        btnDel.setName("btnDel");
        textAreaResult.setName("textAreaResult");
        textAreaCalculation.setName("textAreaCalculation");

        JPanel panelText = new JPanel(new GridLayout(4, 1));
        JPanel panelFunction = new JPanel(new GridLayout(1, 1));

        panelText.add(textAreaCalculation);
        panelText.add(textAreaResult);
        add(panelText, BorderLayout.NORTH);

        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(5, 4));

        panelFunction.add(btnClear);
        panelFunction.add(btnDel);
        add(panelFunction);


        grid.add(btnMoreFunctions);
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
    }

    public void setTextResult(String text) {
        textAreaResult.setText(text);
    }

    public void setTextCalculation(String text) {
        textAreaCalculation.setText(text);
    }

    public void addButtonListener(ActionListener listener) {
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
        btnPlus.addActionListener(listener);
        btnMinus.addActionListener(listener);
        btnMultiply.addActionListener(listener);
        btnDiv.addActionListener(listener);
        btnEqual.addActionListener(listener);
        btnComma.addActionListener(listener);
        btnSign.addActionListener(listener);
        btnSqrt.addActionListener(listener);
        btnClear.addActionListener(listener);
        btnMoreFunctions.addActionListener(listener);
        btnQuadrat.addActionListener(listener);
        btnDel.addActionListener(listener);
    }

    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}

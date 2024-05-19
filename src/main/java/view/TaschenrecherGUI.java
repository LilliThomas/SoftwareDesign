package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TaschenrecherGUI extends JFrame{
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
    JButton btnHistory = new JButton("history");
    JButton btnClear = new JButton("clear");
    JButton btnMoreFunctions = new JButton("weitere Funktionen");
    JButton btnQuadrat = new JButton("^2");
    JButton btnDel = new JButton("del");
    JButton btnSin = new JButton("sin");
    JButton btnCos = new JButton("cos");
    JButton btnTan = new JButton("tan");
    JTextArea textAreaResult = new JTextArea();
    JTextArea textAreaCalculation = new JTextArea();



    public TaschenrecherGUI() {

        setTitle("Taschenrechner");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 250);
        JPanel panelText = new JPanel();

        JPanel panelFunction = new JPanel();

        panelText.add(textAreaCalculation);
        panelText.add(textAreaResult);
        add(panelText, BorderLayout.NORTH);

        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(6, 4));




        panelFunction.add(btnMoreFunctions);
        panelFunction.add(btnHistory);
        add(panelFunction, BorderLayout.CENTER);


        grid.add(btnSin);
        grid.add(btnCos);
        grid.add(btnClear);
        grid.add(btnDel);

        grid.add(btnTan);
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
        btnHistory.addActionListener(listener);
        btnClear.addActionListener(listener);
        btnMoreFunctions.addActionListener(listener);
        btnQuadrat.addActionListener(listener);
        btnDel.addActionListener(listener);
        btnSin.addActionListener(listener);
        btnCos.addActionListener(listener);
        btnTan.addActionListener(listener);
    }


    public void displayErrorMessage(String errorMessage){
         JOptionPane.showMessageDialog(this, errorMessage);
    }

}

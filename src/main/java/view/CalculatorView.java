package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

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
    JButton btnSign = new JButton("(-x)");
    JButton btnSqrt = new JButton("sqrt(x)");
    JButton btnClear = new JButton("clear");
    JComboBox<String> comboBoxMoreFunctions = new JComboBox<>();
    JButton btnQuadrat = new JButton("(x)^2");
    JButton btnDel = new JButton("del");
    JTextArea textAreaResult = new JTextArea();
    JTextArea textAreaCalculation = new JTextArea();

    /**
     * create GUI according to the model of the Windows calculator
     */
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
        comboBoxMoreFunctions.setName("btnMoreFunctions");
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


        grid.add(comboBoxMoreFunctions);
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

    /**
     * Adds an ActionListener to handle operations (e.g., addition, subtraction).
     * @param listener The ActionListener to be added.
     */
    public void addOperationButtonListener(ActionListener listener) {
        btnPlus.addActionListener(listener);
        btnMinus.addActionListener(listener);
        btnMultiply.addActionListener(listener);
        btnDiv.addActionListener(listener);

    }

    /**
     * Adds an ActionListener to handle direct operations (e.g., square root, square).
     * @param listener The ActionListener to be added.
     */
    public void addDirectOperationButtonListener(ActionListener listener) {
        btnSqrt.addActionListener(listener);
        btnQuadrat.addActionListener(listener);
        btnSign.addActionListener(listener);
    }

    /**
     * Adds an ActionListener to handle number buttons.
     * @param listener The ActionListener to be added.
     */
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
    }

    /**
     * Adds an ActionListener to handle the equals button.
     * @param listener The ActionListener to be added.
     */
    public void addEqualsButtonListener(ActionListener listener) {
        btnEqual.addActionListener(listener);
    }

    /**
     * Adds an ActionListener to handle the decimal point button.
     * @param listener The ActionListener to be added.
     */
    public void addDecimalPointButtonListener(ActionListener listener) {
        btnComma.addActionListener(listener);
    }

    /**
     * Adds an ActionListener to handle the delete button.
     * @param listener The ActionListener to be added.
     */
    public void addDeleteButtonListener(ActionListener listener) {
        btnDel.addActionListener(listener);
    }

    /**
     * Adds an ActionListener to handle the clear button.
     * @param listener The ActionListener to be added.
     */
    public void addClearButtonListener(ActionListener listener) {
        btnClear.addActionListener(listener);
    }

    /**
     * Adds an ItemListener to handle the dropdown menu for additional functions.
     * @param listener The ItemListener to be added.
     */
    public void addMoreFunctionsDropDownListener(ItemListener listener) {
        comboBoxMoreFunctions.addItemListener(listener);
    }

    public void setBtnMoreFunctionsOptions(String[] options) {
        comboBoxMoreFunctions.setModel(new DefaultComboBoxModel<>(options));
    }

    /**
     * Displays an error message dialog box.
     * @param errorMessage The error message to be displayed.
     */
    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}

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
    JButton plus = new JButton("+");
    JButton minus = new JButton("-");
    JButton mal = new JButton("*");
    JButton div = new JButton("/");
    JButton gleich = new JButton("=");
    JButton komma = new JButton(".");
    JButton vorzeichen = new JButton("(-)");
    JButton sqrt = new JButton("sqrt");
    JButton history = new JButton("history");
    JButton btnClear = new JButton("clear");
    JButton btnWeitereFunktionen = new JButton("weitere Funktionen");
    JButton btnQuadrat = new JButton("^2");
    JButton btnDel = new JButton("del");
    JButton btnSin = new JButton("sin");
    JButton btnCos = new JButton("cos");
    JButton btnTan = new JButton("tan");
    JTextArea textArea = new JTextArea();

    public TaschenrecherGUI() {

        setTitle("Taschenrechner");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 250);

        JPanel panel = new JPanel();


        add(textArea, BorderLayout.NORTH);


        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(6, 4));




        panel.add(btnWeitereFunktionen);
        panel.add(history);
        add(panel, BorderLayout.CENTER);


        grid.add(btnSin);
        grid.add(btnCos);
        grid.add(btnClear);
        grid.add(btnDel);

        grid.add(btnTan);
        grid.add(btnQuadrat);
        grid.add(sqrt);
        grid.add(div);
        grid.add(btn7);
        grid.add(btn8);
        grid.add(btn9);
        grid.add(mal);
        grid.add(btn4);
        grid.add(btn5);
        grid.add(btn6);
        grid.add(minus);
        grid.add(btn1);
        grid.add(btn2);
        grid.add(btn3);
        grid.add(plus);
        grid.add(vorzeichen);
        grid.add(btn0);
        grid.add(komma);
        grid.add(gleich);
        add(grid, BorderLayout.SOUTH);


        setLocationRelativeTo(null);

        setVisible(true);


    }
    public void setText(String text) {
        textArea.setText(text);
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
        plus.addActionListener(listener);
        minus.addActionListener(listener);
        mal.addActionListener(listener);
        div.addActionListener(listener);
        gleich.addActionListener(listener);
        komma.addActionListener(listener);
        vorzeichen.addActionListener(listener);
        sqrt.addActionListener(listener);
        history.addActionListener(listener);
        btnClear.addActionListener(listener);
        btnWeitereFunktionen.addActionListener(listener);
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

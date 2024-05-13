package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TaschenrecherGUI extends JFrame{
    private JButton buttonMinus = new JButton("-");
    private JButton buttonMal  = new JButton("*");
    private JButton buttonGeteilt = new JButton("/");
    private JButton buttonWurzel = new JButton("sqert");
    private JButton buttonZiffer9 = new JButton("9");
    private JButton buttonZiffer6 = new JButton("6");
    private JButton buttonZiffer3 = new JButton("3");
    private JButton buttonKomma = new JButton(",");
    private JButton buttonQuadrat = new JButton("^2");
    private JButton buttonZiffer8 = new JButton("8");
    private JButton buttonZiffer5 = new JButton("5");
    private JButton buttonZiffer2 = new JButton("2");
    private JButton buttonZiffer0 = new JButton("0");
    private JButton buttonZiffer7 = new JButton("7");
    private JButton buttonWeiterFunktionen  = new JButton("Funktionen");
    private JButton buttonZiffer4 = new JButton("4");
    private JButton buttonZiffer1 = new JButton("1");
    private JButton buttonVorzeichen  = new JButton("(-)");
    private JButton buttonDEL = new JButton("del");
    private JButton buttonC = new JButton("C");
    private JButton buttonPlus  = new JButton("+");
    private JButton buttonGleich = new JButton("=");
    private JButton buttonCE = new JButton("CE");
    private JButton buttonProzent = new JButton("Prozent");
    private JPanel textcontainer;
    private JPanel buttoncontainer;
    private JPanel container;
    private JTextField anzeige = new JTextField();

    public TaschenrecherGUI() {

        setTitle("Taschenrechner");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 200);
        setLocationRelativeTo(null);
        setVisible(true);
        JPanel textcontainer = new JPanel();
        JPanel buttoncontainer = new JPanel();

        JPanel container = new JPanel();
        textcontainer.setAlignmentX(Component.TOP_ALIGNMENT);
        //container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        buttoncontainer.setLayout(new GridLayout(6,4));
        //buttoncontainer.setAlignmentY(CENTER_ALIGNMENT);
        buttoncontainer.add(buttonMinus);
        buttoncontainer.add(buttonMal);
        buttoncontainer.add(buttonGeteilt);
        buttoncontainer.add(buttonWurzel);
        buttoncontainer.add(buttonZiffer9);
        buttoncontainer.add(buttonZiffer6);
        buttoncontainer.add(buttonZiffer3);
        buttoncontainer.add(buttonKomma);
        buttoncontainer.add(buttonQuadrat);
        buttoncontainer.add(buttonZiffer8);
        buttoncontainer.add(buttonZiffer5);
        buttoncontainer.add(buttonZiffer2);
        buttoncontainer.add(buttonZiffer0);
        buttoncontainer.add(buttonZiffer7);
        buttoncontainer.add(buttonWeiterFunktionen);
        buttoncontainer.add(buttonZiffer4);
        buttoncontainer.add(buttonZiffer1);
        buttoncontainer.add(buttonVorzeichen);
        buttoncontainer.add(buttonDEL);
        buttoncontainer.add(buttonC);
        buttoncontainer.add(buttonPlus);
        buttoncontainer.add(buttonGleich);
        buttoncontainer.add(buttonCE);
        buttoncontainer.add(buttonProzent);
        textcontainer.add(anzeige);
        container.add(textcontainer, BorderLayout.CENTER);
        container.add(buttoncontainer);
        add(container);
    }
    public void addSubtraktionListener(ActionListener listenForSubtraktionButton) {
        buttonMinus.addActionListener(listenForSubtraktionButton);
    }

    public void addMultiplikationListener(ActionListener listenForMultiplikationButton) {
        buttonMal.addActionListener(listenForMultiplikationButton);
    }

    public void addDivisionListener(ActionListener listenForDivisionButton) {
        buttonGeteilt.addActionListener(listenForDivisionButton);
    }
    public void addWurzelListener(ActionListener listenForWurzelButton) {
        buttonWurzel.addActionListener(listenForWurzelButton);
    }
    public void addZiffer9Listener(ActionListener listenForZiffer9Button) {
        buttonZiffer9.addActionListener(listenForZiffer9Button);
    }
    public void addZiffer6Listener(ActionListener listenForZiffer6Button) {
        buttonZiffer6.addActionListener(listenForZiffer6Button);
    }
    public void addZiffer3Listener(ActionListener listenForZiffer3Button) {
        buttonZiffer3.addActionListener(listenForZiffer3Button);
    }
    public void addKommaListener(ActionListener listenForKommaButton) {
        buttonKomma.addActionListener(listenForKommaButton);
    }
    public void addQuadratListener(ActionListener listenForQuadratButton) {
        buttonQuadrat.addActionListener(listenForQuadratButton);
    }
    public void addZiffer8Listener(ActionListener listenForZiffer8Button) {
        buttonZiffer8.addActionListener(listenForZiffer8Button);
    }
    public void addZiffer5Listener(ActionListener listenForZiffer5Button) {
        buttonZiffer5.addActionListener(listenForZiffer5Button);
    }
    public void addZiffer2Listener(ActionListener listenForZiffer2Button) {
        buttonZiffer2.addActionListener(listenForZiffer2Button);
    }
    public void addZiffer0Listener(ActionListener listenForZiffer0Button) {
        buttonZiffer0.addActionListener(listenForZiffer0Button);
    }
    public void addZiffer7Listener(ActionListener listenForZiffer7Button) {
        buttonZiffer7.addActionListener(listenForZiffer7Button);
    }
    public void addZiffer4Listener(ActionListener listenForZiffer4Button) {
        buttonZiffer4.addActionListener(listenForZiffer4Button);
    }
    public void addZiffer1Listener(ActionListener listenForZiffer1Button) {
        buttonZiffer1.addActionListener(listenForZiffer1Button);
    }
    public void addVorzeichenListener(ActionListener listenForVorzeichenButton) {
        buttonVorzeichen.addActionListener(listenForVorzeichenButton);
    }
    public void addDELListener(ActionListener listenForDELButton) {

        buttonDEL.addActionListener(listenForDELButton);
    }
    public void addCListener(ActionListener listenForCButton) {
        buttonC.addActionListener(listenForCButton);
    }
    public void addErgebnisListener(ActionListener listenForErgebnisButton) {
        buttonGleich.addActionListener(listenForErgebnisButton);
    }
    public void addCEListener(ActionListener listenForCEButton) {
        buttonCE.addActionListener(listenForCEButton);
    }
    public void addProzentListener(ActionListener listenForProzentButton) {
        buttonProzent.addActionListener(listenForProzentButton);
    }
     public void addAdditionListener(ActionListener listenForAdditionButton) {
        buttonPlus.addActionListener(listenForAdditionButton);
     }
    public void displayErrorMessage(String errorMessage){
         JOptionPane.showMessageDialog(this, errorMessage);
    }

}

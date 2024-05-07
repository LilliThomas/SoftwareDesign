import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaschenrecherGUI extends JFrame{
    private JButton buttonMinus;
    private JButton buttonMal;
    private JButton buttonGeteilt;
    private JButton buttonWurzel;
    private JButton buttonZiffer9;
    private JButton buttonZiffer6;
    private JButton buttonZiffer3;
    private JButton buttonKomma;
    private JButton buttonQuadrat;
    private JButton buttonZiffer8;
    private JButton buttonZiffer5;
    private JButton buttonZiffer2;
    private JButton buttonZiffer0;
    private JButton buttonZiffer7;
    private JButton buttonWeiterFunktionen;
    private JButton buttonZiffer4;
    private JButton buttonZiffer1;
    private JButton buttonVorzeichen;
    private JButton buttonDEL;
    private JButton buttonC;
    private JButton buttonPlus;
    private JButton buttonGleich;
    private JButton buttonCE;
    private JButton buttonProzent;

    public TaschenrecherGUI(JButton buttonMinus, JButton buttonMal, JButton buttonGeteilt, JButton buttonKlammerZu, JButton buttonZiffer9, JButton buttonZiffer6, JButton buttonZiffer3, JButton buttonKomma, JButton buttonKlammerAuf, JButton buttonZiffer8, JButton buttonZiffer5, JButton buttonZiffer2, JButton buttonZiffer0, JButton buttonZiffer7, JButton buttonWeiterFunktionen, JButton buttonZiffer4, JButton buttonZiffer1, JButton buttonVorzeichen, JButton buttonDel, JButton buttonC, JButton buttonPlus, JButton buttonGleich, JButton buttonCe){
        this.buttonMinus = buttonMinus;
        this.buttonMal = buttonMal;
        this.buttonGeteilt = buttonGeteilt;
        this.buttonWurzel = buttonKlammerZu;
        this.buttonZiffer9 = buttonZiffer9;
        this.buttonZiffer6 = buttonZiffer6;
        this.buttonZiffer3 = buttonZiffer3;
        this.buttonKomma = buttonKomma;
        this.buttonQuadrat = buttonKlammerAuf;
        this.buttonZiffer8 = buttonZiffer8;
        this.buttonZiffer5 = buttonZiffer5;
        this.buttonZiffer2 = buttonZiffer2;
        this.buttonZiffer0 = buttonZiffer0;
        this.buttonZiffer7 = buttonZiffer7;
        this.buttonWeiterFunktionen = buttonWeiterFunktionen;
        this.buttonZiffer4 = buttonZiffer4;
        this.buttonZiffer1 = buttonZiffer1;
        this.buttonVorzeichen = buttonVorzeichen;
        buttonDEL = buttonDel;
        this.buttonC = buttonC;
        this.buttonPlus = buttonPlus;
        this.buttonGleich = buttonGleich;
        buttonCE = buttonCe;
        setTitle("Taschenrechner");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,300);
        setLocationRelativeTo(null);
        setVisible(true);


        this.buttonC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonDEL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonWeiterFunktionen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonKlammerAuf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonKlammerZu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonGeteilt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonZiffer7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonZiffer8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonZiffer9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonMal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonZiffer4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonZiffer5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonZiffer6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonZiffer1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonZiffer2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonZiffer3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonVorzeichen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonZiffer0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonKomma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonGleich.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        buttonCE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        buttonProzent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

}

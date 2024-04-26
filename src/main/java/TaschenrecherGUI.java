import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaschenrecherGUI extends JFrame{
    private JButton buttonMinus;
    private JButton buttonMal;
    private JButton buttonGeteilt;
    private JButton buttonWurzel;
    private JButton a9Button;
    private JButton a6Button;
    private JButton a3Button;
    private JButton buttonKomma;
    private JButton buttonQuadrat;
    private JButton a8Button;
    private JButton a5Button;
    private JButton a2Button;
    private JButton a0Button;
    private JButton a7Button;
    private JButton xTeiler;
    private JButton a4Button;
    private JButton a1Button;
    private JButton buttonVorzeichen;
    private JButton DELButton;
    private JButton CButton;
    private JButton buttonPlus;
    private JButton buttonGleich;
    private JButton CEButton;
    private JButton buttonProzent;

    public TaschenrecherGUI(JButton buttonMinus, JButton buttonMal, JButton buttonGeteilt, JButton buttonKlammerZu, JButton a9Button, JButton a6Button, JButton a3Button, JButton buttonKomma, JButton buttonKlammerAuf, JButton a8Button, JButton a5Button, JButton a2Button, JButton a0Button, JButton a7Button, JButton weitereFunktionenButton, JButton a4Button, JButton a1Button, JButton buttonVorzeichen, JButton delButton, JButton cButton, JButton buttonPlus, JButton buttonGleich, JButton ceButton){
        this.buttonMinus = buttonMinus;
        this.buttonMal = buttonMal;
        this.buttonGeteilt = buttonGeteilt;
        this.buttonWurzel = buttonKlammerZu;
        this.a9Button = a9Button;
        this.a6Button = a6Button;
        this.a3Button = a3Button;
        this.buttonKomma = buttonKomma;
        this.buttonQuadrat = buttonKlammerAuf;
        this.a8Button = a8Button;
        this.a5Button = a5Button;
        this.a2Button = a2Button;
        this.a0Button = a0Button;
        this.a7Button = a7Button;
        this.xTeiler = weitereFunktionenButton;
        this.a4Button = a4Button;
        this.a1Button = a1Button;
        this.buttonVorzeichen = buttonVorzeichen;
        DELButton = delButton;
        CButton = cButton;
        this.buttonPlus = buttonPlus;
        this.buttonGleich = buttonGleich;
        CEButton = ceButton;
        setTitle("Taschenrechner");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,300);
        setLocationRelativeTo(null);
        setVisible(true);


        CButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        DELButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        weitereFunktionenButton.addActionListener(new ActionListener() {
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
        a7Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        a8Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        a9Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonMal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        a4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        a5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        a6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        a2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        a3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonVorzeichen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        a0Button.addActionListener(new ActionListener() {
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

        CEButton.addActionListener(new ActionListener() {
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

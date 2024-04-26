import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaschenrecherGUI extends JFrame{
    private JButton buttonMinus;
    private JButton buttonMal;
    private JButton buttonGeteilt;
    private JButton buttonWurzel;
    private JButton Ziffer9Button;
    private JButton Ziffer6Button;
    private JButton Ziffer3Button;
    private JButton buttonKomma;
    private JButton buttonQuadrat;
    private JButton Ziffer8Button;
    private JButton Ziffer5Button;
    private JButton Ziffer2Button;
    private JButton Ziffer0Button;
    private JButton Ziffer7Button;
    private JButton xTeiler;
    private JButton Ziffer4Button;
    private JButton Ziffer1Button;
    private JButton buttonVorzeichen;
    private JButton DELButton;
    private JButton CButton;
    private JButton buttonPlus;
    private JButton buttonGleich;
    private JButton CEButton;
    private JButton buttonProzent;

    public TaschenrecherGUI(JButton buttonMinus, JButton buttonMal, JButton buttonGeteilt, JButton buttonKlammerZu, JButton Ziffer9Button, JButton Ziffer6Button, JButton Ziffer3Button, JButton buttonKomma, JButton buttonKlammerAuf, JButton Ziffer8Button, JButton Ziffer5Button, JButton Ziffer2Button, JButton Ziffer0Button, JButton Ziffer7Button, JButton weitereFunktionenButton, JButton Ziffer4Button, JButton Ziffer1Button, JButton buttonVorzeichen, JButton delButton, JButton cButton, JButton buttonPlus, JButton buttonGleich, JButton ceButton){
        this.buttonMinus = buttonMinus;
        this.buttonMal = buttonMal;
        this.buttonGeteilt = buttonGeteilt;
        this.buttonWurzel = buttonKlammerZu;
        this.Ziffer9Button = Ziffer9Button;
        this.Ziffer6Button = Ziffer6Button;
        this.Ziffer3Button = Ziffer3Button;
        this.buttonKomma = buttonKomma;
        this.buttonQuadrat = buttonKlammerAuf;
        this.Ziffer8Button = Ziffer8Button;
        this.Ziffer5Button = Ziffer5Button;
        this.Ziffer2Button = Ziffer2Button;
        this.Ziffer0Button = Ziffer0Button;
        this.Ziffer7Button = Ziffer7Button;
        this.xTeiler = weitereFunktionenButton;
        this.Ziffer4Button = Ziffer4Button;
        this.Ziffer1Button = Ziffer1Button;
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
        Ziffer7Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        Ziffer8Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        Ziffer9Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonMal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        Ziffer4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        Ziffer5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        Ziffer6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        Ziffer1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        Ziffer2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        Ziffer3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonVorzeichen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        Ziffer0Button.addActionListener(new ActionListener() {
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

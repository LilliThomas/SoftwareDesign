package view;

import org.assertj.swing.fixture.FrameFixture;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static org.assertj.swing.assertions.Assertions.assertThat;

public class CalculatorViewTest {

    private static CalculatorView frame;
    private static FrameFixture window;
    @BeforeAll
    static void before(){
        frame = new CalculatorView();
        window = new FrameFixture(frame);
        window.show();
    }


    @AfterAll
    public static void tearDown() {
        window.cleanUp();
    }

    @Test
    void shouldDisplayCalculatorTitle() {

        assertThat(window.target().getTitle()).isEqualTo("Taschenrechner");
    }

    @Test
    void clickButtons(){
        window.button("btn1").click();
        window.button("btn2").click();
        window.button("btn3").click();
        window.button("btn4").click();
        window.button("btn5").click();
        window.button("btn6").click();
        window.button("btn7").click();
        window.button("btn8").click();
        window.button("btn9").click();
        window.button("btn0").click();
        window.button("btnPlus").click();
        window.button("btnMinus").click();
        window.button("btnMultiply").click();
        window.button("btnDiv").click();
        window.button("btnEqual").click();
        window.button("btnComma").click();
        window.button("btnSign").click();
        window.button("btnSqrt").click();
        window.button("btnHistory").click();
        window.button("btnClear").click();
        window.button("btnMoreFunctions").click();
        window.button("btnQuadrat").click();
        window.button("btnDel").click();
        window.button("btnSin").click();
        window.button("btnCos").click();
        window.button("btnTan").click();

    }
    @Test
    void shouldDisplayButtons() {
        window.button("btn1").requireVisible();
        window.button("btn2").requireVisible();
        window.button("btn3").requireVisible();
        window.button("btn4").requireVisible();
        window.button("btn5").requireVisible();
        window.button("btn6").requireVisible();
        window.button("btn7").requireVisible();
        window.button("btn8").requireVisible();
        window.button("btn9").requireVisible();
        window.button("btn0").requireVisible();
        window.button("btnPlus").requireVisible();
        window.button("btnMinus").requireVisible();
        window.button("btnMultiply").requireVisible();
        window.button("btnDiv").requireVisible();
        window.button("btnEqual").requireVisible();
        window.button("btnComma").requireVisible();
        window.button("btnSign").requireVisible();
        window.button("btnSqrt").requireVisible();
        window.button("btnHistory").requireVisible();
        window.button("btnClear").requireVisible();
        window.button("btnMoreFunctions").requireVisible();
        window.button("btnQuadrat").requireVisible();
        window.button("btnDel").requireVisible();
        window.button("btnSin").requireVisible();
        window.button("btnCos").requireVisible();
        window.button("btnTan").requireVisible();
    }
    @Test
    void shouldSetResultText() throws Exception {
        window.textBox("textAreaResult").setText("123");
        assertThat(window.textBox("textAreaResult").text()).isEqualTo("123");
    }

    @Test
    void shouldSetCalculationText() throws Exception {
        window.textBox("textAreaCalculation").setText("1+1");
        assertThat(window.textBox("textAreaCalculation").text()).isEqualTo("1+1");
    }


}

package view;

import controllers.CalculatorController;
import model.CalculatorModel;
import org.assertj.swing.annotation.GUITest;
import org.assertj.swing.core.matcher.JButtonMatcher;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.jupiter.api.*;

import static org.assertj.swing.assertions.Assertions.assertThat;

public class CalculatorViewTest {

    private static FrameFixture window;
    private static CalculatorModel model;
    private static CalculatorController controller;

    @BeforeEach
    void before() {

        CalculatorView view = GuiActionRunner.execute(CalculatorView::new);
        model = new CalculatorModel();
        controller = new CalculatorController(view, model);
        window = new FrameFixture(view);
        window.show();
    }

    @AfterEach
    public void tearDown() {
        window.cleanUp();
    }

    @Test
    void shouldDisplayCalculatorTitle() {
        assertThat(window.target().getTitle()).isEqualTo("Taschenrechner");
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
        window.button("btnClear").requireVisible();
        window.comboBox("btnMoreFunctions").requireVisible();
        window.button("btnQuadrat").requireVisible();
        window.button("btnDel").requireVisible();
    }

    @Test
    @GUITest
    void shouldDisplayNumberWhenButtonIsClicked() {
        window.button("btn1").click();
        window.textBox("textAreaResult").requireText("1");
        window.button("btn2").click();
        window.textBox("textAreaResult").requireText("12");
    }

    @Test
    @GUITest
    public void shouldPerformAdditionWhenPlusButtonIsClicked() throws Exception {
        window.button(JButtonMatcher.withText("1")).click();
        window.button(JButtonMatcher.withText("+")).click();
        window.button(JButtonMatcher.withText("2")).click();
        window.button(JButtonMatcher.withText("=")).click();
        window.textBox("textAreaResult").requireText("3.0");
        assertThat(window.textBox("textAreaResult").text()).isEqualTo("3.0");
    }

    @Test
    @GUITest
    public void shouldPerformSubtractionWhenMinusButtonIsClicked() throws Exception {
        window.button(JButtonMatcher.withText("5")).click();
        window.button(JButtonMatcher.withText("-")).click();
        window.button(JButtonMatcher.withText("3")).click();
        window.button(JButtonMatcher.withText("=")).click();
        window.textBox("textAreaResult").requireText("2.0");
    }

    @Test
    @GUITest
    public void shouldPerformMultiplicationWhenMultiplyButtonIsClicked() throws Exception {
        window.button(JButtonMatcher.withText("4")).click();
        window.button(JButtonMatcher.withText("*")).click();
        window.button(JButtonMatcher.withText("2")).click();
        window.button(JButtonMatcher.withText("=")).click();
        window.textBox("textAreaResult").requireText("8.0");
    }
    @Test
    @GUITest
    public void shouldPerformDivisionWhenDivideButtonIsClicked() throws Exception {
        window.button(JButtonMatcher.withText("8")).click();
        window.button("btnDiv").click();
        window.button(JButtonMatcher.withText("2")).click();
        window.button(JButtonMatcher.withText("=")).click();
        window.textBox("textAreaResult").requireText("4.0");
    }

//    @Test
//    @GUITest
//    public void shouldClearTextAreasWhenClearButtonIsClicked() {
//        window.textBox("textAreaCalculation").setText("123");
//        window.textBox("textAreaResult").setText("456");
//        window.button("btnClear").click();
//        window.textBox("textAreaCalculation").requireText("");
//        window.textBox("textAreaResult").requireText("0");
//    }
//
//    @Test
//    @GUITest
//    public void shouldDeleteLastCharacterWhenDelButtonIsClicked() {
//        window.textBox("textAreaResult").setText("123");
//        window.button("btnDel").click();
//        window.textBox("textAreaResult").requireText("12");
//    }

}

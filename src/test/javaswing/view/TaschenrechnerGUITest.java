package view;

import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.Robot;
import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.swing.*;

import static org.assertj.swing.assertions.Assertions.assertThat;

public class TaschenrechnerGUITest {
    private static TaschenrechnerGUI frame;
    private static FrameFixture window;
    private static Robot robot;
    @BeforeAll
    static void before(){
        frame = new TaschenrechnerGUI();
        FailOnThreadViolationRepaintManager.install();
        robot = BasicRobot.robotWithNewAwtHierarchy();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                window = new FrameFixture(robot, frame);
                window.show();
            }
        });
        }
//    @BeforeEach
//    public void setUp() {
//        FailOnThreadViolationRepaintManager.install();
//        robot = BasicRobot.robotWithNewAwtHierarchy();
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//
//                window = new FrameFixture(robot, frame);
//                window.show();
//            }
//        });
//    }

    @AfterEach
    public void tearDown() {
        robot.cleanUp();
    }

    @Test
    public void shouldDisplayCalculatorTitle() {
        assertThat(window.target().getTitle()).isEqualTo("Taschenrechner");
    }
}

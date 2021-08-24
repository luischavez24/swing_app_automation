package pe.ey.qa.samples;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import Interface.MainFrame;
import org.assertj.swing.core.GenericTypeMatcher;
import org.assertj.swing.core.matcher.JButtonMatcher;
import org.assertj.swing.core.matcher.JLabelMatcher;
import org.assertj.swing.core.matcher.JTextComponentMatcher;
import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JButtonFixture;
import org.assertj.swing.fixture.JLabelFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.swing.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private FrameFixture window;

    @BeforeClass
    public static void setUpOnce() {
        FailOnThreadViolationRepaintManager.install();
    }

    @Before
    public void setUp() {
        MainFrame frame = GuiActionRunner.execute(MainFrame::new);
        window = new FrameFixture(frame);
        window.show();
    }

    @Test
    public void shouldAnswerWithTrue() {
        JButtonFixture signUpButton = window.button(JButtonMatcher.withText("Sign Up Here"));

        signUpButton.click();

        JLabelFixture signUpTitle = window.label(JLabelMatcher.withText("Customer Sign Up"));

        assertNotNull(signUpTitle);
    }


    @After
    public void tearDown() {
        window.cleanUp();
    }
}

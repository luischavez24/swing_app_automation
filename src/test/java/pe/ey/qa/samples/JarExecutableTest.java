package pe.ey.qa.samples;

import net.sourceforge.marathon.javadriver.JavaDriver;
import net.sourceforge.marathon.javadriver.JavaProfile;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class JarExecutableTest {

    private WebDriver driver = new JavaDriver();

    @Before
    public void setUp() {
        JavaProfile profile = new JavaProfile(JavaProfile.LaunchMode.COMMAND_LINE);
        profile.setCommand("lib/run.bat");

        driver = new JavaDriver(profile);
    }

    @Test
    public void shouldOpenApp() {
        List<WebElement> textFields = driver.findElements(By.tagName("text-field"));

        WebElement usernameTextField = textFields.get(1);

        WebElement passwordTextField = textFields.get(0);

        usernameTextField.sendKeys("luis.chavez2");

        passwordTextField.sendKeys("password");

        WebElement signInButton = driver.findElement(By.tagName("button"));

        signInButton.click();
    }

    @After
    public void tearDown() {
        driver.close();
    }
}

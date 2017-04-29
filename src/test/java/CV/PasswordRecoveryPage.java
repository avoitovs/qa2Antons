package CV;

import com.google.common.util.concurrent.Uninterruptibles;
import core.DriverManager;
import core.NavigationManagerr;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by antons on 28/04/2017.
 */
public class PasswordRecoveryPage {

    public final String newPassword = "d673n923nnkFGJ";
    NavigationManagerr navigationManager = new NavigationManagerr();

    public void sendPasswordRecoveryEmail(String email) {
        navigationManager.waitFor(DriverManager.desktopDriver, By.id("email"));

        DriverManager.logger.info("Entering email: "+email);
        DriverManager.desktopDriver.findElement(By.id("email")).sendKeys(email);

        DriverManager.logger.info("Submitting...");
        navigationManager.click(DriverManager.desktopDriver,By.className("blue_submit"));
    }

    public void checkIfRecoveryWasSent() {
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        Assert.assertEquals("Parole ir veiksmīgi nosūtīta!", DriverManager.desktopDriver.findElementById("passwordmessage").getText());
        DriverManager.logger.info("Email with password recovery successfully sent!");
    }

    public void checkEmail (String email){

        if (DriverManager.desktopDriver.findElement(By.linkText(email)).isDisplayed());{
            DriverManager.logger.info("Email is correct! "+email);
        }
    }

    public void enterNewPassword (){
        DriverManager.logger.info("Entering new passwords: "+newPassword);

        List<WebElement> list = DriverManager.desktopDriver.findElements(By.cssSelector("input[type='password']"));
        list.get(0).sendKeys(newPassword);
        list.get(1).sendKeys(newPassword);
    }
}

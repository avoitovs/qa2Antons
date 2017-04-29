package CV;

import com.google.common.util.concurrent.Uninterruptibles;
import core.Driver;
import core.Navigation;
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
    Navigation navigationManager = new Navigation();

    public void sendPasswordRecoveryEmail(String email) {
        navigationManager.waitFor(Driver.desktopDriver, By.id("email"));

        Driver.logger.info("Entering email: "+email);
        Driver.desktopDriver.findElement(By.id("email")).sendKeys(email);

        Driver.logger.info("Submitting...");
        navigationManager.click(Driver.desktopDriver,By.className("blue_submit"));
    }

    public void checkIfRecoveryWasSent() {
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        Assert.assertEquals("Parole ir veiksmīgi nosūtīta!", Driver.desktopDriver.findElementById("passwordmessage").getText());
        Driver.logger.info("Email with password recovery successfully sent!");
    }

    public void checkEmail (String email){

        if (Driver.desktopDriver.findElement(By.linkText(email)).isDisplayed());{
            Driver.logger.info("Email is correct! "+email);
        }
    }

    public void enterNewPassword (){
        Driver.logger.info("Entering new passwords: "+newPassword);

        List<WebElement> list = Driver.desktopDriver.findElements(By.cssSelector("input[type='password']"));
        list.get(0).sendKeys(newPassword);
        list.get(1).sendKeys(newPassword);
    }
}

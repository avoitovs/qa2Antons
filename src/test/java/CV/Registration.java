package CV;

import core.Driver;
import org.openqa.selenium.By;

/**
 * Created by antons on 28/04/2017.
 */
public class Registration {


    public static final String firstName = "Vasja";
    public static final String lastName = "Pupkin";
    public static final String phoneNumber = "23459008";


    public void newUserRegistration(String email) {

        Driver.logger.info("Registration of the new user...");
        Driver.desktopDriver.findElementByLinkText("Reģistrēties").click();

        closePopUp();

        Driver.desktopDriver.findElementByLinkText("darba meklētājs").click();

        Driver.logger.info("Entering first name: "+firstName);
        Driver.desktopDriver.findElementById("first_name").sendKeys(firstName);

        Driver.logger.info("Entering last name: "+lastName);
        Driver.desktopDriver.findElementById("last_name").sendKeys(lastName);

        Driver.logger.info("Entering email: "+email);
        Driver.desktopDriver.findElementById("epost").sendKeys(email);

        Driver.logger.info("Entering phone number: "+phoneNumber);
        Driver.desktopDriver.findElementById("contact_tel").sendKeys(phoneNumber);

        Driver.logger.info("Creating new account...");
        Driver.desktopDriver.findElementByClassName("blue_submit").click();
    }

    protected void closePopUp() {

        Driver.logger.info("Closing Pop-up message...");
        if (Driver.desktopDriver.findElementById("centerbox").isDisplayed()){
            Driver.desktopDriver.findElementById("centerbox").findElement(By.className("close")).click();
        }
        Driver.logger.info("Pop-up message is closed");
    }

}

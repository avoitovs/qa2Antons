package CV;

import core.DriverManager;
import org.openqa.selenium.By;

/**
 * Created by antons on 28/04/2017.
 */
public class Registration {


    public static final String firstName = "Vasja";
    public static final String lastName = "Pupkin";
    public static final String phoneNumber = "23459008";


    public void newUserRegistration(String email) {

        DriverManager.logger.info("Registration of the new user...");
        DriverManager.desktopDriver.findElementByLinkText("Reģistrēties").click();

        closePopUp();

        DriverManager.desktopDriver.findElementByLinkText("darba meklētājs").click();
        DriverManager.logger.info("Entering first name: "+firstName);
        DriverManager.desktopDriver.findElementById("first_name").sendKeys(firstName);
        DriverManager.logger.info("Entering last name: "+lastName);
        DriverManager.desktopDriver.findElementById("last_name").sendKeys(lastName);
        DriverManager.logger.info("Entering email: "+email);
        DriverManager.desktopDriver.findElementById("epost").sendKeys(email);
        DriverManager.logger.info("Entering phone number: "+phoneNumber);
        DriverManager.desktopDriver.findElementById("contact_tel").sendKeys(phoneNumber);
        DriverManager.logger.info("Creating new account...");
        DriverManager.desktopDriver.findElementByClassName("blue_submit").click();
    }

    protected void closePopUp() {

        DriverManager.logger.info("Closing Pop-up message...");
        if (DriverManager.desktopDriver.findElementById("centerbox").isDisplayed()){
            DriverManager.desktopDriver.findElementById("centerbox").findElement(By.className("close")).click();
        }
        DriverManager.logger.info("Pop-up message is closed");
    }

}

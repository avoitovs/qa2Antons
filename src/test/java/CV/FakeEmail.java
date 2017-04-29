package CV;


import core.Driver;
import core.Navigation;
import org.openqa.selenium.By;


/**
 * This class intended to work with fake email util.
 */
public class FakeEmail {

    Driver driver = new Driver();
    Navigation navigationManager = new Navigation();

    public static final String baseURL = "https://temp-mail.org/en/";


    public String generateFakeEmail (){

        Driver.logger.info("Creating fake email...");
        driver.setUpFFMobile();
        navigationManager.goTo(Driver.mobileDriver,baseURL);
        String email = Driver.mobileDriver.findElement(By.id("mail")).getAttribute("value");
        Driver.logger.info("Your fake email is: "+email);

        return email;
    }

    public void openMessage (By emailSubject){

        Driver.logger.info("Waiting for incoming email...");
        navigationManager.longWaitFor(Driver.mobileDriver,emailSubject);
        Driver.logger.info("Opening new email...");
        navigationManager.click(Driver.mobileDriver,emailSubject);
    }

    public String getLinkFromEmail(By whatLink){

        Driver.logger.info("Getting link...");
        String link = Driver.mobileDriver.findElement(whatLink).getAttribute("href");
        navigationManager.goTo(Driver.mobileDriver,baseURL);

        return link;
    }

    public String getPassword (){
        Driver.logger.info("Getting password...");
        String password = Driver.mobileDriver.findElement(By.cssSelector(".pm-text > br")).getText();

        Driver.logger.info(" pass: "+password);

        return password;
    }

}

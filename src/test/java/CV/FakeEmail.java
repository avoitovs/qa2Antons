package CV;


import core.Driver;
import core.Navigation;
import org.openqa.selenium.By;


/**
 * This class intended to work with fake email util.
 */
public class FakeEmail {

   private Driver driver = new Driver();
   private Navigation navigationManager = new Navigation();

    private static final String baseURL = "https://temp-mail.org/en/";


    protected String generateFakeEmail (){

        Driver.logger.info("Creating fake email...");
        driver.setUpFFMobile();
        navigationManager.goTo(Driver.mobileDriver,baseURL);
        String email = Driver.mobileDriver.findElement(By.id("mail")).getAttribute("value");
        Driver.logger.info("Your fake email is: "+email);

        return email;
    }

    protected void openMessage (By emailSubject){

        Driver.logger.info("Waiting for incoming email...");
        navigationManager.longWaitFor(Driver.mobileDriver,emailSubject);
        Driver.logger.info("Opening new email...");
        navigationManager.click(Driver.mobileDriver,emailSubject);
    }

    protected String getLinkFromEmail(By whatLink){

        Driver.logger.info("Getting link...");
        String link = Driver.mobileDriver.findElement(whatLink).getAttribute("href");
        navigationManager.goTo(Driver.mobileDriver,baseURL);

        return link;
    }

    protected String getPassword (){
        Driver.logger.info("Getting password...");
        String password = Driver.mobileDriver.findElement(By.cssSelector(".pm-text > br")).getText();

        Driver.logger.info(" pass: "+password);

        return password;
    }

}

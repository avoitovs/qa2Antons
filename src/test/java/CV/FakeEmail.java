package CV;


import core.DriverManager;
import core.NavigationManagerr;
import org.openqa.selenium.By;


/**
 * This class intended to work with fake email util.
 */
public class FakeEmail {

    DriverManager driverManager = new DriverManager();
    NavigationManagerr navigationManager = new NavigationManagerr();

    public static final String baseURL = "https://temp-mail.org/en/";


    public String generateFakeEmail (){

        DriverManager.logger.info("Creating fake email...");
        driverManager.setUpFFMobile();
        navigationManager.goTo(DriverManager.mobileDriver,baseURL);
        String email = DriverManager.mobileDriver.findElement(By.id("mail")).getAttribute("value");
        DriverManager.logger.info("Your fake email is: "+email);

        return email;
    }

    public void openMessage (By emailSubject){

        DriverManager.logger.info("Waiting for incoming email...");
        navigationManager.longWaitFor(DriverManager.mobileDriver,emailSubject);
        DriverManager.logger.info("Opening new email...");
        navigationManager.click(DriverManager.mobileDriver,emailSubject);
    }

    public String getLinkFromEmail(By whatLink){

        DriverManager.logger.info("Getting link...");
        String link = DriverManager.mobileDriver.findElement(whatLink).getAttribute("href");
        navigationManager.goTo(DriverManager.mobileDriver,baseURL);

        return link;
    }

    public String getPassword (){
        DriverManager.logger.info("Getting password...");
        String password = DriverManager.mobileDriver.findElement(By.cssSelector(".pm-text > br")).getText();

        DriverManager.logger.info(" pass: "+password);

        return password;
    }

}

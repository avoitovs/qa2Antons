package SystemTesting.Pages;

import core.Driver;
import org.openqa.selenium.WebDriver;

/**
 * Created by avoitovs on 5/22/2017.
 */
public class BaseFunctions {

    public WebDriver driver;

    public BaseFunctions() {
        this.driver = Driver.desktopDriver;
    }

    public void openHomePage(){
        Driver.logger.info("Opening home page...");
        Driver.desktopDriver.get("http://qaguru.lv:8080/qa2/");
    }




}

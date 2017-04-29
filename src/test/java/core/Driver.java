package core;

import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.concurrent.TimeUnit;

/**
 * Created by antons on 13/04/2017.
 */
public class Driver {

    public static FirefoxDriver desktopDriver;
    public static WebDriver mobileDriver;
    public static final Logger logger = Logger.getLogger(Driver.class);

    // Creating desktop web driver
    public void setUpFFDesktop() {
        logger.info("Preparing FF desktop browser");
        System.setProperty("webdriver.gecko.driver", "/Users/antons/Downloads/WebDrivers/geckodriver");
        desktopDriver = new FirefoxDriver();
        desktopDriver.manage().window().maximize();
        desktopDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void tearDown(WebDriver driver) {
        logger.info("Closing browser");
        driver.quit();
    }

    // Creating mobile web driver
    public void setUpFFMobile (){
        logger.info("Preparing FF mobile browser");
        System.setProperty("webdriver.gecko.driver", "/Users/antons/Downloads/WebDrivers/geckodriver");
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("general.useragent.override", "iPhone");
        mobileDriver = new FirefoxDriver(firefoxProfile);
        mobileDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mobileDriver.manage().window().setSize(new Dimension(400,800));

    }

}

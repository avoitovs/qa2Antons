package Delfi.tests.managers;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.concurrent.TimeUnit;

/**
 * Created by antons on 13/04/2017.
 */
public class DriverManager {

    public static FirefoxDriver desktopDriver;
    public static WebDriver mobileDriver;

    public void setUpFFDesktop() {
        TestBase.logger.info("Preparing FF desktop browser");
        System.setProperty("webdriver.gecko.driver", "/Users/antons/Downloads/WebDrivers/geckodriver");
        desktopDriver = new FirefoxDriver();
        desktopDriver.manage().window().maximize();
        desktopDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void tearDown(WebDriver driver) {
        TestBase.logger.info("Closing browser");
        driver.quit();
    }

    public void setUpFFMobile (){
        TestBase.logger.info("Preparing FF mobile browser");
        System.setProperty("webdriver.gecko.driver", "/Users/antons/Downloads/WebDrivers/geckodriver");
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("general.useragent.override", "iPhone");
        mobileDriver = new FirefoxDriver(firefoxProfile);
        mobileDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mobileDriver.manage().window().setSize(new Dimension(400,800));

    }

}

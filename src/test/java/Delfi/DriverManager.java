package Delfi;

import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by antons on 13/04/2017.
 */
public class DriverManager {

    public static FirefoxDriver driver;

    public void setUp() {
        TestBase.logger.info("Preparing FF browser");
        System.setProperty("webdriver.gecko.driver", "/Users/antons/Downloads/WebDrivers/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void tearDown() {
        TestBase.logger.info("Closing browser");
        driver.quit();
    }
}

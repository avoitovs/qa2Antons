package Delfi;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by antons on 12/04/2017.
 */
public class TestBase {

    public static FirefoxDriver driver;
    public static final Logger logger = Logger.getLogger(DelfiTest.class);

    @Before
    public void setUp() {
        logger.info("Preparing FF browser");
        System.setProperty("webdriver.gecko.driver", "/Users/antons/Downloads/WebDrivers/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        logger.info("Closing browser");
        driver.quit();
    }




}

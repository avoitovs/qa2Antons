package SportsdirectHW;

import com.google.common.util.concurrent.Uninterruptibles;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Compare actual and expected amount of items (girls and unisex swimsuits) on sportsdirect.com
 */
public class SportsdirectHWTest {

    FirefoxDriver driver;

    private final String baseURL = "http://www.sportsdirect.com/swimming/ladies-swimwear/swimsuits";
    private final String unisexSwimsuitLocator = "//*['@id=filterlist']/div[2]/a/span";
    private final String girlsSwimsuitLocator = "//*['@id=filterlist']/div[3]/a/span";
    private final String unisexSwimsuitItemAmountLocator = "//*[@id=\"dnn_ctr29807864_ViewTemplate_ctl00_ctl07_lstFilters_productFilterList_0\"]/div[2]";
    private final String girlsSwimsuitItemAmountLocator = "//*[@id=\"dnn_ctr29807864_ViewTemplate_ctl00_ctl07_lstFilters_productFilterList_0\"]/div[3]";



    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "/Users/antons/Downloads/WebDrivers/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void amountOfSwimsuits() {

        driver.get(baseURL);
        Uninterruptibles.sleepUninterruptibly(5,TimeUnit.SECONDS);
        closePopUp();

        int expectedAmountOfItems = getExpectedNumberOfItems(unisexSwimsuitItemAmountLocator)+ getExpectedNumberOfItems(girlsSwimsuitItemAmountLocator);
        driver.findElement(By.xpath(unisexSwimsuitLocator)).click();
        driver.findElement(By.xpath(girlsSwimsuitLocator)).click();

        Uninterruptibles.sleepUninterruptibly(5,TimeUnit.SECONDS);

        int actualAmountOfItems = getActualAmountOfItems();

        Assert.assertTrue(actualAmountOfItems==expectedAmountOfItems);

    }

    public void closePopUp (){
        if (driver.findElementById("advertPopup").isDisplayed()) {
            driver.findElement(By.cssSelector(".advertPopup .close")).click();
        }
    }

    public int getExpectedNumberOfItems (String xPathlocator){
        int expectedAmountOfItems = Integer.valueOf(driver.findElement(By.xpath(xPathlocator))
                .getAttribute("data-productcount"));
        return expectedAmountOfItems;
    }

    public int getActualAmountOfItems (){
        List <WebElement> items =  driver.findElements(By.cssSelector("#navlist > li"));
        int actualAmountOfItems = items.size();
        return actualAmountOfItems;
    }


}


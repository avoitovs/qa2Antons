package firstTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Check if google opened exact request
 */
public class GoogleCheck {

    @Test
    public void googleRequestTest (){

        System.setProperty("webdriver.gecko.driver", "/Users/antons/Downloads/WebDrivers/geckodriver");
        final WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();
        driver.get("http://www.google.lv");

        WebElement searchBox = driver.findElement(By.id("lst-ib"));
        searchBox.sendKeys("Selenium");
        searchBox.submit();

        Boolean title = new WebDriverWait(driver,15).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                return driver.getTitle().contains("Selenium - Google meklēšana");
            }
        });

        Assert.assertTrue("Wrong page title",title);

        driver.quit();

    }


}

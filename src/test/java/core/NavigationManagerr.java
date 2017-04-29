package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by antons on 28/04/2017.
 */
public class NavigationManagerr {

    public void goTo (WebDriver driver, String url){

        driver.get(url);

    }

    public void click (WebDriver driver, By byWhat){

        driver.findElement(byWhat).click();
    }

    public void longWaitFor(WebDriver driver, By whatToWait){

        WebDriverWait waiter = (new WebDriverWait(driver,200));

        waiter.until(ExpectedConditions.presenceOfElementLocated(whatToWait));

    }

    public void waitFor(WebDriver driver, By whatToWait){

        WebDriverWait waiter = (new WebDriverWait(driver,10));

        waiter.until(ExpectedConditions.presenceOfElementLocated(whatToWait));

    }

}

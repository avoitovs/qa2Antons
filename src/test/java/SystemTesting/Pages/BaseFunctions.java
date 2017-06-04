package SystemTesting.Pages;

import core.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

/**
 * Created by avoitovs on 5/22/2017.
 */
public class BaseFunctions {


    public void openHomePage(){
        Driver.logger.info("Opening home page...");
        Driver.desktopDriver.get("http://qaguru.lv:8080/qa2/");
    }

    public Boolean isPageOpened(By locator){
        try{
            Driver.desktopDriver.findElement(locator).isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
        return true;
    }

    public boolean isVisible (By locator){
        try {
            Driver.desktopDriver.findElement(locator).isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
        return true;
    }




}

package SystemTesting.Pages;

import core.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public boolean ifForbiddenCharPersist(String text){
        Pattern digit = Pattern.compile("[0-9]");
        Pattern special = Pattern.compile("(?=.*[\\d~!@#$%^&*()_+{}\\[\\]?<>|])");

        Matcher hasDigit = digit.matcher(text);
        Matcher hasSpecial = special.matcher(text);

        return hasDigit.find() || hasSpecial.find();
    }




}

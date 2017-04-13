package Delfi;

import com.sun.tools.internal.xjc.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by antons on 13/04/2017.
 */
public class NavigationManager {
    private static String baseURL = "http://rus.delfi.lv";
    private static By commentCounter =  By.className("comment-count");
    private static By firstArticle = By.className("top2012-title");

    DriverManager driverManager = new DriverManager();


    public By getCommentCounter() {
        return commentCounter;
    }


    protected void clickOnFirstArticle(WebDriver driver) {
        TestBase.logger.info("Clicking on first link");
        driver.findElement(firstArticle).click();


    }

    protected void openCommentSection(WebDriver driver) {
        TestBase.logger.info("Opening comment section");
        driver.findElement(commentCounter).click();
    }

    protected void openHomePage(WebDriver driver) {
        TestBase.logger.info("Opening home page");
        driver.get(baseURL);
    }





}

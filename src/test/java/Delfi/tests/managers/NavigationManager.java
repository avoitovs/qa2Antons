package Delfi.tests.managers;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by antons on 13/04/2017.
 */
public class NavigationManager {


    private static String baseURL = "http://rus.delfi.lv";
    protected static By commentCounter =  By.className("comment-count");
    private static By firstArticle = By.className("top2012-title");


    public By getCommentCounter() {
        return commentCounter;
    }


    public void clickOnFirstArticle(WebDriver driver) {
        TestBase.logger.info("Clicking on first link");
        driver.findElement(firstArticle).click();

    }

    public void openCommentSection(WebDriver driver) {
        TestBase.logger.info("Opening comment section");
        driver.findElement(commentCounter).click();
    }

    public void openHomePage(WebDriver driver) {
        TestBase.logger.info("Opening home page");
        driver.get(baseURL);
    }

    public void openArticleByTitle (String title){
        TestBase.logger.info("Opening article with title: "+title);
        DriverManager.desktopDriver.findElementByPartialLinkText(title).click();
    }

    protected void openCommentsByUserType(WebDriver driver, By userType) {
        driver.findElement(userType).click();
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }

    public void openNextCommentPage(){
        DriverManager.desktopDriver.findElement(By.className("comments-pager-arrow-last")).click();
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
    }





}

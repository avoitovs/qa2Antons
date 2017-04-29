package Delfi.tests.managers;

import com.google.common.util.concurrent.Uninterruptibles;
import core.DriverManager;
import core.NavigationManagerr;
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
    NavigationManagerr navigationManagerr = new NavigationManagerr();


    public By getCommentCounter() {
        return commentCounter;
    }


    public void clickOnFirstArticle(WebDriver driver) {
        TestBase.logger.info("Clicking on first link");
        navigationManagerr.click(driver,firstArticle);
    }

    public void openCommentSection(WebDriver driver) {
        TestBase.logger.info("Opening comment section");
        navigationManagerr.click(driver,commentCounter);
    }

    public void openHomePage(WebDriver driver) {
        TestBase.logger.info("Opening home page");
        navigationManagerr.goTo(driver,baseURL);
    }

    public void openArticleByTitle (String title){
        TestBase.logger.info("Opening article with title: "+title);
        DriverManager.desktopDriver.findElementByPartialLinkText(title).click();
    }

    protected void openCommentsByUserType(WebDriver driver, By userType) {
        navigationManagerr.click(driver,userType);
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }

    public void openNextCommentPage(){
        navigationManagerr.click(DriverManager.desktopDriver,By.className("comments-pager-arrow-last"));
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
    }





}

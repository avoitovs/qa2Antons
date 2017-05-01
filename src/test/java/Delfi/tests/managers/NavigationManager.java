package Delfi.tests.managers;

import com.google.common.util.concurrent.Uninterruptibles;
import core.Driver;
import core.Navigation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by antons on 13/04/2017.
 */
public class NavigationManager {


    private static String baseURL = "http://rus.delfi.lv";
    private static By commentCounter =  By.className("comment-count");
    private static By firstArticle = By.className("top2012-title");
    Navigation navigation = new Navigation();


    public By getCommentCounter() {
        return commentCounter;
    }


    public void clickOnFirstArticle(WebDriver driver) {
        Driver.logger.info("Clicking on first link");
        navigation.click(driver,firstArticle);
    }

    public void openCommentSection(WebDriver driver) {
        Driver.logger.info("Opening comment section");
        navigation.click(driver,commentCounter);
    }

    public void openHomePage(WebDriver driver) {
        Driver.logger.info("Opening home page");
        navigation.goTo(driver,baseURL);
    }

    public void openArticleByTitle (String title){
        Driver.logger.info("Opening article with title: "+title);
        Driver.desktopDriver.findElementByPartialLinkText(title).click();

    }

    protected void openCommentsByUserType(WebDriver driver, By userType) {
        navigation.click(driver,userType);
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }

    public void openNextCommentPage(){
        navigation.click(Driver.desktopDriver,By.className("comments-pager-arrow-last"));
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
    }





}

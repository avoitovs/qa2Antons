package Delfi;

import org.openqa.selenium.By;

/**
 * Created by antons on 13/04/2017.
 */
public class NavigationManager {
    private final String baseURL = "http://rus.delfi.lv";
    private final By commentCounter =  By.className("comment-count");
    private final By firstArticle = By.className("top2012-title");

    DriverManager driverManager = new DriverManager();


    public By getCommentCounter() {
        return commentCounter;
    }


    protected void clickOnFirstArticle() {
        TestBase.logger.info("Clicking on first link");
        driverManager.driver.findElement(firstArticle).click();

    }

    protected void openCommentSection() {
        TestBase.logger.info("Opening comment section");
        driverManager.driver.findElement(commentCounter).click();
    }

    protected void openHomePage() {
        TestBase.logger.info("Opening home page");
        driverManager.driver.get(baseURL);
    }



}

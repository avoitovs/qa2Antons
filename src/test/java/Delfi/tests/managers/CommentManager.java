package Delfi.tests.managers;


import com.google.common.util.concurrent.Uninterruptibles;
import core.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by antons on 14/04/2017.
 */

public class CommentManager {

    NavigationManager navigationManager = new NavigationManager();

    private final By registeredUserComments = By.xpath("//*[@id='comments-listing']/div[3]/a[1]/span");
    private final By anonymousUserComments = By.xpath("//*[@id='comments-listing']/div[3]/a[2]/span");


    public static final By desktopArticles = By.xpath("//h3[contains(@class, 'top2012-title')]");
    public static final By desktopTitle = By.className("top2012-title");
    public static final By desktopCommentCounter = By.className("comment-count");
    public static final By mobileArticles = By.className("md-mosaic-title");
    public static final By mobileTitles = By.className("md-scrollpos");
    public static final By mobileCommentCounter = By.className("commentCount");



    public Map getArticlesAndComments (WebDriver driver, By article, By title, By commentCounter) {

        Driver.logger.info("Getting page articles and it's comment count...");

        List<WebElement> articles = driver.findElements(article);

        Map<String, String> articlesAndComments = new HashMap<String, String>();

        for (int i = 0; i < 5; i++) {
            if (articles.get(i).findElements(commentCounter).isEmpty()) {
                articlesAndComments.put(articles.get(i).findElement(title).getText(), "0");
            } else {
                articlesAndComments.put(articles.get(i).findElement(title).getText(),
                        articles.get(i).findElement(commentCounter).getText());
            }
        }

        for (Map.Entry entry : articlesAndComments.entrySet()) {
            Driver.logger.info(entry.getKey() + ": " + entry.getValue());
        }

        return articlesAndComments;
    }


    // Getting comments number from article page
    public int getArticlePageCommentsNumber(WebDriver driver) {
        Driver.logger.info("Getting amount of comments on article page");
        return getAmountOfComments(navigationManager.getCommentCounter(),driver);
    }

    // Getting comments number from main page
    public int getMainPageCommentsNumber(WebDriver driver) {
        Driver.logger.info("Get amount of comments under article on main page");
        return getAmountOfComments(navigationManager.getCommentCounter(),driver);
    }


    public int getTotalAmountOfCommentsFromCounter(WebDriver driver) {
        int registeredCommentsNumber = getRegisteredCommentsNumber(driver);
        int anonymousCommentsNumber = getAnonymousCommentsNumber(driver);

        Driver.logger.info("Getting total amount of comments");
        int totalAmountOfComments = anonymousCommentsNumber+registeredCommentsNumber;
        Driver.logger.info("Total amount of comments is:"+totalAmountOfComments);
        return totalAmountOfComments;
    }

    // Getting amount of anonymous comments from counter
    private int getAnonymousCommentsNumber(WebDriver driver) {
        Driver.logger.info("Getting amount of anonymous user comments");
        return getAmountOfComments(anonymousUserComments,driver);
    }

    // Getting amount of registered comments from counter
    private int getRegisteredCommentsNumber(WebDriver driver) {
        Driver.logger.info("Getting amount of registered user comments");
        return getAmountOfComments(registeredUserComments,driver);
    }

    // Get amount of comments from counter
    private int getAmountOfComments (By byWhat,WebDriver driver){
        WebElement pageComments = driver.findElement(byWhat);
        String commentsNumber = pageComments.getText();
        int pageCommentsNumber = Integer.parseInt(commentsNumber.substring(1,commentsNumber.length()-1));
        Driver.logger.info("Number of comments is: "+pageCommentsNumber);
        return pageCommentsNumber;
    }



    public int getTotalAmountOfRealComments(WebDriver driver){

        int anonymousComments = getAmountOfRealCommentsPerUserType(driver,anonymousUserComments);
        Driver.logger.info("Total amount of anonymous comments is: "+anonymousComments);
        int registeredComments = getAmountOfRealCommentsPerUserType(driver,registeredUserComments);
        Driver.logger.info("Total amount of registered comments is: "+registeredComments);

        int total = anonymousComments+registeredComments;
        Driver.logger.info("Total amount of comments is: "+total);
        return total;

    }

    // Getting comment count by counting individual messages from all pages of one user type
    private int getAmountOfRealCommentsPerUserType (WebDriver driver, By userType){

        if (userType == anonymousUserComments){
            Driver.logger.info("Getting amount of comments by anonymous users");
        }else {
            Driver.logger.info("Getting amount of comments by registered users");
        }

        navigationManager.openCommentsByUserType(driver, userType);
        int commentsPageNumber = getCommentsPageAmount(driver);
        int commentCount = getAmountOfRealCommentsPerPage(driver);

        if (commentsPageNumber>0){
            for (int i = 0; i<commentsPageNumber-1;i++){
                Driver.logger.info("Opening next comment page");
                navigationManager.openNextCommentPage();
                commentCount = commentCount+ getAmountOfRealCommentsPerPage(driver);
            }
        }
        return commentCount;
    }

    // Getting comment count by counting individual messages from ONE page
    private int getAmountOfRealCommentsPerPage(WebDriver driver){

        openHiddenComments(driver);


        List<WebElement> commentAmount = driver.findElements(By.className("comment-date"));
        int commentAmountNumber = commentAmount.size();
        Driver.logger.info("The amount is: "+commentAmountNumber);

        return commentAmountNumber;
    }

    // Opening hidden comments (threads)
    private void openHiddenComments (WebDriver driver){

        List<WebElement> listOfHiddenComments = Driver.desktopDriver.findElements(By.className("load-more-comments-btn-link"));

        if (listOfHiddenComments.size() == 0){
            Driver.logger.info("No threads found!");
        }else{
        Driver.logger.info("Found "+listOfHiddenComments.size()+" threads.");
        }

        for (WebElement thread : listOfHiddenComments){

            while(thread.isDisplayed()){
                Driver.logger.info("Opening thread");
                thread.click();
                Uninterruptibles.sleepUninterruptibly(2,TimeUnit.SECONDS);
            }

        }
    }


    // Getting amount of comments pages
    private int getCommentsPageAmount(WebDriver driver){

        List <WebElement> listOfCommentPages = driver.findElements(By.cssSelector(".comment-list-header .comments-pager-page"));

        int numberOfPages = 0;
        try {
            numberOfPages = Integer.parseInt(listOfCommentPages.get(listOfCommentPages.size() - 1).getText());
            Driver.logger.info("There are " + numberOfPages + " pages of comments");
        } catch (ArrayIndexOutOfBoundsException e){
            Driver.logger.info("Only one page of comments");
        }
        return numberOfPages;
    }



}
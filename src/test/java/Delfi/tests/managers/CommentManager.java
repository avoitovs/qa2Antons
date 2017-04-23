package Delfi.tests.managers;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by antons on 14/04/2017.
 */

public class CommentManager {

    NavigationManager navigationManager = new NavigationManager();


    private static By firstArticleCommentDesktop = By.xpath("//*[@id='column1-top']/div[2]/div[1]/div[1]/h3/a[2]");
    private static By secondArticleCommentDesktop = By.xpath("//*[@id='column1-top']/div[2]/div[1]/div[2]/h3/a[2]");
    private static By thirdArticleCommentDesktop = By.xpath("//*[@id='column1-top']/div[2]/div[2]/div[1]/h3/a[2]");
    private static By fourthArticleCommentDesktop = By.xpath("//*[@id='column1-top']/div[2]/div[2]/div[2]/h3/a[2]");
    private static By fifthArticleCommentDesktop = By.xpath("//*[@id='column1-top']/div[2]/div[2]/div[3]/h3/a[2]");


    private static By firstArticleCommentMobile = By.xpath("//*[@id='wrapper']/div[2]/div/div[2]/div/a[2]");
    private static By secondArticleCommentMobile = By.xpath("//*[@id='wrapper']/div[2]/div/div[3]/div/a[2]");
    private static By thirdArticleCommentMobile = By.xpath("//*[@id='wrapper']/div[2]/div/div[4]/div/a[2]");
    private static By fourthArticleCommentMobile =By.xpath("//*[@id='wrapper']/div[2]/div/div[6]/div/a[2]");
    private static By fifthArticleCommentMobile = By.xpath("//*[@id='wrapper']/div[2]/div/div[7]/div/a[2]");


    private final By registeredUserComments = By.xpath("//*[@id='comments-listing']/div[3]/a[1]/span");
    private final By anonymousUserComments = By.xpath("//*[@id='comments-listing']/div[3]/a[2]/span");


    // Creating array of first five articles selectors for desktop version
    public static By[] getDesktopCommentSelectors(){
        TestBase.logger.info("Saving first five comments for Desktop version");
        By [] desktopCommentSelectors = new By[5];
        desktopCommentSelectors[0]= firstArticleCommentDesktop;
        desktopCommentSelectors[1]=secondArticleCommentDesktop;
        desktopCommentSelectors[2]=thirdArticleCommentDesktop;
        desktopCommentSelectors[3]=fourthArticleCommentDesktop;
        desktopCommentSelectors[4]=fifthArticleCommentDesktop;
    return desktopCommentSelectors;
    }

    // Creating array of first five articles selectors for mobile version
    public static By[]  getMobileCommentSelectors(){
        TestBase.logger.info("Saving first five comments for Mobile version");
        By [] mobileCommentSelectors = new By[5];
        mobileCommentSelectors[0]= firstArticleCommentMobile;
        mobileCommentSelectors[1]=secondArticleCommentMobile;
        mobileCommentSelectors[2]=thirdArticleCommentMobile;
        mobileCommentSelectors[3]=fourthArticleCommentMobile;
        mobileCommentSelectors[4]=fifthArticleCommentMobile;
        return mobileCommentSelectors;
    }

    // Creating array of first five articles comments number
    public int[] getArrayOfComments(By [] commentSelector, WebDriver driver) {
        TestBase.logger.info("Getting array with comments on desktop version");

        TestBase.logger.info("Saving first five articles comment count Desktop version:");
        int firstArticleComments = getAmountOfComments(commentSelector[0], driver);
        int secondArticleComments = getAmountOfComments(commentSelector[1], driver);
        int thirdArticleComments = getAmountOfComments(commentSelector[2], driver);
        int fourthArticleComments = getAmountOfComments(commentSelector[3], driver);
        int fifthArticleComments = getAmountOfComments(commentSelector[4], driver);


        TestBase.logger.info("Creating array of comments amount");
        int[] arrayOfComments = new int[]
                {firstArticleComments,
                secondArticleComments,
                thirdArticleComments,
                fourthArticleComments,
                fifthArticleComments};

        return arrayOfComments;
    }


    // Getting comments number from article page
    public int getArticlePageCommentsNumber(WebDriver driver) {
        TestBase.logger.info("Getting amount of comments on article page");
        return getAmountOfComments(navigationManager.getCommentCounter(),driver);
    }

    // Getting comments number from main page
    public int getMainPageCommentsNumber(WebDriver driver) {
        TestBase.logger.info("Get amount of comments under article on main page");
        return getAmountOfComments(navigationManager.getCommentCounter(),driver);
    }


    public int getTotalAmountOfCommentsFromCounter(WebDriver driver) {
        int registeredCommentsNumber = getRegisteredCommentsNumber(driver);
        int anonymousCommentsNumber = getAnonymousCommentsNumber(driver);

        TestBase.logger.info("Getting total amount of comments");
        int totalAmountOfComments = anonymousCommentsNumber+registeredCommentsNumber;
        TestBase.logger.info("Total amount of comments is:"+totalAmountOfComments);
        return totalAmountOfComments;
    }

    // Getting amount of anonymous comments from counter
    private int getAnonymousCommentsNumber(WebDriver driver) {
        TestBase.logger.info("Getting amount of anonymous user comments");
        return getAmountOfComments(anonymousUserComments,driver);
    }

    // Getting amount of registered comments from counter
    private int getRegisteredCommentsNumber(WebDriver driver) {
        TestBase.logger.info("Getting amount of registered user comments");
        return getAmountOfComments(registeredUserComments,driver);
    }

    // Get amount of comments from counter
    public int getAmountOfComments (By byWhat,WebDriver driver){
        WebElement pageComments = driver.findElement(byWhat);
        String commentsNumber = pageComments.getText();
        int pageCommentsNumber = Integer.parseInt(commentsNumber.substring(1,commentsNumber.length()-1));
        TestBase.logger.info("Number of comments is: "+pageCommentsNumber);
        return pageCommentsNumber;
    }



    public int getTotalAmountOfRealComments(WebDriver driver){

        int anonymousComments = getAmountOfRealCommentsPerUserType(driver,anonymousUserComments);
        int registeredComments = getAmountOfRealCommentsPerUserType(driver,registeredUserComments);

        int total = anonymousComments+registeredComments;
        TestBase.logger.info("Total amount of comments is: "+total);
        return total;

    }

    // Getting comment count by counting individual messages from all pages of one user type
    public int getAmountOfRealCommentsPerUserType (WebDriver driver, By userType){

        if (userType == anonymousUserComments){
            TestBase.logger.info("Getting amount of comments by anonymous users");
        }else {
            TestBase.logger.info("Getting amount of comments by registered users");
        }

        navigationManager.openCommentsByUserType(driver, userType);
        int commentsPageNumber = getCommentsPageAmount(driver);
        int commentCount = getAmountOfRealCommentsPerPage(driver);

        if (commentsPageNumber>0){
            for (int i = 0; i<commentsPageNumber-1;i++){
                TestBase.logger.info("Opening next comment page");
                navigationManager.openNextCommentPage();
                commentCount = commentCount+ getAmountOfRealCommentsPerPage(driver);
            }
        }
        return commentCount;
    }

    // Getting comment count by counting individual messages from ONE page
    public int getAmountOfRealCommentsPerPage(WebDriver driver){

        openHiddenComments(driver);
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

        List<WebElement> commentAmount = driver.findElements(By.className("comment-date"));
        int commentAmountNumber = commentAmount.size();
        TestBase.logger.info("The amount is: "+commentAmountNumber);

        return commentAmountNumber;
    }

    // Opening hidden comments (threads)
    private void openHiddenComments (WebDriver driver){

        try{
            WebElement hiddenComments = driver.findElement(By.cssSelector(" .load-more-comments-btn-link"));
            while( hiddenComments.isDisplayed()){
                TestBase.logger.info("Found hidden comments. Opening...");
                hiddenComments.click();
                Uninterruptibles.sleepUninterruptibly(2,TimeUnit.SECONDS);
            }

        } catch (NoSuchElementException e) {
            TestBase.logger.info("No hidden comments!");
        }

    }

    // Getting amount of comments pages
    public int getCommentsPageAmount(WebDriver driver){

        List <WebElement> amountCommentOfPages = driver.findElements(By.className("comments-pager-page"));
        int amountOfCommentPages = amountCommentOfPages.size() / 2;

        if (amountOfCommentPages==0){
            TestBase.logger.info("Only one page of comments");
        } else {
            TestBase.logger.info("There are "+amountOfCommentPages+" pages of comments");
        }return amountOfCommentPages;
    }



}
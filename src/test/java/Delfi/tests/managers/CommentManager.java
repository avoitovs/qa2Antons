package Delfi.tests.managers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by antons on 14/04/2017.
 */

public class CommentManager {

    NavigationManager navigationManager = new NavigationManager();


    public static By firstArticleCommentDesktop = By.xpath("//*[@id='column1-top']/div[2]/div[1]/div[1]/h3/a[2]");
    public static By secondArticleCommentDesktop = By.xpath("//*[@id='column1-top']/div[2]/div[1]/div[2]/h3/a[2]");
    public static By thirdArticleCommentDesktop = By.xpath("//*[@id='column1-top']/div[2]/div[2]/div[1]/h3/a[2]");
    public static By fourthArticleCommentDesktop = By.xpath("//*[@id='column1-top']/div[2]/div[2]/div[2]/h3/a[2]");
    public static By fifthArticleCommentDesktop = By.xpath("//*[@id='column1-top']/div[2]/div[2]/div[3]/h3/a[2]");


    public static By firstArticleCommentMobile = By.xpath("//*[@id='wrapper']/div[2]/div/div[2]/div/a[2]");
    public static By secondArticleCommentMobile = By.xpath("//*[@id='wrapper']/div[2]/div/div[3]/div/a[2]");
    public static By thirdArticleCommentMobile = By.xpath("//*[@id='wrapper']/div[2]/div/div[4]/div/a[2]");
    public static By fourthArticleCommentMobile =By.xpath("//*[@id='wrapper']/div[2]/div/div[6]/div/a[2]");
    public static By fifthArticleCommentMobile = By.xpath("//*[@id='wrapper']/div[2]/div/div[7]/div/a[2]");


    private final By registeredUserComments = By.xpath("//*[@id='comments-listing']/div[3]/a[1]/span");
    private final By anonymousUserComments = By.xpath("//*[@id='comments-listing']/div[3]/a[2]/span");



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

    public static By[] getMobileCommentSelectors(){
        TestBase.logger.info("Saving first five comments for Mobile version");
        By [] mobileCommentSelectors = new By[5];
        mobileCommentSelectors[0]= firstArticleCommentMobile;
        mobileCommentSelectors[1]=secondArticleCommentMobile;
        mobileCommentSelectors[2]=thirdArticleCommentMobile;
        mobileCommentSelectors[3]=fourthArticleCommentMobile;
        mobileCommentSelectors[4]=fifthArticleCommentMobile;
        return mobileCommentSelectors;
    }

    public  int[] getArrayOfComments(By [] commentSelector, WebDriver driver) {
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


    public int getArticlePageCommentsNumber(WebDriver driver) {
        TestBase.logger.info("Getting amount of comments on article page");
        return getAmountOfComments(navigationManager.getCommentCounter(),driver);
    }

    public int getMainPageCommentsNumber(WebDriver driver) {
        TestBase.logger.info("Get amount of comments under article on main page");
        return getAmountOfComments(navigationManager.getCommentCounter(),driver);
    }

    public int getTotalAmountOfComments(WebDriver driver) {
        int registeredCommentsNumber = getRegisteredCommentsNumber(driver);
        int anonymousCommentsNumber = getAnonymousCommentsNumber(driver);

        TestBase.logger.info("Getting total amount of comments");
        int totalAmountOfComments = anonymousCommentsNumber+registeredCommentsNumber;
        TestBase.logger.info("Total amount of comments is:"+totalAmountOfComments);
        return totalAmountOfComments;
    }

    private int getAnonymousCommentsNumber(WebDriver driver) {
        TestBase.logger.info("Getting amount of anonymous user comments");
        return getAmountOfComments(anonymousUserComments,driver);
    }

    private int getRegisteredCommentsNumber(WebDriver driver) {
        TestBase.logger.info("Getting amount of registered user comments");
        return getAmountOfComments(registeredUserComments,driver);
    }

    public static int getAmountOfComments (By byWhat,WebDriver driver){
        WebElement pageComments = driver.findElement(byWhat);
        String commentsNumber = pageComments.getText();
        int pageCommentsNumber = Integer.parseInt(commentsNumber.substring(1,commentsNumber.length()-1));
        TestBase.logger.info("Number of comments is: "+pageCommentsNumber);
        return pageCommentsNumber;
    }



}
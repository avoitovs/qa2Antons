package Delfi;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


/**
 * Created by antons on 12/04/2017.
 */
public class TestBase {


    public static final Logger logger = Logger.getLogger(DelfiTest.class);
    NavigationManager navigationManager = new NavigationManager();
    DriverManager driverManager = new DriverManager();


    private final By registeredUserComments = By.xpath("//*[@id='comments-listing']/div[3]/a[1]/span");
    private final By anonymousUserComments = By.xpath("//*[@id='comments-listing']/div[3]/a[2]/span");


    protected int getArticlePageCommentsNumber() {
        logger.info("Getting amount of comments on article page");
        return getAmountOfComments(navigationManager.getCommentCounter());
    }

    protected int getMainPageCommentsNumber() {
        logger.info("Get amount of comments under article on main page");
        return getAmountOfComments(navigationManager.getCommentCounter());
    }

    protected int getTotalAmountOfComments() {
        int registeredCommentsNumber = getRegisteredCommentsNumber();
        int anonymousCommentsNumber = getAnonymousCommentsNumber();

        logger.info("Getting total amount of comments");
        int totalAmountOfComments = anonymousCommentsNumber+registeredCommentsNumber;
        logger.info("Total amount of comments is:"+totalAmountOfComments);
        return totalAmountOfComments;
    }

    private int getAnonymousCommentsNumber() {
        logger.info("Getting amount of anonymous user comments");
        return getAmountOfComments(anonymousUserComments);
    }

    private int getRegisteredCommentsNumber() {
        logger.info("Getting amount of registered user comments");
        return getAmountOfComments(registeredUserComments);
    }

    protected void commentAmountAssertion(int firstCommentNumber, int secondCommentNumber) {
        Assert.assertEquals( "Comment amount is not equal!", firstCommentNumber, secondCommentNumber, 0);
        logger.info("Comments number is correct!");
    }

    protected int getAmountOfComments (By byWhat){
        WebElement pageComments = driverManager.driver.findElement(byWhat);
        String commentsNumber = pageComments.getText();
        int pageCommentsNumber = Integer.parseInt(commentsNumber.substring(1,commentsNumber.length()-1));
        logger.info("Number of comments is: "+pageCommentsNumber);
        return pageCommentsNumber;
    }




}

package Delfi;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


/**
 * Testing amount of comments on first article comment on main page / article page / comment page for rus.delfi.lv website
 */
public class DelfiTest extends TestBase {

    private final String baseURL = "http://rus.delfi.lv";
    private static final By commentCounter =  By.className("comment-count");
    private static final By registeredUserComments = By.xpath("//*[@id='comments-listing']/div[3]/a[1]/span");
    private static final By anonymousUserComments = By.xpath("//*[@id='comments-listing']/div[3]/a[2]/span");


    @Test
    public void delfiCommentTest (){

        openHomePage();

        int mainPageCommentsNumber = getMainPageCommentsNumber();

        clickOnFirstArticle();

        int articlePageCommentsNumber = getArticlePageCommentsNumber();

        commentAmountAssertion(mainPageCommentsNumber,articlePageCommentsNumber);

        openCommentSection();

        int totalAmountOfComments = getTotalAmountOfComments();

        commentAmountAssertion(articlePageCommentsNumber,totalAmountOfComments);
    }

    protected int getArticlePageCommentsNumber() {
        logger.info("Getting amount of comments on article page");
        return getAmountOfComments(commentCounter);
    }

    protected void clickOnFirstArticle() {
        logger.info("Clicking on first link");
        driver.findElementByClassName("top2012-title").click();
    }

    protected int getMainPageCommentsNumber() {
        logger.info("Get amount of comments under article on main page");
        return getAmountOfComments(commentCounter);
    }

    protected void openCommentSection() {
        logger.info("Opening comment section");
        driver.findElement(commentCounter).click();
    }

    protected void openHomePage() {
        logger.info("Opening home page");
        driver.get(baseURL);
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
        WebElement pageComments = driver.findElement(byWhat);
        String commentsNumber = pageComments.getText();
        int pageCommentsNumber = Integer.parseInt(commentsNumber.substring(1,commentsNumber.length()-1));
        logger.info("Number of comments is: "+pageCommentsNumber);
        return pageCommentsNumber;
    }



}

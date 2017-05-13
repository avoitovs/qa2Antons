package DelfiPageObjects;

import com.google.common.util.concurrent.Uninterruptibles;
import core.Driver;
import core.Navigation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by antons on 13/05/2017.
 */
public class CommentsPage {

    Navigation navigation = new Navigation();

    private final By registeredUserComments = By.xpath("//*[@id='comments-listing']/div[3]/a[1]/span");
    private final By anonymousUserComments = By.xpath("//*[@id='comments-listing']/div[3]/a[2]/span");


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

        openCommentsByUserType(driver, userType);
        int commentsPageNumber = getCommentsPageAmount(driver);
        int commentCount = getAmountOfRealCommentsPerPage(driver);

        if (commentsPageNumber>0){
            for (int i = 0; i<commentsPageNumber-1;i++){
                Driver.logger.info("Opening next comment page");
                openNextCommentPage();
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
                Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
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

    protected void openCommentsByUserType(WebDriver driver, By userType) {
        navigation.click(driver,userType);
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }

    public void openNextCommentPage(){
        navigation.click(Driver.desktopDriver,By.className("comments-pager-arrow-last"));
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
    }
}

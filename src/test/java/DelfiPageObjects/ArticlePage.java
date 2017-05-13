package DelfiPageObjects;

import core.Driver;
import core.Navigation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by antons on 13/05/2017.
 */
public class ArticlePage {

    private static By commentCounter =  By.cssSelector(".article-title .comment-count");

    TestBase base = new TestBase();
    Navigation navigation = new Navigation();

    // Getting comments number from article page
    public int getArticlePageCommentsNumber(WebDriver driver) {
        Driver.logger.info("Getting amount of comments on article page");
        int amountOfComments = base.getAmountOfComments(commentCounter,driver);
        return amountOfComments;
    }

    public CommentsPage openCommentSection(WebDriver driver) {
        Driver.logger.info("Opening comment section");
        navigation.click(driver,commentCounter);
        return new CommentsPage();
    }

}

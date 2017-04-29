package Delfi.tests.managers;

import core.Driver;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

/**
 * Created by antons on 14/04/2017.
 */
public class AssertionManager {

    public void compareArticles(int firstCommentNumber, int secondCommentNumber) {
        Assert.assertEquals( "Comments amount are not equal!", firstCommentNumber, secondCommentNumber, 0);
        TestBase.logger.info("Comments amount is correct!");
    }

    public void compareArticles(Map desktopArticles, Map mobileArticles){
        Driver.logger.info("Comparing titles and comments count...");
        Assert.assertEquals("Titles or comments are not equals",desktopArticles,mobileArticles);
        Driver.logger.info("Titles and comments count are equal!");
    }




}

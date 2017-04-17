package Delfi.tests.managers;

import org.junit.Assert;

import java.util.List;

/**
 * Created by antons on 14/04/2017.
 */
public class AssertionManager {

    public void commentAmountAssertion(int firstCommentNumber, int secondCommentNumber) {
        Assert.assertEquals( "Comments amount are not equal!", firstCommentNumber, secondCommentNumber, 0);
        TestBase.logger.info("Comments amount is correct!");
    }

    public void commentAmountAssertion (int [] arrayOfCommentsDesktop, int [] arrayOfCommentsMobile){
        TestBase.logger.info("Comparing amount of comments between Desktop and Mobile version");
        Assert.assertArrayEquals("Comments number is incorrect! ",arrayOfCommentsDesktop,arrayOfCommentsMobile);
        TestBase.logger.info("Amount of comments is correct!");
    }
    public void titleAssertion (List listOfTitlesDesktop, List listOfTitlesMobile) {
        TestBase.logger.info("Comparing titles between Desktop and Mobile version");
        Assert.assertEquals(listOfTitlesDesktop, listOfTitlesMobile);
        TestBase.logger.info("Titles are the same!");
    }



}

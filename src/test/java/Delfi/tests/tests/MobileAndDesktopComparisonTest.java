package Delfi.tests.tests;

import Delfi.tests.managers.CommentManager;
import core.DriverManager;
import Delfi.tests.managers.TestBase;
import Delfi.tests.managers.TitleManager;
import org.junit.Test;

import java.util.List;

/**
 * This test is intended to compare desktop and mobile version of delfi.lv website by checking first five articles (titles and comment count)
 */
public class MobileAndDesktopComparisonTest extends TestBase {


    @Test
    public void desktopAndMobileComparisonTest() {

        driverManager.setUpFFDesktop();

        navigationManager.openHomePage(DriverManager.desktopDriver);

        List<String> listOfTitlesDesktop = titleManager.getListOfTitles(TitleManager.getDesktopTitleSelectors(),DriverManager.desktopDriver);

        int [] arrayOfCommentsDesktop = commentManager.getArrayOfComments(CommentManager.getDesktopCommentSelectors(),DriverManager.desktopDriver);

        driverManager.tearDown(DriverManager.desktopDriver);

        driverManager.setUpFFMobile();

        navigationManager.openHomePage(DriverManager.mobileDriver);

        List <String> listOfTitlesMobile = titleManager.getListOfTitles(TitleManager.getMobileTitleSelectors(),DriverManager.mobileDriver);

        int [] arrayOfCommentsMobile = commentManager.getArrayOfComments(CommentManager.getMobileCommentSelectors(),DriverManager.mobileDriver);

        assertionManager.commentAmountAssertion(arrayOfCommentsDesktop, arrayOfCommentsMobile);

        assertionManager.titleAssertion(listOfTitlesDesktop,listOfTitlesMobile);

        driverManager.tearDown(DriverManager.mobileDriver);



    }
}

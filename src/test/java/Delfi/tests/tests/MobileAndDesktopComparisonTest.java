package Delfi.tests.tests;

import Delfi.tests.managers.CommentManager;
import Delfi.tests.managers.DriverManager;
import Delfi.tests.managers.TestBase;
import Delfi.tests.managers.TitleManager;
import org.junit.Test;

import java.util.List;

/**
 * Created by antons on 15/04/2017.
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

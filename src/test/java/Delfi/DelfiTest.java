package Delfi;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

/**
 * Testing amount of comments on first article comment on main page / article page / comment page for rus.delfi.lv website
 */
public class DelfiTest extends TestBase {

    NavigationManager navigationManager = new NavigationManager();
    DriverManager driverManager = new DriverManager();
    TitleManager titleManager = new TitleManager();
    CommentManager commentManager= new CommentManager();
    AssertionManager assertionManager = new AssertionManager();


    @Test
    public void delfiCommentTest() {

        driverManager.setUpFFDesktop();

        navigationManager.openHomePage(DriverManager.desktopDriver);

        int mainPageCommentsNumber = getMainPageCommentsNumber(DriverManager.desktopDriver);

        navigationManager.clickOnFirstArticle(DriverManager.desktopDriver);

        int articlePageCommentsNumber = getArticlePageCommentsNumber(DriverManager.desktopDriver);

        assertionManager.commentAmountAssertion(mainPageCommentsNumber, articlePageCommentsNumber);

        navigationManager.openCommentSection(DriverManager.desktopDriver);

        int totalAmountOfComments = getTotalAmountOfComments(DriverManager.desktopDriver);

        assertionManager.commentAmountAssertion(articlePageCommentsNumber, totalAmountOfComments);

        driverManager.tearDown(DriverManager.desktopDriver);

    }

    @Test
    public void desktopAndMobileComparisonTest() {

        driverManager.setUpFFDesktop();

        navigationManager.openHomePage(DriverManager.desktopDriver);

        List <String> listOfTitlesDesktop = titleManager.getListOfTitles(TitleManager.getDesktopTitleSelectors(),DriverManager.desktopDriver);

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
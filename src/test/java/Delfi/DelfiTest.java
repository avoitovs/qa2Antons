package Delfi;

import org.junit.Test;

/**
 * Testing amount of comments on first article comment on main page / article page / comment page for rus.delfi.lv website
 */
public class DelfiTest extends TestBase {

    NavigationManager navigationManager = new NavigationManager();
    DriverManager driverManager = new DriverManager();


    @Test
    public void delfiCommentTest (){

        driverManager.setUpFFDesktop();

        navigationManager.openHomePage(DriverManager.desktopDriver);

        int mainPageCommentsNumber = getMainPageCommentsNumber(DriverManager.desktopDriver);

        navigationManager.clickOnFirstArticle(DriverManager.desktopDriver);

        int articlePageCommentsNumber = getArticlePageCommentsNumber(DriverManager.desktopDriver);

        commentAmountAssertion(mainPageCommentsNumber,articlePageCommentsNumber);

        navigationManager.openCommentSection(DriverManager.desktopDriver);

        int totalAmountOfComments = getTotalAmountOfComments(DriverManager.desktopDriver);

        commentAmountAssertion(articlePageCommentsNumber,totalAmountOfComments);

        driverManager.tearDown(DriverManager.desktopDriver);

    }

    @Test
    public void desktopAndMobileComparisonTest(){

        driverManager.setUpFFDesktop();

        navigationManager.openHomePage(DriverManager.desktopDriver);




    }








}

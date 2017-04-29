package Delfi.tests.tests;

import core.DriverManager;
import Delfi.tests.managers.TestBase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Testing amount of comments on first article comment on main page / article page / comment page for rus.delfi.lv website
 */
public class DelfiTest extends TestBase {

    @Before
    public void setup(){
        driverManager.setUpFFDesktop();
    }

    @After
    public void tearDown (){
        driverManager.tearDown(DriverManager.desktopDriver);
    }


    @Test
    public void delfiCommentTest() {

        navigationManager.openHomePage(DriverManager.desktopDriver);

        int mainPageCommentsNumber = commentManager.getMainPageCommentsNumber(DriverManager.desktopDriver);

        navigationManager.clickOnFirstArticle(DriverManager.desktopDriver);

        int articlePageCommentsNumber = commentManager.getArticlePageCommentsNumber(DriverManager.desktopDriver);

        assertionManager.commentAmountAssertion(mainPageCommentsNumber, articlePageCommentsNumber);

        navigationManager.openCommentSection(DriverManager.desktopDriver);

        int totalAmountOfComments = commentManager.getTotalAmountOfCommentsFromCounter(DriverManager.desktopDriver);

        assertionManager.commentAmountAssertion(articlePageCommentsNumber, totalAmountOfComments);

    }


}
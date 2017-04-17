package Delfi;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Testing amount of comments on first article comment on main page / article page / comment page for rus.delfi.lv website
 */
public class DelfiTest extends TestBase{

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

        driverManager.setUpFFDesktop();

        navigationManager.openHomePage(DriverManager.desktopDriver);

        int mainPageCommentsNumber = commentManager.getMainPageCommentsNumber(DriverManager.desktopDriver);

        navigationManager.clickOnFirstArticle(DriverManager.desktopDriver);

        int articlePageCommentsNumber = commentManager.getArticlePageCommentsNumber(DriverManager.desktopDriver);

        assertionManager.commentAmountAssertion(mainPageCommentsNumber, articlePageCommentsNumber);

        navigationManager.openCommentSection(DriverManager.desktopDriver);

        int totalAmountOfComments = commentManager.getTotalAmountOfComments(DriverManager.desktopDriver);

        assertionManager.commentAmountAssertion(articlePageCommentsNumber, totalAmountOfComments);

        driverManager.tearDown(DriverManager.desktopDriver);

    }


}
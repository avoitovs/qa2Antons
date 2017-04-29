package Delfi.tests.tests;

import core.Driver;
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
        driver.setUpFFDesktop();
    }

    @After
    public void tearDown (){
        driver.tearDown(Driver.desktopDriver);
    }


    @Test
    public void delfiCommentTest() {

        navigationManager.openHomePage(Driver.desktopDriver);

        int mainPageCommentsNumber = commentManager.getMainPageCommentsNumber(Driver.desktopDriver);

        navigationManager.clickOnFirstArticle(Driver.desktopDriver);

        int articlePageCommentsNumber = commentManager.getArticlePageCommentsNumber(Driver.desktopDriver);

        assertionManager.compareArticles(mainPageCommentsNumber, articlePageCommentsNumber);

        navigationManager.openCommentSection(Driver.desktopDriver);

        int totalAmountOfComments = commentManager.getTotalAmountOfCommentsFromCounter(Driver.desktopDriver);

        assertionManager.compareArticles(articlePageCommentsNumber, totalAmountOfComments);

    }


}
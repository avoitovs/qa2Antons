package Delfi;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Testing amount of comments on first article comment on main page / article page / comment page for rus.delfi.lv website
 */
public class DelfiTest extends TestBase {

    NavigationManager navigationManager = new NavigationManager();
    DriverManager driverManager = new DriverManager();

    @Before
    public void setup (){
        driverManager.setUp();
    }

    @After
    public void teardown(){
        driverManager.tearDown();
    }



    @Test
    public void delfiCommentTest (){

        navigationManager.openHomePage();

        int mainPageCommentsNumber = getMainPageCommentsNumber();

        navigationManager.clickOnFirstArticle();

        int articlePageCommentsNumber = getArticlePageCommentsNumber();

        commentAmountAssertion(mainPageCommentsNumber,articlePageCommentsNumber);

        navigationManager.openCommentSection();

        int totalAmountOfComments = getTotalAmountOfComments();

        commentAmountAssertion(articlePageCommentsNumber,totalAmountOfComments);

    }





}

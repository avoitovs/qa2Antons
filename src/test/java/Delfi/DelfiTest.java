package Delfi;

import org.junit.Test;

/**
 * Testing amount of comments on first article comment on main page / article page / comment page for rus.delfi.lv website
 */
public class DelfiTest extends TestBase {


    @Test
    public void delfiCommentTest (){

        openHomePage();

        int mainPageCommentsNumber = getMainPageCommentsNumber();

        clickOnFirstArticle();

        int articlePageCommentsNumber = getArticlePageCommentsNumber();

        commentAmountAssertion(mainPageCommentsNumber,articlePageCommentsNumber);

        openCommentSection();

        int totalAmountOfComments = getTotalAmountOfComments();

        commentAmountAssertion(articlePageCommentsNumber,totalAmountOfComments);
    }





}

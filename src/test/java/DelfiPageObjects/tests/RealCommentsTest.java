package DelfiPageObjects.tests;

import DelfiPageObjects.ArticlePage;
import DelfiPageObjects.CommentsPage;
import DelfiPageObjects.MainPage;
import core.Driver;
import core.Navigation;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by antons on 13/05/2017.
 */
public class RealCommentsTest {

    Driver driver = new Driver();
    Navigation navigationManager = new Navigation();


    private final String title = "Латвия отгородится от Беларуси 120-километровым забо";
    private final String BASE_URL = "http://rus.delfi.lv";



    @Before
    public void setup(){

        driver.setUpFFDesktop();

    }

    @After
    public void tearDown(){
        driver.tearDown(Driver.desktopDriver);
    }



    @Test
    public void realCommentsTest (){

        //Opening home page
        navigationManager.goTo(Driver.desktopDriver,BASE_URL);
        MainPage mainPage = new MainPage();

        // Opening provided article
        ArticlePage articlePage = mainPage.openArticleByTitle(title);

        // Getting amount of comments from article page
        int amountOfCommentsArticlePage = articlePage.getArticlePageCommentsNumber(Driver.desktopDriver);

        //Opening comments page
        CommentsPage commentsPage = articlePage.openCommentSection(Driver.desktopDriver);

        //Getting amount of real comments
        int totalRealComments = commentsPage.getTotalAmountOfRealComments(Driver.desktopDriver);

        //Comparing amount of comments from article page and real comments
        Assert.assertEquals("Amount of comments are not equal!",amountOfCommentsArticlePage,totalRealComments);
        Driver.logger.info("Test passed! Amount of comments are equal!");








    }



}

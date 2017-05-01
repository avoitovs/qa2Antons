package Delfi.tests.tests;

import core.Driver;
import Delfi.tests.managers.TestBase;
import com.google.common.util.concurrent.Uninterruptibles;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.util.concurrent.TimeUnit;

/**
 * This test is intended to check amount of real comments with comment counter in the article by tester's choice (Type name of the article).
 */
public class FindArticleAndCheckCommentsTest extends TestBase {

    @Before
    public void setup(){

        driver.setUpFFDesktop();

    }

    @After
    public void tearDown (){

        driver.tearDown(Driver.desktopDriver);

    }


    @Test
    public void articleTest (){

        navigationManager.openHomePage(Driver.desktopDriver);

       // Uninterruptibles.sleepUninterruptibly(5,TimeUnit.SECONDS);

        navigationManager.openArticleByTitle("На время велопраздника в Риге 1 мая ограничат движение");

        Uninterruptibles.sleepUninterruptibly(3,TimeUnit.SECONDS);

        int articleCommentsAmount = commentManager.getArticlePageCommentsNumber(Driver.desktopDriver);

        Uninterruptibles.sleepUninterruptibly(3,TimeUnit.SECONDS);

        navigationManager.openCommentSection(Driver.desktopDriver);

        Uninterruptibles.sleepUninterruptibly(3,TimeUnit.SECONDS);

        assertionManager.compareArticles(articleCommentsAmount,commentManager.getTotalAmountOfRealComments(Driver.desktopDriver));

    }


}

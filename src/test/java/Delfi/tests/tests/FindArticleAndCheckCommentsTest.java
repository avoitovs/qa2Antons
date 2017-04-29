package Delfi.tests.tests;

import core.DriverManager;
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

        driverManager.setUpFFDesktop();

    }

    @After
    public void tearDown (){

        driverManager.tearDown(DriverManager.desktopDriver);

    }


    @Test
    public void articleTest (){

        navigationManager.openHomePage(DriverManager.desktopDriver);

        Uninterruptibles.sleepUninterruptibly(5,TimeUnit.SECONDS);

        navigationManager.openArticleByTitle("В закопанной машине найдены останки бизнесмена, пропавшего 17 лет назад");

        Uninterruptibles.sleepUninterruptibly(3,TimeUnit.SECONDS);

        int articleCommentsAmount = commentManager.getArticlePageCommentsNumber(DriverManager.desktopDriver);

        Uninterruptibles.sleepUninterruptibly(3,TimeUnit.SECONDS);

        navigationManager.openCommentSection(DriverManager.desktopDriver);

        Uninterruptibles.sleepUninterruptibly(3,TimeUnit.SECONDS);

        assertionManager.commentAmountAssertion(articleCommentsAmount,commentManager.getTotalAmountOfRealComments(DriverManager.desktopDriver));

    }


}

package Delfi.tests.tests;

import Delfi.tests.managers.DriverManager;
import Delfi.tests.managers.TestBase;
import com.google.common.util.concurrent.Uninterruptibles;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by antons on 18/04/2017.
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

        navigationManager.openArticleByTitle("Собраны подписи за передачу земли под многоквартирными домами в ");

        Uninterruptibles.sleepUninterruptibly(3,TimeUnit.SECONDS);

        int articleCommentsAmount = commentManager.getArticlePageCommentsNumber(DriverManager.desktopDriver);

        Uninterruptibles.sleepUninterruptibly(3,TimeUnit.SECONDS);

        navigationManager.openCommentSection(DriverManager.desktopDriver);

        Uninterruptibles.sleepUninterruptibly(3,TimeUnit.SECONDS);

        assertionManager.commentAmountAssertion(articleCommentsAmount,commentManager.compareRealComments(DriverManager.desktopDriver));

    }


}

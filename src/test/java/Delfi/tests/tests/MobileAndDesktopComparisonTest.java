package Delfi.tests.tests;

import Delfi.tests.managers.CommentManager;
import core.Driver;
import Delfi.tests.managers.TestBase;
import org.junit.Test;
import java.util.Map;

/**
 * This test is intended to compare desktop and mobile version of delfi.lv website by checking first five articles (titles and comment count)
 */
public class MobileAndDesktopComparisonTest extends TestBase {



    @Test
    public void desktopAndMobileComparisonTest() {

        driver.setUpFFDesktop();

        navigationManager.openHomePage(Driver.desktopDriver);

        Map desktopArticles = commentManager.getArticlesAndComments(Driver.desktopDriver,
                                                                    CommentManager.desktopArticles,
                                                                    CommentManager.desktopTitle,
                                                                    CommentManager.desktopCommentCounter);


        driver.tearDown(Driver.desktopDriver);

        driver.setUpFFMobile();

        navigationManager.openHomePage(Driver.mobileDriver);

        Map mobileArticles = commentManager.getArticlesAndComments(Driver.mobileDriver,
                                                                    CommentManager.mobileArticles,
                                                                    CommentManager.mobileTitles,
                                                                    CommentManager.mobileCommentCounter);


        assertionManager.compareArticles(desktopArticles,mobileArticles);

        driver.tearDown(Driver.mobileDriver);



    }
}

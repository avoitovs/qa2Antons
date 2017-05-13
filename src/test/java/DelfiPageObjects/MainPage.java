package DelfiPageObjects;

import core.Driver;

/**
 * Created by antons on 13/05/2017.
 */
public class MainPage {




    public ArticlePage openArticleByTitle (String title){
        Driver.logger.info("Opening article with title: "+title);
        Driver.desktopDriver.findElementByPartialLinkText(title).click();

        return new ArticlePage();
    }
}

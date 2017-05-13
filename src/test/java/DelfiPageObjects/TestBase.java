package DelfiPageObjects;

import core.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by antons on 13/05/2017.
 */
public class TestBase {

    public int getAmountOfComments (By byWhat, WebDriver driver){

        WebElement pageComments = driver.findElement(byWhat);
        String commentsNumber = pageComments.getText();
        int pageCommentsNumber = Integer.parseInt(commentsNumber.substring(1,commentsNumber.length()-1));
        Driver.logger.info("Number of comments is: "+pageCommentsNumber);
        return pageCommentsNumber;
    }
}

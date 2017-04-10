package Delfi;

import com.google.common.util.concurrent.Uninterruptibles;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Testing amount of comments on first article comment on main page / article page / comment page for rus.delfi.lv website
 */
public class DelfiTest {

    FirefoxDriver driver;
    private final String baseURL = "http://www.rus.delfi.lv";
    private static final Logger LOGGER = Logger.getLogger(DelfiTest.class);
    private static final By COMMENTcounter =  By.className("comment-count");
    private static final By REGISTREDuserCOMMENTS = By.xpath("//*[@id='comments-listing']/div[3]/a[1]/span");
    private static final By ANONYMUSuserCOMMENTS = By.xpath("//*[@id='comments-listing']/div[3]/a[2]/span");

    @Before
    public void setUp() {
        LOGGER.info("Setting up Web driver");
        System.setProperty("webdriver.gecko.driver", "/Users/antons/Downloads/WebDrivers/geckodriver");
        LOGGER.info("Opening FF browser");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        LOGGER.info("Closing browser");
        driver.quit();
    }

    @Test
    public void delfiCommentTest (){

        LOGGER.info("Opening base URL");
        driver.get(baseURL);

        LOGGER.info("Get amount of comments under article on main page");
        int mainPageCommentsNumber = getAmountOfComments(COMMENTcounter);

        LOGGER.info("Clicking on first link");
        driver.findElementByClassName("top2012-big").click();

        Uninterruptibles.sleepUninterruptibly(5,TimeUnit.SECONDS);

        LOGGER.info("Getting amount of comments on article page");
        int articlePageCommentsNumber = getAmountOfComments(COMMENTcounter);

        Assert.assertEquals("Wrong comment number on main page and article page",mainPageCommentsNumber,articlePageCommentsNumber,0);
        LOGGER.info("Comments number on main page and article page is correct! ");

        LOGGER.info("Opening comment section");
        driver.findElement(COMMENTcounter).click();

        Uninterruptibles.sleepUninterruptibly(5,TimeUnit.SECONDS);

        LOGGER.info("Getting amount of registred user comments");
        int registredCommentsNumber = getAmountOfComments(REGISTREDuserCOMMENTS);
        LOGGER.info("Getting amount of anonymus user comments");
        int anonymusCommentsNumber = getAmountOfComments(ANONYMUSuserCOMMENTS);
        

        LOGGER.info("Getting total amount of comments");
        int totalAmountOfComments = anonymusCommentsNumber+registredCommentsNumber;
        LOGGER.info("Total amount of comments is:"+totalAmountOfComments);

        Assert.assertEquals("Wrong comments number ",totalAmountOfComments,articlePageCommentsNumber,0);
        LOGGER.info("Comments number is correct!");
    }

    private int getAmountOfComments (By byWhat){
        WebElement pageComments = driver.findElement(byWhat);
        String commentsNumber = pageComments.getText();
        int pageCommentsNumber = Integer.parseInt(commentsNumber.substring(1,commentsNumber.length()-1));
        LOGGER.info("Number of comments is: "+pageCommentsNumber);
        return pageCommentsNumber;
    }



}

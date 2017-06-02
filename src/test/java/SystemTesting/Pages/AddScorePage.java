package SystemTesting.Pages;

import core.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

/**
 * Created by avoitovs on 5/22/2017.
 */
public class AddScorePage extends BaseFunctions {

    private User user;
    private Score score;


    public AddScorePage(User user, Score score) {
        this.user=user;
        this.score = score;
        Assert.assertTrue("Add User page is not opened!", isPageOpened(addButtonLocator));
        fillAndSendScoreForm();
    }

    private By ageLocator = By.name("age");
    private By cityLocator = By.name("city");
    private By countryLocator = By.name("country");
    private By childCountLocator = By.name("childCount");
    private By addButtonLocator = By.xpath("//input[@value='Add Score']");

    private HomePage fillAndSendScoreForm(){
        Driver.logger.info("Filling score form for user: "+user.getName()+" "+user.getSurname());

        Driver.logger.info("Typing age: "+score.getAge());
        Driver.desktopDriver.findElement(ageLocator).sendKeys(String.valueOf(score.getAge()));
        Driver.logger.info("Typing city: "+score.getCity());
        Driver.desktopDriver.findElement(cityLocator).sendKeys(score.getCity());
        Driver.logger.info("Typing country: "+score.getCountry());
        Driver.desktopDriver.findElement(countryLocator).sendKeys(score.getCountry());
        Driver.logger.info("Typing child count: "+score.getChildCount());
        Driver.desktopDriver.findElement(childCountLocator).sendKeys(String.valueOf(score.getChildCount()));
        Driver.logger.info("Submitting...");
        Driver.desktopDriver.findElement(addButtonLocator).click();
        return new HomePage();
    }










}

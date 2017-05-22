package SystemTesting.Pages;

import core.Driver;
import org.openqa.selenium.By;

/**
 * Created by avoitovs on 5/22/2017.
 */
public class AddScorePage {

    private int id;

    public int getId() {
        return id;
    }

    public AddScorePage(int id) {
        this.id = id;
    }

    private By ageLocator = By.name("age");
    private By cityLocator = By.name("city");
    private By countryLocator = By.name("country");
    private By childCountLocator = By.name("childCount");
    private By addButtonLocator = By.xpath("//input[@value='Add Score']");

    public HomePage fillAndSendScoreForm(CharSequence age, CharSequence city, CharSequence country, CharSequence childCount){
        Driver.logger.info("Adding score for user number "+(id+1));

        Driver.logger.info("Typing age: "+age);
        Driver.desktopDriver.findElement(ageLocator).sendKeys(age);
        Driver.logger.info("Typing city: "+city);
        Driver.desktopDriver.findElement(cityLocator).sendKeys(city);
        Driver.logger.info("Typing country: "+country);
        Driver.desktopDriver.findElement(countryLocator).sendKeys(country);
        Driver.logger.info("Typing child count: "+childCount);
        Driver.desktopDriver.findElement(childCountLocator).sendKeys(childCount);
        Driver.logger.info("Submitting...");
        Driver.desktopDriver.findElement(addButtonLocator).click();
        return new HomePage();
    }










}

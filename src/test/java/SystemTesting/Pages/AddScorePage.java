package SystemTesting.Pages;

import core.Driver;
import org.openqa.selenium.By;

import javax.jws.soap.SOAPBinding;

/**
 * Created by avoitovs on 5/22/2017.
 */
public class AddScorePage {

    private User user;
    private String age;
    private String city;
    private String country;
    private String childCount;


    public AddScorePage(User user, String age, String city, String country, String childCount) {
        this.user=user;
        this.age = age;
        this.city=city;
        this.country=country;
        this.childCount = childCount;
        fillAndSendScoreForm();
    }

    private By ageLocator = By.name("age");
    private By cityLocator = By.name("city");
    private By countryLocator = By.name("country");
    private By childCountLocator = By.name("childCount");
    private By addButtonLocator = By.xpath("//input[@value='Add Score']");

    private HomePage fillAndSendScoreForm(){
        Driver.logger.info("Adding score for user "+user.getName()+" "+user.getSurname());

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

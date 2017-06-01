package SystemTesting.Pages;

import core.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;


/**
 * Created by avoitovs on 5/22/2017.
 */
public class AddUserPage extends BaseFunctions{

    private User user;

    public AddUserPage(User user) {
        this.user = user;
        Assert.assertTrue("Add User page is not opened!",isPageOpened(addButtonLocator));
        createNewUser();
    }


    private By nameLocator = By.name("name");
    private By surnameLocator = By.name("surname");
    private By phoneLocator = By.name("phone");
    private By emailLocator = By.name("email");
    private By genderLocator = By.name("gender");
    private By personIDLocator = By.name("personId");
    private By addButtonLocator = By.xpath("//input[@value='Add User']");
    private By someFieldsAreEmptyMessage = By.xpath("//*[contains(text(),'Some fields are empty')]");



    private void selectGender () {
        Select dropdown = new Select(Driver.desktopDriver.findElement(genderLocator));
        dropdown.selectByValue(user.getGender());
    }

    private HomePage createNewUser(){
        Driver.logger.info("Creating new user...");

        Driver.logger.info("Typing name: "+user.getName());
        Driver.desktopDriver.findElement(nameLocator).sendKeys(user.getName());

        Driver.logger.info("Typing surname: "+user.getSurname());
        Driver.desktopDriver.findElement(surnameLocator).sendKeys(user.getSurname());

        Driver.logger.info("Typing phone number: "+user.getPhone());
        Driver.desktopDriver.findElement(phoneLocator).sendKeys(user.getPhone());

        Driver.logger.info("Typing email: "+user.getEmail());
        Driver.desktopDriver.findElement(emailLocator).sendKeys(user.getEmail());

        Driver.logger.info("Selecting gender: "+user.getGender());
        selectGender();

        Driver.logger.info("Typing person ID: "+user.getPersonID());
        Driver.desktopDriver.findElement(personIDLocator).sendKeys(user.getPersonID());

        Driver.logger.info("Submitting...");
        Driver.desktopDriver.findElement(addButtonLocator).click();

        if (ifSomeFieldsAreEmpty(user)){
            Driver.logger.info("Error message appeared! Some fields are empty");
           // System.exit(-2); ?????????
            return null;
        }

        return new HomePage();
    }

    private Boolean ifSomeFieldsAreEmpty(User user){

        if (user.getName().equals("")||
            user.getSurname().equals("")||
            user.getPhone().equals("")||
            user.getEmail().equals("")||
            user.getPersonID().equals("")){

            Assert.assertTrue("Empty field error message is not displayed!",
                    Driver.desktopDriver.findElement(someFieldsAreEmptyMessage).isDisplayed());
            return true;
        }
        return false;
    }



}

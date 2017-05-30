package SystemTesting.Pages;

import core.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;


/**
 * Created by avoitovs on 5/22/2017.
 */
public class AddUserPage {

    public AddUserPage() {
        Assert.assertTrue("Add User page is not opened!",addUserPageIsOpened());
    }
    private Boolean addUserPageIsOpened(){
        try{
            Driver.desktopDriver.findElement(nameLocator).isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
        return true;
    }

    private By nameLocator = By.name("name");
    private By surnameLocator = By.name("surname");
    private By phoneLocator = By.name("phone");
    private By emailLocator = By.name("email");
    private By genderLocator = By.name("gender");
    private By personIDLocator = By.name("personId");
    private By addButtonLocator = By.xpath("//input[@value='Add User']");
    private By someFieldsAreEmptyMessage = By.xpath("//*[contains(text(),'Some fields are empty')]");



    private void selectGender (String gender) {
        Select dropdown = new Select(Driver.desktopDriver.findElement(genderLocator));
        dropdown.selectByValue(gender);
    }

    public HomePage fillAndSendUserForm(String name,
                                        String surname,
                                        String phone,
                                        String email,
                                        String personID,
                                        String gender){
        Driver.logger.info("Creating new user...");

        Driver.logger.info("Typing name: "+name);
        Driver.desktopDriver.findElement(nameLocator).sendKeys(name);

        Driver.logger.info("Typing surname: "+surname);
        Driver.desktopDriver.findElement(surnameLocator).sendKeys(surname);

        Driver.logger.info("Typing phone number: "+phone);
        Driver.desktopDriver.findElement(phoneLocator).sendKeys(phone);

        Driver.logger.info("Typing email: "+email);
        Driver.desktopDriver.findElement(emailLocator).sendKeys(email);

        Driver.logger.info("Selecting gender: "+gender);
        selectGender(gender);

        Driver.logger.info("Typing person ID: "+personID);
        Driver.desktopDriver.findElement(personIDLocator).sendKeys(personID);

        Driver.logger.info("Submitting...");
        Driver.desktopDriver.findElement(addButtonLocator).click();

        if (ifSomeFieldsAreEmpty(name, surname, phone, email, personID)){
            Driver.logger.info("Error message appeared! Some fields are empty");
            return null;
        }

        return new HomePage();
    }

    private Boolean ifSomeFieldsAreEmpty(String name,
                                      String surname,
                                      String phone,
                                      String email,
                                      String personID){

        if (name.equals("")|| surname.equals("")||phone.equals("")|| email.equals("")|personID.equals("")){

            Assert.assertTrue("Empty field error message is not displayed!",
                    Driver.desktopDriver.findElement(someFieldsAreEmptyMessage).isDisplayed());
            return true;
        }
        return false;
    }



}

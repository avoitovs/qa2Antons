package SystemTesting.Pages;

import core.Driver;
import org.openqa.selenium.By;


/**
 * Created by avoitovs on 5/22/2017.
 */
public class UserWrapper {

    private By name = By.className("name");
    private By surname = By.className("surname");
    private By phone = By.className("phone");
    private By email = By.className("email");
    private By gender = By.className("gender");
    private By personID = By.className("personId");
    private By score = By.className("score");

    public String getName(){
        String userName = Driver.desktopDriver.findElement(name).getText();
        return userName;
    }

    public String getSurname(){
        String userSurname = Driver.desktopDriver.findElement(surname).getText();
        return userSurname;
    }

    public String getPhone(){
        String userPhone = Driver.desktopDriver.findElement(phone).getText();
        return userPhone;
    }

    public String getEmail(){
        String userEmail = Driver.desktopDriver.findElement(email).getText();
        return userEmail;
    }

    public String getGender(){
        String userGender = Driver.desktopDriver.findElement(gender).getText();
        return userGender;
    }

    public String getPersonID(){
        String userID = Driver.desktopDriver.findElement(personID).getText();
        return userID;
    }

    public String getScore(){
        String userScore = Driver.desktopDriver.findElement(score).getText();
        return userScore;
    }


}

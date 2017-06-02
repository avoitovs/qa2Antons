package SystemTesting.Model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;


/**
 * Created by avoitovs on 5/22/2017.
 */
public class UserWrapper {

    private By nameLocator = By.className("name");
    private By surnameLocator = By.className("surname");
    private By phoneLocator = By.className("phone");
    private By emailLocator = By.className("email");
    private By genderLocator = By.className("gender");
    private By personIDLocator = By.className("personId");
    private By scoreLocator = By.className("score");

    public String getName(WebElement user){
        String userName = user.findElement(nameLocator).getText();
        return userName;
    }

    public String getSurname(WebElement user){
        String userSurname = user.findElement(surnameLocator).getText();
        return userSurname;
    }

    public String getPhone(WebElement user){
        String userPhone = user.findElement(phoneLocator).getText();
        return userPhone;
    }

    public String getEmail(WebElement user){
        String userEmail = user.findElement(emailLocator).getText();
        return userEmail;
    }

    public String getGender(WebElement user){
        String userGender = user.findElement(genderLocator).getText();
        return userGender;
    }

    public String getPersonID(WebElement user){
        String userID = user.findElement(personIDLocator).getText();
        return userID;
    }

    public BigDecimal getScore(WebElement user){
        String userScoreText = user.findElement(scoreLocator).getText();
        try {
            BigDecimal userScore = new BigDecimal(userScoreText);
            return userScore;
        }catch (NumberFormatException e){
            return null;
        }
    }


}

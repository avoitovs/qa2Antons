package SystemTesting.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;


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

    public String getName(WebElement user){
        String userName = user.findElement(name).getText();
        return userName;
    }

    public String getSurname(WebElement user){
        String userSurname = user.findElement(surname).getText();
        return userSurname;
    }

    public String getPhone(WebElement user){
        String userPhone = user.findElement(phone).getText();
        return userPhone;
    }

    public String getEmail(WebElement user){
        String userEmail = user.findElement(email).getText();
        return userEmail;
    }

    public String getGender(WebElement user){
        String userGender = user.findElement(gender).getText();
        return userGender;
    }

    public String getPersonID(WebElement user){
        String userID = user.findElement(personID).getText();
        return userID;
    }

    public BigDecimal getScore(WebElement user){
        String userScoreText = user.findElement(score).getText();
        try {
            BigDecimal userScore = new BigDecimal(userScoreText);
            return userScore;
        }catch (NumberFormatException e){
            return null;
        }
    }


}

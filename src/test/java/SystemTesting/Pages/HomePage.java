package SystemTesting.Pages;

import core.Driver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by avoitovs on 5/22/2017.
 */
public class HomePage {
    UserWrapper userWrapper = new UserWrapper();

    private By addScoreButton = By.className("score");
    private By addUserButton = By.className("addUserLink");
    private By user = By.className("userEntry");

    public AddScorePage addScore (){
        Driver.desktopDriver.findElement(addScoreButton).click();
        return new AddScorePage();
    }

    public AddUserPage addUser () {
        Driver.desktopDriver.findElement(addUserButton).click();
        return new AddUserPage();
    }

    public List<User> getListOfUsers (){
        List<WebElement> listOfUsers = Driver.desktopDriver.findElements(user);
        List<User> users = new ArrayList<User>();
        for (WebElement user : listOfUsers){
            users.add(new User(
                    userWrapper.getName(user),
                    userWrapper.getSurname(),
                    userWrapper.getPhone(),
                    userWrapper.getEmail(),
                    userWrapper.getGender(),
                    userWrapper.getPersonID(),
                    userWrapper.getScore()
            ));

        }

        return users;
    }


    @Test
    public void test(){

        Driver driver = new Driver();
        driver.setUpFFDesktop();
        Driver.desktopDriver.get("http://qaguru.lv:8080/qa2/");
        List<User> list = getListOfUsers();
        for (User user : list){
            System.out.println(user.getName());
        }

        driver.tearDown(Driver.desktopDriver);

    }




}



package SystemTesting.Pages;


import core.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by avoitovs on 5/22/2017.
 */
public class HomePage {

    List<User> listOfUsers;
    int amountOfRegisteredUsers;

    public HomePage() {
        this.listOfUsers = getListOfUsers();
        this.amountOfRegisteredUsers = listOfUsers.size();
        Assert.assertTrue("Home page is not opened!", homePageIsOpened());
    }

    private Boolean homePageIsOpened(){
        try{
            Driver.desktopDriver.findElement(By.className("userList")).isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
        return true;
    }


    UserWrapper userWrapper = new UserWrapper();

    private By addScoreButton = By.className("score");
    private By addUserButton = By.className("addUserLink");
    private By user = By.className("userEntry");

    public AddScorePage addScoreForTheUser (int id){
        if (listOfUsers.get(id).getScore()!=null){
            Driver.logger.info("User already has score!");
            return null;
        } else {
            List<WebElement> list = Driver.desktopDriver.findElements(user);
            Driver.logger.info("Opening score page for "+ (id+1) +" user");
            list.get(id).findElement(addScoreButton).click();
            return new AddScorePage(id);
        }

    }

    public AddUserPage addUser () {
        Driver.logger.info("Opening new user registration form...");
        Driver.desktopDriver.findElement(addUserButton).click();
        return new AddUserPage();
    }

    public List<User> getListOfUsers (){
        List<WebElement> listOfUsers = Driver.desktopDriver.findElements(user);
        List<User> users = new ArrayList<User>();
        for (WebElement user : listOfUsers){
            users.add(new User(
                    userWrapper.getName(user),
                    userWrapper.getSurname(user),
                    userWrapper.getPhone(user),
                    userWrapper.getEmail(user),
                    userWrapper.getGender(user),
                    userWrapper.getPersonID(user),
                    userWrapper.getScore(user)
            ));
        }
        return users;
    }






}



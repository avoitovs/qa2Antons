package SystemTesting.Pages;


import core.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


/**
 * Created by avoitovs on 5/22/2017.
 */
public class HomePage {

    private List<User> listOfUsers;
    //int amountOfRegisteredUsers;

    public HomePage() {
        this.listOfUsers = getListOfUsers();
       // this.amountOfRegisteredUsers = listOfUsers.size();
        Assert.assertTrue("Home page is not opened!", homePageIsOpened());
        Driver.logger.info("Home page is opened!");
    }

    private Boolean homePageIsOpened(){
        try{
            Driver.desktopDriver.findElement(By.className("userList")).isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
        return true;
    }


    private UserWrapper userWrapper = new UserWrapper();

    private By addScoreButton = By.className("score");
    private By addUserButton = By.linkText("Add User");
    private By userLocator = By.className("userEntry");

    public AddScorePage addScoreForTheUser (User user, String age, String city, String country, String childCount){
        Driver.logger.info("Adding score for the user: "+user.getName()+" "+user.getSurname());
        if (user.getScore()!=null){
            Driver.logger.info("User already has score!");
            return null;
        } else {
            List<WebElement> list = Driver.desktopDriver.findElements(userLocator);
            Driver.logger.info("Opening score page for user : "+user.getName()+" "+user.getSurname());
            this.listOfUsers = getListOfUsers();
            list.get(listOfUsers.indexOf(getExistingUser(user))+1).findElement(addScoreButton).click();
            return new AddScorePage(user,age,city,country,childCount);
        }

    }

    public AddUserPage createNewUser(User user) {
        Driver.logger.info("Opening new user registration form...");
        Driver.desktopDriver.findElement(addUserButton).click();
        return new AddUserPage(user);
    }

    public List<User> getListOfUsers (){
        List<WebElement> listOfUsers = Driver.desktopDriver.findElements(userLocator);
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
/*
    public User getExistingUser(String name, String surname, String phone, String email, String personID){
        Predicate<User> predicateName = u -> u.getName().equals(name);
        Predicate<User> predicateSurname = u -> u.getSurname().equals(surname);
        Predicate<User> predicatePhone = u -> u.getPhone().equals(phone);
        Predicate<User> predicateEmail = u -> u.getEmail().equals(email);
        Predicate<User> predicatePersonID = u -> u.getPersonID().equals(personID);
        User object = listOfUsers.stream()
                .filter(predicateName)
                .filter(predicateSurname)
                .filter(predicatePhone)
                .filter(predicateEmail)
                .filter(predicatePersonID)
                .findFirst().get();
        return object;
    }
*/
    public User getExistingUser(User user){
        //this.listOfUsers = getListOfUsers();
        Predicate<User> predicateName = u -> u.getName().equals(user.getName());
        Predicate<User> predicateSurname = u -> u.getSurname().equals(user.getSurname());
        Predicate<User> predicatePhone = u -> u.getPhone().equals(user.getPhone());
        Predicate<User> predicateEmail = u -> u.getEmail().equals(user.getEmail());
        Predicate<User> predicatePersonID = u -> u.getPersonID().equals(user.getPersonID());
        Predicate<User> predicateGender = u -> u.getGender().equals(user.getGender());
        User object = listOfUsers.stream()
                .filter(predicateName)
                .filter(predicateSurname)
                .filter(predicatePhone)
                .filter(predicateEmail)
                .filter(predicatePersonID)
                .filter(predicateGender)
                .findFirst().get();
        return object;
    }









}



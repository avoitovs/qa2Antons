package SystemTesting.Pages;


import SystemTesting.Model.Score;
import SystemTesting.Model.User;
import SystemTesting.Model.UserWrapper;
import core.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/**
 * Created by avoitovs on 5/22/2017.
 */
public class HomePage {

    private List<User> listOfUsers;

    public HomePage() {
        this.listOfUsers = getListOfUsersFromWeb();
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


    private By addScoreButton = By.className("score");
    private By addUserButton = By.linkText("Add User");
    private By userLocator = By.className("userEntry");

    public AddScorePage addScoreForTheUser (User user, Score score){
        Driver.logger.info("Adding score for the user: "+user.getName()+" "+user.getSurname());
        if (user.getScore()!=null){
            Driver.logger.info("User already has score!");
            return null;
        } else {
            List<WebElement> list = Driver.desktopDriver.findElements(userLocator);
            Driver.logger.info("Opening score page for user : "+user.getName()+" "+user.getSurname());
            list.get(listOfUsers.indexOf(user)).findElement(addScoreButton).click();
            return new AddScorePage(user,score);
        }

    }

    public AddUserPage createNewUser(User user) {
        Driver.logger.info("Opening new user registration form...");
        Driver.desktopDriver.findElement(addUserButton).click();
        return new AddUserPage(user);
    }

    public List<User> getListOfUsersFromWeb(){
        UserWrapper userWrapper = new UserWrapper();
        List<WebElement> listOfUsers = Driver.desktopDriver.findElements(userLocator);
        List<User> users = new ArrayList<>();
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

    public User getExistingUser(User user){
        this.listOfUsers = getListOfUsersFromWeb();
        Predicate<User> predicateName = u -> u.getName().equals(user.getName());
        Predicate<User> predicateSurname = u -> u.getSurname().equals(user.getSurname());
        Predicate<User> predicatePhone = u -> u.getPhone().equals(user.getPhone());
        Predicate<User> predicateEmail = u -> u.getEmail().equals(user.getEmail());
        Predicate<User> predicatePersonID = u -> u.getPersonId().equals(user.getPersonId());
        Predicate<User> predicateGender = u -> u.getGender().equals(user.getGender());
        User object = listOfUsers.stream()
                .filter(predicateName)
                .filter(predicateSurname)
                .filter(predicatePhone)
                .filter(predicateEmail)
                .filter(predicatePersonID)
                .filter(predicateGender)
                .findFirst().get();
        Driver.logger.info("User has been found in the list!");
        return object;
    }

    public List<User> getAmountOfUsersWithScore (){
        Driver.logger.info("Getting list of users with score...");
        Predicate<User> predicateScore = u -> u.getScore()!=null;
        List<User> objects = listOfUsers.stream()
                .filter(predicateScore)
                .collect(Collectors.toList());
        Driver.logger.info("Total amount of users with score is: "+objects.size());
        return objects;
    }

    public void checkForUserDuplicates(User user){
        Driver.logger.info("Checking system for duplicates of the user: "+user.getName()+" "+user.getSurname());
        Predicate<User> predicateName = u -> u.getName().equals(user.getName());
        Predicate<User> predicateSurname = u -> u.getSurname().equals(user.getSurname());
        Predicate<User> predicatePhone = u -> u.getPhone().equals(user.getPhone());
        Predicate<User> predicateEmail = u -> u.getEmail().equals(user.getEmail());
        Predicate<User> predicatePersonID = u -> u.getPersonId().equals(user.getPersonId());
        Predicate<User> predicateGender = u -> u.getGender().equals(user.getGender());
        List<User>  objects = listOfUsers.stream()
                .filter(predicateName)
                .filter(predicateSurname)
                .filter(predicatePhone)
                .filter(predicateEmail)
                .filter(predicatePersonID)
                .filter(predicateGender)
                .collect(Collectors.toList());
        Assert.assertFalse("Several users with same data has been found! ("+objects.size()+")",objects.size()>1);
        Driver.logger.info("Only one user with such data was found!");
    }









}



package SystemTesting;

import SystemTesting.API.GetListOfScoreVariablesUsingAPI;
import SystemTesting.API.GetListOfUsersUsingAPI;
import SystemTesting.Assertions.UserAssertion;
import SystemTesting.Model.Score;
import SystemTesting.Model.User;
import SystemTesting.Pages.*;
import SystemTesting.ScoreLogic.ExpectedScoreLogic;
import core.Driver;
import org.junit.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by avoitovs on 5/22/2017.
 */
public class def extends BaseFunctions {

    private Driver driver = new Driver();
    private UserAssertion userAssertion = new UserAssertion();

    //Data for new/tested user
    private String name = "TestNamefake";
    private String surname = "TestSurname";
    private String phone = "999999";
    private String email = "teslv@lsd.lv";
    private String gender = "male";
    private String personID = "16069410478";

    //User's score variables
    private String city = "Riga";
    private String country = "Latvia";
    private int age = 22;
    private int childCount = 2;
    private BigDecimal score = null;

    @Before
    public void setup() {

        driver.setUpFFDesktop();
        Driver.desktopDriver.get("http://qaguru.lv:8080/qa2/");
    }

    @After
    public void tearDown() {
        driver.tearDown(Driver.desktopDriver);
    }

    //test creates new user, sets him a score and checks if score is correct
    @Test
    public void scoreTest() {

        HomePage homePage = new HomePage();
        User virtualUser = new User(name,
                surname,
                phone,
                email,
                gender,
                personID,
                score);
        Score score = new Score(age, city, country, childCount);

        homePage.createNewUser(virtualUser);

        User realUser = homePage.getExistingUser(virtualUser);

        homePage.addScoreForTheUser(realUser, score);

        realUser = homePage.getExistingUser(realUser);

        ExpectedScoreLogic expectedScoreLogic = new ExpectedScoreLogic(score);

        Assert.assertEquals("Expected score does not match real", expectedScoreLogic.getExpectedTotalScore(), realUser.getScore());

    }

    //test intended to compare amount of users from UI and API
    @Test
    public void test2() throws IOException {
        HomePage homePage = new HomePage();
        GetListOfUsersUsingAPI userAPI = new GetListOfUsersUsingAPI();
        List<User> userAPIlist = userAPI.getListOfUsersAPI();
        Assert.assertEquals("Amount of users are not equals!", userAPIlist.size(), homePage.getListOfUsersFromWeb().size());
        Driver.logger.info("Amount of users are equal!");

    }

    @Test
    public void test3() throws IOException {

        GetListOfScoreVariablesUsingAPI scoreAPI = new GetListOfScoreVariablesUsingAPI();
        List<Score> scoreAPIList = scoreAPI.getListOfScoreVariablesAPI();
        System.out.println(scoreAPIList.get(5).getCity());
    }

    //test compares amount of users with score got from UI and API
    @Test
    public void test4() throws IOException {
        HomePage homePage = new HomePage();
        int size1 = homePage.getListOfUsersWithScore().size();

        GetListOfScoreVariablesUsingAPI scoreAPI = new GetListOfScoreVariablesUsingAPI();
        List<Score> scoreAPIList = scoreAPI.getListOfScoreVariablesAPI();

        Driver.logger.info("Comparing amount of users with score from WEB and API...");
        Assert.assertEquals("Amount of user's score are not equals!", size1, scoreAPIList.size());
        Driver.logger.info("Amount is correct!");
    }


    // test calculates expected score to all existing users who already has score and compares with real amount
    @Test
    public void test5() throws IOException {
        HomePage homePage = new HomePage();
         List<User> listOfUsersWithScore = homePage.getListOfUsersWithScore();
        List<BigDecimal> actualScoresForExistingUsers = new ArrayList<>();
         for (User temp : listOfUsersWithScore){
             actualScoresForExistingUsers.add(temp.getScore());
         }

        GetListOfScoreVariablesUsingAPI scoreAPI = new GetListOfScoreVariablesUsingAPI();
        List<Score> scoreVariablesAPIList = scoreAPI.getListOfScoreVariablesAPI();
        Driver.logger.info("Checking if existing users has correct score..");


        List<BigDecimal> expectedScoresForExistingUsers = new ArrayList<>();
        for (Score temp : scoreVariablesAPIList){
            expectedScoresForExistingUsers.add(new ExpectedScoreLogic(temp).getExpectedTotalScore());
        }

        Assert.assertEquals("Scores does not match!",expectedScoresForExistingUsers,actualScoresForExistingUsers);


    }


    //test asserts if user has duplicates in the system
    @Test
    public void test6(){
        HomePage homePage = new HomePage();
        User user = new User(name,
                surname,
                phone,
                email,
                gender,
                personID,
                score);
        homePage.checkForUserDuplicates(user);

    }


    //test compares user's information from WEB and API
    @Test
    public void test7()throws IOException {

        HomePage homePage = new HomePage();

        List<User> userListFromWeb = homePage.getListOfUsersFromWeb();
        GetListOfUsersUsingAPI userAPI = new GetListOfUsersUsingAPI();
        List<User> userListFromAPI = userAPI.getListOfUsersAPI();

        userAssertion.compareUsersFromAPIandWEB(userListFromAPI,userListFromWeb);

        Assert.assertEquals("Users doesn't match!",userListFromWeb,userListFromAPI);
        Driver.logger.info("User's info match between WEB and API!");

    }


    @Test
    public void test8(){
        User user = new User(name,
                surname,
                phone,
                email,
                gender,
                personID,
                score);

        UserAssertion userAssertion = new UserAssertion();

        userAssertion.validateUsersData(user);



    }




}

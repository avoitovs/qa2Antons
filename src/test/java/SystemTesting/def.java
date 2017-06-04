package SystemTesting;

import SystemTesting.API.GetListOfScoreVariablesUsingAPI;
import SystemTesting.API.GetListOfUsersUsingAPI;
import SystemTesting.Model.Score;
import SystemTesting.Model.User;
import SystemTesting.Pages.*;
import SystemTesting.ScoreLogic.ExpectedScoreLogic;
import core.Driver;
import org.junit.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by avoitovs on 5/22/2017.
 */
public class def extends BaseFunctions{

    private Driver driver = new Driver();

    //Data for new/tested user
    private String name = "TestNamefake";
    private String surname = "TestSurname";
    private String phone = "12345678";
    private String email = "teslv" ;
    private String gender = "male";
    private String personID = "111111-11111";

    //User's score variables
    private String city = "Riga";
    private String country = "Latvia";
    private int age = 22;
    private int childCount = 2;
    private BigDecimal score = null;

    @Before
    public void setup(){

        driver.setUpFFDesktop();
        Driver.desktopDriver.get("http://qaguru.lv:8080/qa2/");
    }

    @After
    public void tearDown (){
        driver.tearDown(Driver.desktopDriver);
    }


    @Test
    public void test(){

        HomePage homePage = new HomePage();
        User virtualUser = new User(name,
                            surname,
                            phone,
                            email,
                            gender,
                            personID,
                            score);
        Score score = new Score(age,city,country,childCount);

        homePage.createNewUser(virtualUser);

        User realUser = homePage.getExistingUser(virtualUser);

        homePage.addScoreForTheUser(realUser,score);

        realUser = homePage.getExistingUser(realUser);

        ExpectedScoreLogic expectedScoreLogic = new ExpectedScoreLogic(score);

        Assert.assertEquals("Expected score does not match real",expectedScoreLogic.getExpectedTotalScore(),realUser.getScore());

    }
    @Test
    public void test2() throws IOException{
        HomePage homePage = new HomePage();
        GetListOfUsersUsingAPI userAPI = new GetListOfUsersUsingAPI();
        List<User> userAPIlist = userAPI.getListOfUsersAPI();
        Assert.assertEquals("Amount of users are not equals!",userAPIlist.size(),homePage.getListOfUsersFromWeb().size());

    }

    @Test
    public void test3() throws IOException{

        GetListOfScoreVariablesUsingAPI scoreAPI = new GetListOfScoreVariablesUsingAPI();
        List<Score> scoreAPIList = scoreAPI.getListOfScoreVariablesAPI();
        System.out.println(scoreAPIList.get(5).getCity());
    }

    @Test
    public void test4 () throws IOException{
        HomePage homePage = new HomePage();
        int size1 = homePage.getAmountOfUsersWithScore().size();

        GetListOfScoreVariablesUsingAPI scoreAPI = new GetListOfScoreVariablesUsingAPI();
        List<Score> scoreAPIList = scoreAPI.getListOfScoreVariablesAPI();

        Driver.logger.info("Comparing amount of users with score from WEB and API...");
        Assert.assertEquals("Amount of user's score are not equals!",size1,scoreAPIList.size());
    }

    @Test
    public void test5(){

    }

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


}

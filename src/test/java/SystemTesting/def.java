package SystemTesting;

import SystemTesting.API.GetListOfScoreVariablesUsingAPI;
import SystemTesting.API.GetListOfUsersUsingAPI;
import SystemTesting.Model.Score;
import SystemTesting.Model.User;
import SystemTesting.Pages.*;
import SystemTesting.ScoreLogic.ScoreLogic;
import core.Driver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by avoitovs on 5/22/2017.
 */
public class def extends BaseFunctions{

    private Driver driver = new Driver();

    private String name = "bj";
    private String surname = "On";
    private String phone = "Start";
    private String email = "Worwefwewedwewedwedwddeedk" ;
    private String gender = "female";
    private String personID = "nigga";


    private String city = "Riga";
    private String country = "Latvia";
    private int age = 22;
    private int childCount = 1;
    private BigDecimal score = null;

  //  @Before
    public void setup(){

        driver.setUpFFDesktop();
        Driver.desktopDriver.get("http://qaguru.lv:8080/qa2/");
    }

   // @After
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

        Assert.assertEquals("Expected score does not match real",BigDecimal.valueOf(400),realUser.getScore());

    }
    @Test
    public void test2() throws IOException{
        HomePage homePage = new HomePage();
        GetListOfUsersUsingAPI userAPI = new GetListOfUsersUsingAPI();
        List<User> userAPIlist = userAPI.getListOfUsersAPI();
        Assert.assertEquals("Amount of users are not equals!",userAPIlist.size(),homePage.getListOfUsers().size());

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
        Score score = new Score(age,city,country,childCount);
        ScoreLogic scoreLogic = new ScoreLogic(score);

        Assert.assertEquals("Incorrectly calculated score!",BigDecimal.valueOf(400),scoreLogic.getExpectedTotalScore());



    }


}
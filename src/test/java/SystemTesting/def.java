package SystemTesting;

import SystemTesting.Pages.AddScorePage;
import SystemTesting.Pages.AddUserPage;
import SystemTesting.Pages.HomePage;
import SystemTesting.Pages.User;
import com.google.common.util.concurrent.Uninterruptibles;
import core.Driver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * Created by avoitovs on 5/22/2017.
 */
public class def {

    Driver driver = new Driver();

    private String name = "";
    private String surname = "Neznaju";
    private String phone = "1231e23123";
    private String email = "emailrkkkm" ;
    private String gender = "female";
    private String personID = "12-12";


    private String city = "Riga";
    private String country = "Latvia";
    private String age = "22";
    private String childCount = "1";
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
        User user = new User(name,
                            surname,
                            phone,
                            email,
                            gender,
                            personID,
                            score);

        homePage.createNewUser(user);

        System.out.println(user.getScore());

        homePage.addScoreForTheUser(user,age,city,country,childCount);

        user = homePage.getExistingUser(user);

        System.out.println(user.getScore());
        Assert.assertTrue("bla bla",BigDecimal.valueOf(400)==user.getScore());
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);


    }
    @Test
    public void test2(){
        HomePage homePage = new HomePage();


    }


}

package SystemTesting;

import SystemTesting.Pages.*;
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
public class def extends BaseFunctions{

    Driver driver = new Driver();

    private String name = "HItI";
    private String surname = "HmnmnmnI";
    private String phone = "HI";
    private String email = "iihhs" ;
    private String gender = "female";
    private String personID = "begemot";


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
        User virtualUser = new User(name,
                            surname,
                            phone,
                            email,
                            gender,
                            personID,
                            score);

        homePage.createNewUser(virtualUser);

        User realUser = homePage.getExistingUser(virtualUser);

        homePage.addScoreForTheUser(realUser,age,city,country,childCount);



        System.out.println(realUser.getScore());
        Assert.assertTrue("bla bla",BigDecimal.valueOf(400)==realUser.getScore());

    }
    @Test
    public void test2(){
        HomePage homePage = new HomePage();


    }


}

package SystemTesting;

import SystemTesting.Pages.AddScorePage;
import SystemTesting.Pages.AddUserPage;
import SystemTesting.Pages.HomePage;
import SystemTesting.Pages.User;
import com.google.common.util.concurrent.Uninterruptibles;
import core.Driver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by avoitovs on 5/22/2017.
 */
public class def {

    Driver driver = new Driver();

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

        AddUserPage addUserPage = homePage.addUser();

        addUserPage.fillAndSendUserForm("Please","help","me !","I am","dolphin","male");

        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);


    }
    @Test
    public void test2(){
        //test
    }


}

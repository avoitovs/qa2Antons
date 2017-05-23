package SystemTesting;

import SystemTesting.Pages.AddScorePage;
import SystemTesting.Pages.HomePage;
import com.google.common.util.concurrent.Uninterruptibles;
import core.Driver;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by avoitovs on 5/22/2017.
 */
public class def {



    @Test
    public void test(){

        Driver driver = new Driver();
        driver.setUpFFDesktop();
        Driver.desktopDriver.get("http://qaguru.lv:8080/qa2/");
        HomePage homePage = new HomePage();


        AddScorePage addScorePage = homePage.addScoreForTheUser(2);
        addScorePage.fillAndSendScoreForm("qa","qa","qa","12");
   //     Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
        driver.tearDown(Driver.desktopDriver);

    }


}

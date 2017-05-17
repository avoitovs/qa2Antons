package TestCaseUpdate;

import TestCaseUpdate.Games.DreamCatcher;
import TestCaseUpdate.Games.Step;
import com.google.common.util.concurrent.Uninterruptibles;
import core.Driver;
import core.Navigation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by avoitovs on 5/17/2017.
 */
public class TestCaseUpdate {

    Driver driver = new Driver();
    Navigation navigationManager = new Navigation();


    private static String baseURL = "http://jira.evolutiongaming.com";
    private static String testCaseNumber = "TC-2529";
    private String username = "avoitovs";
    private String password = "Delfin4ik";
    private static By step = By.className("ztextarea-step");
    private static By data = By.className("ztextarea-data");
    private static By result = By.className("ztextarea-result");



    @Before
    public void setup(){
        driver.setUpFFDesktop();
    }

    @After
    public void tearDown(){
        driver.tearDown(Driver.desktopDriver);
    }

    @Test
    public void sript(){


        Driver.logger.info("Open Main page");
        navigationManager.goTo(Driver.desktopDriver,baseURL);

        login(username,password);

        openTestCase(testCaseNumber);

        addListOfSteps();

        Uninterruptibles.sleepUninterruptibly(15,TimeUnit.SECONDS);

    }



    private void addListOfSteps (){
        DreamCatcher dreamCatcher = new DreamCatcher();
        List<Step> mow = dreamCatcher.getSteps();
        for (Step step : mow){
           addStep(step.getStep(),step.getData(),step.getResult());
        }
    }



    private void addStep(String stepText,String dataText,String resultText) {
        Driver.logger.info("Adding new step...");
        Driver.desktopDriver.findElement(step).sendKeys(stepText);
        Driver.desktopDriver.findElement(data).sendKeys(dataText);
        Driver.desktopDriver.findElement(result).sendKeys(resultText);
        Driver.desktopDriver.findElement(By.className("restfultable-operations-wrapper")).click();
        Uninterruptibles.sleepUninterruptibly(1,TimeUnit.SECONDS);

    }

    private void openTestCase(String testCaseNumber) {
        Driver.logger.info("Opening test case number: "+testCaseNumber);
        navigationManager.goTo(Driver.desktopDriver,baseURL+"/browse/"+testCaseNumber);
        navigationManager.waitFor(Driver.desktopDriver,step);
    }

    private void login(String username, String password) {
        Driver.logger.info("Logging in with credentials: "+username+" "+password);
        Driver.desktopDriver.findElementById("login-form-username").sendKeys(username);
        Driver.desktopDriver.findElementById("login-form-password").sendKeys(password);
        Driver.desktopDriver.findElementById("login").click();
        Uninterruptibles.sleepUninterruptibly(3,TimeUnit.SECONDS);
    }


}

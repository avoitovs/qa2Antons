package TestCaseUpdate;

import com.google.common.util.concurrent.Uninterruptibles;
import core.Driver;
import core.Navigation;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

/**
 * Created by avoitovs on 5/18/2017.
 */
public class JiraHelper {

    Navigation navigationManager = new Navigation();

    private static String baseURL = "http://jira.evolutiongaming.com";
    private static By step = By.className("ztextarea-step");
    private static By data = By.className("ztextarea-data");
    private static By result = By.className("ztextarea-result");



    protected void addStep(String stepText, String dataText, String resultText) {
        Driver.logger.info("Adding new step...");
        Driver.desktopDriver.findElement(step).sendKeys(stepText);
        Driver.desktopDriver.findElement(data).sendKeys(dataText);
        Driver.desktopDriver.findElement(result).sendKeys(resultText);
        Driver.desktopDriver.findElement(By.className("restfultable-operations-wrapper")).click();
        Uninterruptibles.sleepUninterruptibly(50, TimeUnit.MILLISECONDS);

    }

    protected void openTestCase(String testCaseNumber) {
        Driver.logger.info("Opening test case number: "+testCaseNumber);
        navigationManager.goTo(Driver.desktopDriver,baseURL+"/browse/"+testCaseNumber);
        navigationManager.waitFor(Driver.desktopDriver,step);
    }

    protected void login(String username, String password) {
        Driver.logger.info("Logging in with credentials: "+username+" "+password);
        Driver.desktopDriver.findElementById("login-form-username").sendKeys(username);
        Driver.desktopDriver.findElementById("login-form-password").sendKeys(password);
        Driver.desktopDriver.findElementById("login").click();
        Uninterruptibles.sleepUninterruptibly(3,TimeUnit.SECONDS);
    }

    protected void openJira (){
        Driver.logger.info("Open Main page");
        navigationManager.goTo(Driver.desktopDriver, JiraHelper.baseURL);
    }
}

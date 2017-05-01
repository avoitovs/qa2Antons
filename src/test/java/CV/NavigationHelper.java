package CV;

import com.google.common.util.concurrent.Uninterruptibles;
import core.Driver;
import core.Navigation;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

/**
 * Created by antons on 28/04/2017.
 */
public class NavigationHelper {

    public static final By passwordRecovery = By.partialLinkText("paroles atgadi");
    public static final By passwordRecoveryLink = By.partialLinkText("http://www.cv.lv/password/confirm");
    public static final By registrationConfirmation = By.partialLinkText("Registracijas apstiprinaj");
    public static final By registrationConfirmationLink = By.partialLinkText("http://www.cv.lv/seeker/register/confirm");

    FakeEmail fakeEmail = new FakeEmail();
    Navigation navigationManager = new Navigation();
    PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage();


    public void openLinkFromEmail(By whatLink){

    Driver.logger.info("Opening link received by email...");
    Driver.desktopDriver.get(fakeEmail.getLinkFromEmail(whatLink));
    }

    public void logOut(){

        Driver.logger.info("Exiting...");
        navigationManager.click(Driver.desktopDriver, By.linkText("Iziet"));

    }

    public void openLoginPage (){
        Driver.logger.info("Opening login page...");
        navigationManager.click(Driver.desktopDriver, By.cssSelector("a[title~=Ienākt]"));
    }

    public void openPasswordRecoverPage (){

        Driver.logger.info("Opening password recovery page...");
        navigationManager.goTo(Driver.desktopDriver,"http://www.cv.lv/password");
    }

    public void login(String email, String password) {
        Uninterruptibles.sleepUninterruptibly(5,TimeUnit.SECONDS);
        openLoginPage();
        Driver.logger.info("Enterring system with following credentials: "+ email +" / "+password);
        navigationManager.longWaitFor(Driver.desktopDriver, By.className("fborder4"));
        Driver.desktopDriver.findElement(By.id("login_left")).findElement(By.cssSelector("input[type='text']")).sendKeys(email);
        Driver.desktopDriver.findElement(By.id("login_left")).findElement(By.cssSelector("input[type='password']")).sendKeys(password);

        navigationManager.click(Driver.desktopDriver, By.className("btn_green_submit"));
        Driver.logger.info("Entered!");

    }


}

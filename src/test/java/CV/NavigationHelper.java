package CV;

import com.google.common.util.concurrent.Uninterruptibles;
import core.DriverManager;
import core.NavigationManagerr;
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
    NavigationManagerr navigationManager = new NavigationManagerr();
    PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage();


    public void openLinkFromEmail(By whatLink){

    DriverManager.logger.info("Opening link received by email...");
    DriverManager.desktopDriver.get(fakeEmail.getLinkFromEmail(whatLink));
    }

    public void logOut(){

        DriverManager.logger.info("Exiting...");
        navigationManager.click(DriverManager.desktopDriver, By.linkText("Iziet"));

    }

    public void openLoginPage (){
        DriverManager.logger.info("Opening login page...");
        navigationManager.click(DriverManager.desktopDriver, By.cssSelector("a[title~=Ienākt]"));
    }

    public void openPasswordRecoverPage (){

        DriverManager.logger.info("Opening password recovery page...");
        navigationManager.goTo(DriverManager.desktopDriver,"http://www.cv.lv/password");
    }

    public void login(String email, String password) {
        Uninterruptibles.sleepUninterruptibly(5,TimeUnit.SECONDS);
        openLoginPage();
        DriverManager.logger.info("Enterring system with following credentials: "+ email +" / "+password);
        navigationManager.longWaitFor(DriverManager.desktopDriver, By.className("fborder4"));
        DriverManager.desktopDriver.findElement(By.id("login_left")).findElement(By.cssSelector("input[type='text']")).sendKeys(email);
        DriverManager.desktopDriver.findElement(By.id("login_left")).findElement(By.cssSelector("input[type='password']")).sendKeys(password);

        navigationManager.click(DriverManager.desktopDriver, By.className("btn_green_submit"));
        DriverManager.logger.info("Entered!");

        Uninterruptibles.sleepUninterruptibly(20,TimeUnit.SECONDS);
    }


}

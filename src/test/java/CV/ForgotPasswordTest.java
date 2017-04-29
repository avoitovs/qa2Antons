package CV;

import core.DriverManager;
import core.NavigationManagerr;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Created by antons on 28/04/2017.
 */
public class ForgotPasswordTest {

    DriverManager driverManager = new DriverManager();
    NavigationManagerr navigationManager = new NavigationManagerr();
    FakeEmail fakeEmail = new FakeEmail();
    Registration registration = new Registration();
    NavigationHelper navigationHelper = new NavigationHelper();
    PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage();

    @Before
    public void setUp (){

        driverManager.setUpFFDesktop();

    }

    @After
    public void tearDown(){

        driverManager.tearDown(DriverManager.desktopDriver);
        driverManager.tearDown(DriverManager.mobileDriver);

    }

    @Test

    public void testForgotPassword (){

        String email = fakeEmail.generateFakeEmail();

        navigationManager.goTo(DriverManager.desktopDriver,"http://www.cv.lv");

        registration.newUserRegistration(email);

        fakeEmail.openMessage(NavigationHelper.registrationConfirmation);

        navigationHelper.openLinkFromEmail(NavigationHelper.registrationConfirmationLink);

        checkAccount();

        navigationHelper.logOut();

        navigationHelper.openPasswordRecoverPage();

        passwordRecoveryPage.sendPasswordRecoveryEmail(email);

        passwordRecoveryPage.checkIfRecoveryWasSent();

        fakeEmail.openMessage(NavigationHelper.passwordRecovery);

        navigationHelper.openLinkFromEmail(NavigationHelper.passwordRecoveryLink);

        passwordRecoveryPage.enterNewPassword();

        submitNewPassword();

        navigationHelper.login(email,passwordRecoveryPage.newPassword);

        checkAccount();

    }

    @Test
    public void te(){

        navigationManager.goTo(DriverManager.desktopDriver,"http://www.cv.lv");

        navigationHelper.login("wivewitayu@honor-8.com","d673n923nnkFGJ");
    }




    public void submitNewPassword() {
        DriverManager.logger.info("Submit new password...");

        for (int j = 0;j<6;j++) {
            navigationManager.click(DriverManager.desktopDriver, By.cssSelector("input[value='Saglabāt']"));
        }
        DriverManager.logger.info("Done!");
        navigationHelper.logOut();
    }



    private void checkAccount() {
        String actualName = DriverManager.desktopDriver.findElement(By.xpath("//*[@id='topnav_login']/table/tbody/tr/td/strong")).getText();

        Assert.assertEquals("Wrong name on the page!", Registration.firstName+" "+Registration.lastName,actualName);
        DriverManager.logger.info("Successfully confirmed!");
    }

}

package CV;

import core.Driver;
import core.Navigation;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Created by antons on 28/04/2017.
 */
public class ForgotPasswordTest {

    Driver driver = new Driver();
    Navigation navigationManager = new Navigation();
    FakeEmail fakeEmail = new FakeEmail();
    Registration registration = new Registration();
    NavigationHelper navigationHelper = new NavigationHelper();
    PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage();

    @Before
    public void setUp (){

        driver.setUpFFDesktop();

    }

    @After
    public void tearDown(){

        driver.tearDown(Driver.desktopDriver);
        driver.tearDown(Driver.mobileDriver);

    }

    @Test

    public void testForgotPassword (){

        String email = fakeEmail.generateFakeEmail();

        navigationManager.goTo(Driver.desktopDriver,"http://www.cv.lv");

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

        navigationManager.goTo(Driver.desktopDriver,"http://www.cv.lv");

        navigationHelper.login("wivewitayu@honor-8.com","d673n923nnkFGJ");
    }




    public void submitNewPassword() {
        Driver.logger.info("Submit new password...");

        for (int j = 0;j<6;j++) {
            navigationManager.click(Driver.desktopDriver, By.cssSelector("input[value='Saglabāt']"));
        }
        Driver.logger.info("Done!");
        navigationHelper.logOut();
    }



    private void checkAccount() {
        String actualName = Driver.desktopDriver.findElement(By.xpath("//*[@id='topnav_login']/table/tbody/tr/td/strong")).getText();

        Assert.assertEquals("Wrong name on the page!", Registration.firstName+" "+Registration.lastName,actualName);
        Driver.logger.info("Successfully confirmed!");
    }

}

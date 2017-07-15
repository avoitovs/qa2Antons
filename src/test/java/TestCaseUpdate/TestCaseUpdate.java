package TestCaseUpdate;

import core.Driver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by avoitovs on 5/17/2017.
 */
public class TestCaseUpdate {

    Driver driver = new Driver();
    JiraHelper jiraHelper = new JiraHelper();
    AddGameHelper add = new AddGameHelper();


    private static String testCaseNumber = "TC-5205";
    private String username = "kjekimovs";
    private String password = "tyui9o0p";



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


        jiraHelper.openJira();

        jiraHelper.login(username,password);

        jiraHelper.openTestCase(testCaseNumber);

        add.addMOWSteps();
        add.addCSPSteps();
        //add.addDBRSteps();
        add.addETHSteps();
        add.addTRPorTCPSteps();
        //add.addUTHSteps();

    }



}

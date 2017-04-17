package Delfi.tests.managers;

import Delfi.tests.tests.DelfiTest;
import org.apache.log4j.Logger;

/**
 * Created by antons on 12/04/2017.
 */
public class TestBase  {


    protected static final Logger logger = Logger.getLogger(DelfiTest.class);

    protected final NavigationManager navigationManager = new NavigationManager();
    protected final DriverManager driverManager = new DriverManager();
    protected final CommentManager commentManager= new CommentManager();
    protected final AssertionManager assertionManager = new AssertionManager();
    protected final TitleManager titleManager = new TitleManager();


}

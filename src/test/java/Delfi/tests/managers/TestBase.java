package Delfi.tests.managers;

import core.Driver;

/**
 * Created by antons on 12/04/2017.
 */
public class TestBase  {

    protected final NavigationManager navigationManager = new NavigationManager();
    protected final Driver driver = new Driver();
    protected final CommentManager commentManager= new CommentManager();
    protected final AssertionManager assertionManager = new AssertionManager();


}

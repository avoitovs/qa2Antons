package SystemTesting.API;


import SystemTesting.Pages.User;
import core.Driver;

import java.io.IOException;
import java.util.List;

/**
 * Created by avoitovs on 6/2/2017.
 */
public class GetListOfUsersUsingAPI {

    private List<User> listOfUsersAPI;

    public GetListOfUsersUsingAPI() throws IOException {
        Driver.logger.info("Getting user's list via API...");
        ClientsRequester requester = new ClientsRequester();
        this.listOfUsersAPI  = requester.getAllClients();
    }

    public List<User> getListOfUsersAPI() {
        return listOfUsersAPI;
    }
}

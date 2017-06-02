package SystemTesting.API;

import SystemTesting.Model.Score;
import core.Driver;

import java.io.IOException;
import java.util.List;

/**
 * Created by avoitovs on 6/2/2017.
 */
public class GetListOfScoreVariablesUsingAPI {

    private List<Score> listOfScoreVariablesAPI;

    public GetListOfScoreVariablesUsingAPI() throws IOException {
        Driver.logger.info("Getting list of user's score variables via API...");
        ScoreVariablesRequester requester = new ScoreVariablesRequester();
        this.listOfScoreVariablesAPI = requester.getScoreVariables();
    }

    public List<Score> getListOfScoreVariablesAPI() {
        return listOfScoreVariablesAPI;
    }



}

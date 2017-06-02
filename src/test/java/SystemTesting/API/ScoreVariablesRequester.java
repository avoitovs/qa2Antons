package SystemTesting.API;

import SystemTesting.API.Model.Score.GetScoreVariablesResponse;
import SystemTesting.Pages.Score;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by avoitovs on 5/22/2017.
 */
public class ScoreVariablesRequester {

    private String URL = "http://navipoint.lv:8080/qa2/getScores";

    public List<Score> getScoreVariables () throws IOException {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(URL, String.class);
        String jsonResponse = responseEntity.getBody();

        ObjectMapper mapper = new ObjectMapper();

        Score[] getScoreVariablesResponse = mapper.readValue(jsonResponse, Score[].class);

        return Arrays.asList(getScoreVariablesResponse);
    }



}

package SystemTesting.API;

import SystemTesting.API.Model.Clients.GetClientsResponse;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by avoitovs on 5/22/2017.
 */
public class ClientsRequester {


    private String URL = "http://navipoint.lv:8080/qa2/getClients";

    public List<GetClientsResponse> getAllClients () throws IOException {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(URL, String.class);
        String jsonResponse = responseEntity.getBody();

        ObjectMapper mapper = new ObjectMapper();

        GetClientsResponse[] getClientsResponse = mapper.readValue(jsonResponse,GetClientsResponse[].class);

        return Arrays.asList(getClientsResponse);
    }


}

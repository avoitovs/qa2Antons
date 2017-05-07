package backEndTesting;

import backEndTesting.model.Response;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.net.URL;

/**
 * Created by antons on 07/05/2017.
 */
public class WeatherRequester {

    private String URL ="http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b1b15e88fa797225412429c1c50c122a1";


    public Response getWeather() throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        Response response = mapper.readValue(new URL(URL), Response.class);

        return response;
    }


}


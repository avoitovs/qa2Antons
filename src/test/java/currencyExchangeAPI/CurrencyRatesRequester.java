package currencyExchangeAPI;

import WeatherRequestTest.model.Response;
import currencyExchangeAPI.model.ExchangeRequestResponse;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URL;

/**
 * Created by antons on 09/05/2017.
 */
public class CurrencyRatesRequester {

    private String URL = "http://api.fixer.io/latest";

    public ExchangeRequestResponse getCurrencyExchangeRates () throws IOException {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(URL, String.class);
        String jsonResponse = responseEntity.getBody();

        ObjectMapper mapper = new ObjectMapper();

        ExchangeRequestResponse exchangeRequestResponse = mapper.readValue(jsonResponse, ExchangeRequestResponse.class);

        return exchangeRequestResponse;
    }

}

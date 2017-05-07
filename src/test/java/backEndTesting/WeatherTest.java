package backEndTesting;

import backEndTesting.model.Response;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created by antons on 07/05/2017.
 */
public class WeatherTest {

    @Test
    public void WeatherAPITest () throws IOException {

        //get response from server
        WeatherRequester requester = new WeatherRequester();

        Response response = requester.getWeather();

        //check response

        Assert.assertEquals("Wrong LON: ", BigDecimal.valueOf(-0.13),response.getCoord().getLon());
        Assert.assertEquals("Wrong LAT: ", BigDecimal.valueOf(51.51),response.getCoord().getLat());





    }





}

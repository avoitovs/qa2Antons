package currencyExchangeAPI;

import currencyExchangeAPI.model.ExchangeRequestResponse;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created by antons on 09/05/2017.
 */
public class CurrencyTest {


        @Test
        public void currencyTest () throws IOException {

            CurrencyRatesRequester currencyRatesRequester = new CurrencyRatesRequester();

            ExchangeRequestResponse exchangeRequestResponse = currencyRatesRequester.getCurrencyExchangeRates();

            Assert.assertEquals("Wrong exchange range! ", BigDecimal.valueOf(1.4731), exchangeRequestResponse.getRates().getAUD());
        }
}

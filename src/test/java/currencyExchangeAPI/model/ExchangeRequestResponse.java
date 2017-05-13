package currencyExchangeAPI.model;

/**
 * Created by antons on 09/05/2017.
 */


public class ExchangeRequestResponse {

    private String base;
    private String date;
    private Rates rates;


    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Rates getRates() {
        return rates;
    }

    public void setRates(Rates rates) {
        this.rates = rates;
    }
}

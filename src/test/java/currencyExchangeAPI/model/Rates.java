package currencyExchangeAPI.model;



import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.math.BigDecimal;

/**
 * Created by antons on 09/05/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)

public class Rates {

    @JsonProperty("AUD")
    private BigDecimal AUD;
    @JsonProperty("BGN")
    private BigDecimal BGN;
    @JsonProperty("BRL")
    private BigDecimal BRL;
    @JsonProperty("CAD")
    private BigDecimal CAD;
    @JsonProperty("USD")
    private BigDecimal USD;
    @JsonProperty("RUB")
    private BigDecimal RUB;


    public BigDecimal getAUD() {
        return AUD;
    }

    public void setAUD(BigDecimal AUD) {
        this.AUD = AUD;
    }

    public BigDecimal getBGN() {
        return BGN;
    }

    public void setBGN(BigDecimal BGN) {
        this.BGN = BGN;
    }

    public BigDecimal getBRL() {
        return BRL;
    }

    public void setBRL(BigDecimal BRL) {
        this.BRL = BRL;
    }

    public BigDecimal getCAD() {
        return CAD;
    }

    public void setCAD(BigDecimal CAD) {
        this.CAD = CAD;
    }

    public BigDecimal getUSD() {
        return USD;
    }

    public void setUSD(BigDecimal USD) {
        this.USD = USD;
    }

    public BigDecimal getRUB() {
        return RUB;
    }

    public void setRUB(BigDecimal RUB) {
        this.RUB = RUB;
    }
}
package SystemTesting.ScoreLogic;

import SystemTesting.Model.Score;
import SystemTesting.Pages.BaseFunctions;
import core.Driver;

import java.math.BigDecimal;

/**
 * Created by antons on 02/06/2017.
 */
public class ExpectedScoreLogic extends BaseFunctions {

    private BigDecimal expectedTotalScore;
    private int expectedScoreAge;
    private int expectedScoreCity;
    private int expectedScoreCountry;
    private int expectedScoreChildCount;

    public BigDecimal getExpectedTotalScore(){
        return expectedTotalScore;
    }

    public ExpectedScoreLogic(Score score) {
        getExpectedScoreAge(score.getAge());
        getExpectedScoreCity(score.getCity());
        getExpectedScoreCountry(score.getCountry());
        getExpectedScoreChildCount(score.getChildCount());
        calculateExpectedTotalScore();
    }

    private void getExpectedScoreAge(int age){
        if (age>=18 & age<=22){
            this.expectedScoreAge = 200;
        }else if (age>=23 & age<35){
            this.expectedScoreAge = 300;
        }else if (age>=35 & age<=50){
            this.expectedScoreAge = 250;
        }else if (age>=51 & age<=60){
            this.expectedScoreAge = 200;
        }else if (age>=60){
            this.expectedScoreAge = 100;
        }else if (age<18){
            this.expectedScoreAge = 0;
            Driver.logger.info("User is younger than 18 years old. Therefore, score should not be calculated!");
        }
    }
    private void getExpectedScoreCity (String city){
        if (city.equals("Riga")){
            this.expectedScoreCity = 300;
        }else if (ifForbiddenCharPersist(city)){
            this.expectedScoreCity = 0;
            Driver.logger.info("Entered city is invalid! Therefore, score should not be calculated!");
        }else {
            this.expectedScoreCity = 100;
        }
    }

    private void getExpectedScoreCountry (String country){
        if (country.equals("Latvia")){
            this.expectedScoreCountry = 300;
        }else if (ifForbiddenCharPersist(country)){
            this.expectedScoreCountry = 0;
            Driver.logger.info("Entered country is invalid! Therefore, score should not be calculated!");
        }else {
            this.expectedScoreCountry = 100;
        }

    }

    private void getExpectedScoreChildCount (int childCount){
        if (childCount==1){
            this.expectedScoreChildCount = 300;
        }else if (childCount==2||childCount==3){
            this.expectedScoreChildCount = 200;
        }else if (childCount>3){
            this.expectedScoreChildCount = 100;
        }else if (childCount<0){
            this.expectedScoreChildCount = 0;
            Driver.logger.info("Entered child count is invalid! Therefore, score should not be calculated!");
        }
    }

    private void calculateExpectedTotalScore(){
        if (expectedScoreAge==0||expectedScoreCity==0||expectedScoreCountry==0||expectedScoreChildCount==0) {
            this.expectedTotalScore = null;
            Driver.logger.info("Some fields are invalid! Therefore, score should not be calculated!");
        }else {
            this.expectedTotalScore = new BigDecimal(expectedScoreAge
                    + expectedScoreChildCount
                    + expectedScoreCountry
                    + expectedScoreCity);
        }
    }





}

package SystemTesting.ScoreLogic;

import SystemTesting.Model.Score;
import org.junit.Assert;

import java.math.BigDecimal;

/**
 * Created by antons on 02/06/2017.
 */
public class ScoreLogic {

    private BigDecimal expectedTotalScore;
    private int expectedScoreAge;
    private int expectedScoreCity;
    private int expectedScoreCountry;
    private int expectedScoreChildCount;

    public BigDecimal getExpectedTotalScore(){
        return expectedTotalScore;
    }

    public ScoreLogic(Score score) {
        getExpectedAge(score.getAge());
        getExpectedScoreCity(score.getCity());
        getExpectedScoreCountry(score.getCountry());
        getExpectedScoreChildCount(score.getChildCount());
        calculateExpectedTotalScore();
    }

    private void getExpectedAge (int age){
        //Assert.assertTrue("User is younger than 18 years!",age<18);
        if (age>=18 && age<=22){
            this.expectedScoreAge = 200;
        }else if (age>=23 && age<35){
            this.expectedScoreAge = 300;
        }else if (age>=35 && age<=50){
            this.expectedScoreAge = 250;
        }else if (age>=51 && age<=60){
            this.expectedScoreAge = 200;
        }else if (age>=60){
            this.expectedScoreAge = 100;
        }
    }
    private void getExpectedScoreCity (String city){
       // Assert.assertTrue("Entered city is invalid!",city.contains();
        if (city.equals("Riga")){
            this.expectedScoreCity = 300;
        }else {
            this.expectedScoreCity = 100;
        }
    }

    private void getExpectedScoreCountry (String country){
        // Assert.assertTrue("Entered city is invalid!",city.contains();
        if (country.equals("Latvia")){
            this.expectedScoreCountry = 300;
        }else {
            this.expectedScoreCountry = 100;
        }
    }

    private void getExpectedScoreChildCount (int childCount){
        Assert.assertFalse("Invalid child count!",childCount<0);
        if (childCount==1){
            this.expectedScoreChildCount = 300;
        }else if (childCount==2||childCount==3){
            this.expectedScoreChildCount = 200;
        }else if (childCount>3){
            this.expectedScoreChildCount = 100;
        }
    }

    private void calculateExpectedTotalScore(){
        this.expectedTotalScore = new BigDecimal(expectedScoreAge+expectedScoreChildCount+expectedScoreCountry+expectedScoreCity);
    }






}

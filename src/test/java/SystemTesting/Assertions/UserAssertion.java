package SystemTesting.Assertions;

import SystemTesting.Model.User;
import SystemTesting.Pages.BaseFunctions;
import core.Driver;
import org.junit.Assert;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by antons on 30/05/2017.
 */
public class UserAssertion extends BaseFunctions {



    public void compareUsersFromAPIandWEB(List<User> API, List<User> WEB){
        for (int i=0;i<WEB.size();i++){
            Driver.logger.info("Comparing "+WEB.get(i).getName()+" "+WEB.get(i).getSurname()+" info from WEB and API");
            Assert.assertEquals("This user's name doesn't match!",WEB.get(i).getName(),API.get(i).getName());
            Assert.assertEquals("This user's surname doesn't match!",WEB.get(i).getSurname(),API.get(i).getSurname());
            Assert.assertEquals("This user's personal ID doesn't match!",WEB.get(i).getPersonId(),API.get(i).getPersonId());
            Assert.assertEquals("This user's gender doesn't match!",WEB.get(i).getGender(),API.get(i).getGender());
            Assert.assertEquals("This user's email doesn't match!",WEB.get(i).getEmail(),API.get(i).getEmail());
            Assert.assertEquals("This user's phone doesn't match!",WEB.get(i).getPhone(),API.get(i).getPhone());
            Assert.assertEquals("This user's score doesn't match!",WEB.get(i).getScore(),API.get(i).getScore());
        }
    }


    public void validateUsersData (User user){
        Driver.logger.info("Validating Name...");
        Assert.assertFalse("Invalid Name!",ifForbiddenCharPersist(user.getName()));

        Driver.logger.info("Validating Surname...");
        Assert.assertFalse("Invalid Name!",ifForbiddenCharPersist(user.getSurname()));

        Driver.logger.info("Validating email address...");
        Assert.assertTrue("Invalid email",user.getEmail().contains("@"));
        Assert.assertTrue("Invalid email",user.getEmail().contains("."));

        Driver.logger.info("Validating phone number...");
        Assert.assertTrue("Invalid phone",containsOnlyNumbers(user.getPhone()));
        Assert.assertFalse("Invalid phone",user.getPhone().contains("-"));

        Driver.logger.info("Validating personID...");
        Assert.assertTrue("Invalid personID",containsOnlyNumbers(user.getPersonId()));
       // Assert.assertTrue("Invalid personID",user.getPersonId().contains("-"));

    }


    private boolean containsOnlyNumbers (String string){

        try{
            BigInteger.valueOf(Integer.parseInt(string,10));
        return true;
        } catch (Exception e){
            return false;
        }

    }


//regexp







}

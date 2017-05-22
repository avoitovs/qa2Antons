package SystemTesting.Pages;

import java.math.BigDecimal;

/**
 * Created by avoitovs on 5/22/2017.
 */
public class User {
  private String name;
  private String surname;
  private String phone;
  private String email;
  private String gender;
  private String personID;
  private BigDecimal score;

    public User(String name, String surname, String phone, String email, String gender, String personID, BigDecimal score) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.personID = personID;
        this.score = score;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getPersonID() {
        return personID;
    }

    public BigDecimal getScore() {
        return score;
    }
}


package SystemTesting.Pages;


import java.math.BigDecimal;

/**
 * Created by avoitovs on 5/22/2017.
 */
public class User {

  private long id;
  private String name;
  private String surname;
  private String phone;
  private String email;
  private String gender;
  private String personId;
  private BigDecimal score;

    public User(String name, String surname, String phone, String email, String gender, String personId, BigDecimal score) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.personId = personId;
        this.score = score;
    }
    public User(){}

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }


    public long getId() {
        return id;
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

    public String getPersonId() {
        return personId;
    }

    public BigDecimal getScore() {
        return score;
    }
}


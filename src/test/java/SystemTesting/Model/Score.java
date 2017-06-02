package SystemTesting.Model;

/**
 * Created by avoitovs on 6/2/2017.
 */
public class Score {

    private Long clientId;
    private int age;
    private String city;
    private String country;
    private int childCount;

    public Score(int age, String city, String country, int childCount) {
        this.age = age;
        this.city = city;
        this.country = country;
        this.childCount = childCount;
    }

    public Score() {
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getChildCount() {
        return childCount;
    }

    public void setChildCount(int childCount) {
        this.childCount = childCount;
    }
}

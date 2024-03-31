package bg.fmi.web.lab.raceeventmanagement.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
public class Racer {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;

    public Racer(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Racer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}

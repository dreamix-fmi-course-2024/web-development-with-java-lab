package bg.fmi.web.lab.raceeventmanagement.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Racer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    public Racer() {
    }

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

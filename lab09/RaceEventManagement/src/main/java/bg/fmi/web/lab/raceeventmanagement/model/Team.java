package bg.fmi.web.lab.raceeventmanagement.model;

import jakarta.persistence.*;
import org.springframework.context.annotation.EnableMBeanExport;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team")
    private List<Racer> racers;

    @ManyToMany(mappedBy = "teams")

    private List<Event> events;



    public Team(String name, List<Racer> racers) {
        this.name = name;
//        this.racers = racers;
    }
    public Team() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Racer> getRacers() {
        return racers;
    }

    public void setRacers(List<Racer> racers) {
        this.racers = racers;
    }
}

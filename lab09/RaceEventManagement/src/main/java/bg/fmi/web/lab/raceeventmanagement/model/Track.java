package bg.fmi.web.lab.raceeventmanagement.model;

import jakarta.persistence.*;

import java.util.List;

//@Entity
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer length; // in meters
    @OneToMany
    private List<Event> events;


    public Track(Integer id, String name, Integer length) {
        this.id = id;
        this.name = name;
        this.length = length;
    }
    public Track() {}

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }


}

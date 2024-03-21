package bg.fmi.web.lab.raceeventmanagement.model;

import java.time.LocalDateTime;
import java.util.List;

public class Event {
    private Integer id;
    private String name;
    private Track track;
    private List<Team> teams;
    private LocalDateTime dateOfEvent;

    public Event(String name, Track track, List<Team> teams, LocalDateTime dateOfEvent) {
        this.name = name;
        this.track = track;
        this.teams = teams;
        this.dateOfEvent = dateOfEvent;
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

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public LocalDateTime getDateOfEvent() {
        return dateOfEvent;
    }

    public void setDateOfEvent(LocalDateTime dateOfEvent) {
        this.dateOfEvent = dateOfEvent;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", track=" + track +
                ", teams=" + teams +
                ", dateOfEvent=" + dateOfEvent +
                '}';
    }
}

package bg.fmi.web.lab.raceeventmanagement.model;

import java.util.List;

public class Team {

    private String name;

    private List<Racer> racers;

    public Team(String name, List<Racer> racers) {
        this.name = name;
        this.racers = racers;
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

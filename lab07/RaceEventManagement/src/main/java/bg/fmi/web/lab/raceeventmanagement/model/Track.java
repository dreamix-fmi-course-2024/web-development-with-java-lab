package bg.fmi.web.lab.raceeventmanagement.model;

public class Track {

    private Integer id;
    private String name;
    private Integer length; // in meters

    public Track(Integer id, String name, Integer length) {
        this.id = id;
        this.name = name;
        this.length = length;
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

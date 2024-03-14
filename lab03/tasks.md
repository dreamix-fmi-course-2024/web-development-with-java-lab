# Race Event Management System

The client came to you wanting to build an Event management system for Race Tracks. He needs it to support multiple teams, tracks, and racers.


### Racer details
 - Id
 - First Name
 - Last Name
 - Age
  
### Team details
 - name (up to 60 characters, unique)
 - List< Racer >

### Event details
 - id
 - name
 - Track
 - List< Team >
 - Date of event

### Track details
 - id
 - name
 - length

## Define your project structure

### Create entities
 1. Create an entity package where all your elements will reside
 2. Implement all your entity objects defined by the details
    
### Create repositories
 1. Create a repository package where all your operations with the DB will be (make sure that the IDs are auto-increment)
 2. Implement default CRUD operations:
    1. RacerRepository
   ``` java
    public class RacerRepository {
        // structure to store your Racers
        private Map<Integer, Racer> racerTable;

        /**
         * Add racer to your DB
        * @param racer
        */
        public void addRacer(Racer racer) {
            racerTable.put(racer.getId(), racer);
        }

        /**
         * Delete racer by id. If there is no element to be deleted then return false;
        * @param id
        * @return if there is element to delete -> true, if not -> false
        */
        public boolean deleteRacerById(Integer id) {
            return racerTable.remove(id) == null ? false : true;
        }

        /**
         * Get racer by passed id. If there is no element return Optional empty
        * @param id
        * @return Optional of Racer
        */
        public Optional<Racer> getRacerById(Integer id) {
            return Optional.of(racerTable.get(id));
        }
    }
   ```
   2. TeamRepository
   ```java
    public class TeamRepository {

        private Map<String, Team> teamTable = new HashMap<>();

        /**
         * Add team to your DB. If the Team is already present throw Custom Exception
        * @param team
        */
        public void addTeam(Team team) {
        }

        /**
         * Delete team by name. If there is no element to be deleted then return false;
        * @param name
        * @return if there is element to delete -> true, if not -> false
        */
        public boolean deleteTeamByName(String name) {
        }

        /**
         * Get team by passed name. If there is no element return Optional empty. The search is case-insensitive
        * @param name
        * @return Optional of Team
        */
        public Optional<Team> getTeamById(String name) {
        }

        /**
         * Get all teams
        * @return
        */
        public List<Team> getAllTeams() {
        }
    }

   ```
3. EventRepository
```java
public class EventRepository {

    private Map<Integer, Event> eventTable;

    /**
     * Add event to your DB
     * @param event
     */
    public void addEvent(Event event) {
        eventTable.put(event.getId(), event);
    }

    /**
     * Delete event by id. If there is no element to be deleted then return false;
     * @param id
     * @return if there is element to delete -> true, if not -> false
     */
    public boolean deleteEventById(Integer id) {
        return eventTable.remove(id) == null ? false : true;
    }

    /**
     * Get event by passed id. If there is no element return Optional empty
     * @param id
     * @return Optional of Racer
     */
    public Optional<Event> getEventById(Integer id) {
        return Optional.of(eventTable.get(id));
    }

    /**
     * Get all events
     * @return
     */
    public List<Event> getAllEvents() {
        return eventTable.values().stream().collect(Collectors.toList());
    }
}

```

4. TrackRepository
```java
public class TrackRepository {

    private Map<Integer, Track> trackMapTable = new HashMap<>();

    /**
     * Add track to your DB. If the track is already present throw Custom Exception
     * @param track
     */
    public void addTrack(Track track) {
    }

    /**
     * Delete track by name. If there is no element to be deleted then return false;
     * @param name
     * @return if there is element to delete -> true, if not -> false
     */
    public boolean deleteTrackByName(String name) {
    }

    /**
     * Get track by passed id. If there is no element return Optional empty.
     * @param id
     * @return Optional of Track
     */
    public Optional<Track> getTrackById(Integer id) {
    }

    /**
     * Get all tracks
     * @return
     */
    public List<Track> getAllTracks() {
    }
}
```

### Create services
Create a service package where all your business logic will be

Create separate services for operating over the main CRUD operations.
e.g.
```java
/**
 * While implementing all functions you can introduce additional functionalities inside the repository class
 */
public interface RacerService {
    List<Racer> getAllRacers();

    List<Racer> getAllRacersByFirstName(String firstName);

    void createRacer(String firstName, String lastName, Integer age);

    boolean deleteRacerById(Integer id);
}

```

For EventService expand the logic by implementing the following interface

```java
/**
 * While implementing all functions you can introduce additional functionalities inside the repository class
 */
public interface EventService {
    List<Event> getAllEvents();

    List<Event> getAllRacersByTrackName(String trackName);

    void createEvent();

    boolean deleteEventById(Integer id);

    List<Event> getAllEventsBefore(LocalDate date);

    List<Event> getAllEventsAfter(LocalDate date);

    List<Event> getUpcomingEvents();

    /**
     * Get all racers from the nearest event (timely manner)
     * @return
     */
    List<Racer> getAllRacersForNearestEvent();

    List<Event> getEventsForTrack(Track track);
}

```

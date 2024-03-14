# Track Event System

Client came to you with the desire to build an Event management system for Race Tracks. He needs to support multiple teams, tracks and racers.


### Racer details
 - Id
 - First Name
 - Last Name
 - Age
  
### Team details
 - name (up to 60 characters, unique)
 - List<Racer>

### Event details
 - id
 - name
 - Track
 - List<Team>

### Track details
 - id
 - name
 - length

## Define your project structure

### Create entities
 1. Create an entity package where all your elements will resides
 2. Implement all your entity objects define by the details
    
### Create repositoreis
 1. Create a repository package where all your operation with the DB will be
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
        public Optional<Team> getRacerById(String name) {
        }

        /**
         * Get all teams
        * @return
        */
        public List<Team> getAllTeams() {
        }
    }

   ```

### Create services
Create a service package where all your business logic will be

1. RacerService
   ```java
   /**
    * While implementing all functions you can introduce additional functionalities inside the repository class
    */
   public interface RacerService {
        List<Racer> getAllRacers();

        List<Racer> getAllRacersByFirstName(String firstName);

        void createRacer(String firstName, String lastName, Integer age);

        boolean deleteRacerByLastName(String lastName);
    }

   ```
2. TeamService
3. EventService
4. TrackService
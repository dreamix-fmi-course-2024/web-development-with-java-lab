package bg.fmi.web.lab.raceeventmanagement.repository;

import bg.fmi.web.lab.raceeventmanagement.model.Racer;
import bg.fmi.web.lab.raceeventmanagement.repository.sequence.RaceSequence;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//@Component
@Component("customName")
//@Repository("customName")
public class RacerRepository {
    // structure to store your Racers
    private static Map<Integer, Racer> racerTable = new HashMap<>();

    /**
     * Add racer to your DB
     * @param racer
     */
    public void createRacer(Racer racer) {
        if (racer.getId() != null) {
            throw new IllegalArgumentException("Cannot create Racer with already given ID.");
        }
        racer.setId(RaceSequence.getNextValue());
        racerTable.put(racer.getId(), racer);
    }


    /**
     * Modify racer to your DB
     * @param racer
     */
    public void updateRacer(Racer racer) {
        if (racer.getId() == null) {
            throw new IllegalArgumentException("Cannot update Racer without ID.");
        }
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

    public List<Racer> getAllRacers() {
        return racerTable.values().stream().toList();
    }
}

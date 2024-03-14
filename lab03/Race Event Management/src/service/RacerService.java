package service;

import model.Racer;
import repository.RacerRepository;

import java.util.List;
import java.util.Objects;

/**
 * While implementing all functions you can introduce additional functionalities inside the repository class
 */
public class RacerService {
    RacerRepository racerRepository = new RacerRepository(); // in the future will be injected by the Spring

    public List<Racer> getAllRacers() {
        return racerRepository.getAllRacers();
    }

    public List<Racer> getAllRacersByFirstName(String firstName) {
        return racerRepository.getAllRacers().stream()
                .filter(racer -> Objects.equals(racer.getFirstName(), firstName) )
                .toList(); // this filtering should be leavet to DB - it will be much faster and saves data transfer from the DB.
        // it is highly recommended for the DB to have index by the field by which we are filtering.
    }
    public void createRacer(String firstName, String lastName, Integer age) {
        racerRepository.createRacer(new Racer(firstName, lastName, age));
    }
    public boolean deleteRacerById(Integer id) {
        return racerRepository.deleteRacerById(id);
    }
}

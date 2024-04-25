package bg.fmi.web.lab.raceeventmanagement.service;

import bg.fmi.web.lab.raceeventmanagement.model.Racer;
import bg.fmi.web.lab.raceeventmanagement.repository.RacerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

/**
 * While implementing all functions you can introduce additional functionalities inside the bg.fmi.web.lab.raceeventmanagement.model.repository class
 */
@Profile("dev")
@Component // @Service
public class RacerService {
//    RacerRepository racerRepository = new RacerRepository(); // in the future will be injected by the Spring

//    @Autowired
//    @Qualifier("customName")
    private final RacerRepository racerRepository;

    @Autowired
    public RacerService(RacerRepository racerRepository) {
        Racer r;

        this.racerRepository = racerRepository;
    }

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

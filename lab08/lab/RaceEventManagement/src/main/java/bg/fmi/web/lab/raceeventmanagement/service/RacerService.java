package bg.fmi.web.lab.raceeventmanagement.service;

import bg.fmi.web.lab.raceeventmanagement.model.Racer;
import bg.fmi.web.lab.raceeventmanagement.repository.RacerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * While implementing all functions you can introduce additional functionalities inside the bg.fmi.web.lab.raceeventmanagement.model.repository class
 */
    @Service
public class RacerService {
    private final RacerRepository racerRepository;

    @Autowired
    public RacerService(RacerRepository racerRepository) {
        Racer r;

        this.racerRepository = racerRepository;
    }

    public Racer createRacer(Racer racer) {
       return  racerRepository.save(racer);
    }
}

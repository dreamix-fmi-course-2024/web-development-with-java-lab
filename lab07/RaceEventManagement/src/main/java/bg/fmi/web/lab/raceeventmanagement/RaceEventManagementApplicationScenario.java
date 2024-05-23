package bg.fmi.web.lab.raceeventmanagement;

import bg.fmi.web.lab.raceeventmanagement.model.Racer;
import bg.fmi.web.lab.raceeventmanagement.model.Team;
import bg.fmi.web.lab.raceeventmanagement.model.Track;
import bg.fmi.web.lab.raceeventmanagement.repository.sequence.TeamSequence;
import bg.fmi.web.lab.raceeventmanagement.service.EventService;
import bg.fmi.web.lab.raceeventmanagement.service.RacerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class RaceEventManagementApplicationScenario {

    public static void main(String[] args) {
        SpringApplication.run(RaceEventManagementApplicationScenario.class, args);
    }

}

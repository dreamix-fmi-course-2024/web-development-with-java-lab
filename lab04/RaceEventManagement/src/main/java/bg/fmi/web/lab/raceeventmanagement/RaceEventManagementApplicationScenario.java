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

//@SpringBootApplication
public class RaceEventManagementApplicationScenario implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(RaceEventManagementApplicationScenario.class, args);
    }

    @Autowired
    private RacerService racerService;

    @Autowired
    private EventService eventService;

    @Autowired
    private ApplicationContext context;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("List of Beans provided by Spring Boot:");

        String[] beanNames = context.getBeanDefinitionNames();
        List<String> beanClasses = Stream.of(beanNames)
                .map(el -> context.getBean(el).getClass().toString())
                .filter(el -> el.contains("bg.fmi"))
                .toList();
        beanClasses.forEach(System.out::println);

        // uncomment to see all loaded beans
//        Arrays.sort(beanNames);
//        for (String beanName : beanNames) {
//            System.out.println(beanName + " - " + context.getBean(beanName).getClass());
//        }


        // ------------

        System.out.println(">>>>>>>>>>>> add custom logic here");
        testRacer();

        testEvent();
    }

    private void testRacer() {

        racerService.createRacer("Test", "Test", 18);
        racerService.createRacer("Test1", "Test1", 18);
        racerService.createRacer("Test2", "Test2", 18);

        racerService.getAllRacers().stream().forEach(el -> System.out.println(el));
    }

    private void testEvent() {
        // Create a test track
        Track testTrack = new Track(1, "Speedway", 5000);

        // Create test teams and racers
        Racer racer1 = new Racer("John", "Doe", 28);
        Racer racer2 = new Racer("Jane", "Doe", 25);
        List<Racer> team1Racers = Arrays.asList(racer1, racer2);
        team1Racers.stream().forEach(team -> team.setId(TeamSequence.getNextValue()));

        Team team1 = new Team("Team Lightning", Arrays.asList(racer1, racer2));

        Racer racer3 = new Racer("Mike", "Smith", 30);
        Racer racer4 = new Racer("Sarah", "Jones", 27);
        List<Racer> team2Racers = Arrays.asList(racer3, racer4);
        team2Racers.stream().forEach(team -> team.setId(TeamSequence.getNextValue()));

        Team team2 = new Team("Team Thunder", Arrays.asList(racer3, racer4));

        // Prepare a list of teams for the event
        List<Team> testTeams = Arrays.asList(team1, team2);

        // Specify the date and time for the event
        LocalDateTime dateOfEvent = LocalDateTime.of(2024, 3, 21, 15, 0); // 21st March 2024, 3:00 PM

        // Create event
        eventService.createEvent("Spring Grand Prix", testTrack, testTeams, dateOfEvent);

        // Print all events
        eventService.getAllEvents().stream().forEach(System.out::println);

        // get event after/before LocalDateTime.of(2023, 12, 1, 1, 1)
        System.out.println(eventService.getAllEventsAfter(LocalDateTime.of(2023, 12, 1, 1, 1)));

        System.out.println(eventService.getAllEventsBefore(LocalDateTime.of(2023, 12, 1, 1, 1)));

        System.out.println(eventService.getAllRacersForNearestEvent());
    }
}

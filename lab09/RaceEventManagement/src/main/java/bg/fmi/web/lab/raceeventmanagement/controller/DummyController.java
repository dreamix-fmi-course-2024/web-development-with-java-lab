package bg.fmi.web.lab.raceeventmanagement.controller;

import bg.fmi.web.lab.raceeventmanagement.model.Racer;
import bg.fmi.web.lab.raceeventmanagement.model.Team;
import bg.fmi.web.lab.raceeventmanagement.model.Track;
import bg.fmi.web.lab.raceeventmanagement.repository.sequence.TeamSequence;
import bg.fmi.web.lab.raceeventmanagement.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class DummyController {
    @Autowired
    EventService eventService;

    // @PathVariable -> .../{id}
    // @RequestParam -> ...?{id}

    @GetMapping("/pathVariable/{id}")
    public String getSomethingWithPathVar(@PathVariable Integer id) {
        return "pathVariable";
    }

    @GetMapping("/requestParam")
    public String getSomethingWithQuery(@RequestParam("id") Integer id) {
        return "pathVariable";
    }

    @PostMapping
    public void fakeMethod() {
        testEvent();
    }

    @GetMapping
    public String getCar(@RequestParam("cvqt") String color) {
        if (color.equals("red")) {
            return "ferrari";
        } else {
            return "opel";
        }
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

//        System.out.println(eventService.getAllRacersForNearestEvent());
    }

//    @GetMapping("/something")
//    public String getSomething() {
//        return "aaa";
//    }
}

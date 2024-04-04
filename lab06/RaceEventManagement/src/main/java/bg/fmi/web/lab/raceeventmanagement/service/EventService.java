package bg.fmi.web.lab.raceeventmanagement.service;

import bg.fmi.web.lab.raceeventmanagement.model.Event;
import bg.fmi.web.lab.raceeventmanagement.model.Racer;
import bg.fmi.web.lab.raceeventmanagement.model.Team;
import bg.fmi.web.lab.raceeventmanagement.model.Track;
import bg.fmi.web.lab.raceeventmanagement.repository.EventRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingLong;

/**
 * While implementing all functions you can introduce additional functionalities inside the repository class
 */
@Service
public class EventService {

    private EventRepository eventRepository = new EventRepository();

    public List<Event> getAllEvents() {
        return eventRepository.getAllEvents();
    }

    public List<Racer> getAllRacersByTrackName(String trackName) {
        if (trackName == null || trackName.isBlank()) {
            return null;
        }

        List<Event> events = getAllEvents();
        return events == null || events.isEmpty()
                ? null
                : events.stream()
                .filter(e -> e.getTrack().getName().equals(trackName))
                .map(Event::getTeams) // output: Stream<List<Team>>
                .flatMap(List::stream) // output: Stream<Team>
                .map(Team::getRacers) // output: Stream<List<Racer>>
                .flatMap(List::stream) // output: Stream<Racer>
                .distinct()
                .collect(Collectors.toList());
    }

    public void createEvent(String name, Track track, List<Team> teams, LocalDateTime dateOfEvent) {
        eventRepository.addEvent(new Event(name, track, teams, dateOfEvent));
    }

    public boolean deleteEventById(Integer id) {
        return eventRepository.deleteEventById(id);
    }

    public List<Event> getAllEventsBefore(LocalDateTime date) {
        List<Event> events = getAllEvents();
        return events == null || events.isEmpty()
                ? null
                : events.stream()
                    .filter(el -> el.getDateOfEvent().isBefore(date))
                    .toList();
    }

    public List<Event> getAllEventsAfter(LocalDateTime date) {
        List<Event> events = getAllEvents();
        return events == null || events.isEmpty()
                ? null
                : events.stream()
                .filter(el -> el.getDateOfEvent().isAfter(date))
                .toList();
    }

    public List<Event> getUpcomingEvents() {
        return getAllEventsAfter(LocalDateTime.now(Clock.systemUTC()));
    }

    /**
     * Get all racers from the nearest event (timely manner)
     * @return
     */
    public List<Racer> getAllRacersForNearestEvent() {
        List<Event> events = getAllEvents();

        // sometimes its better to use the old style if-for
//        List<Racer> racers = new ArrayList<>();
//        Optional<Event> nearestEvent = events.stream()
//                .min(comparingLong(e -> Math.abs(Duration.between(e.getDateOfEvent(), LocalDateTime.now(ZoneOffset.UTC)).toMinutes())));
//        if (nearestEvent.isPresent()) {
//            for (Team team : nearestEvent.get().getTeams()) {
//                racers.addAll(team.getRacers());
//            }
//        }
//
//        return racers;

        return events == null || events.isEmpty()
                ? null
                : events.stream()
                    .min(comparingLong(e -> Math.abs(Duration.between(e.getDateOfEvent(), LocalDateTime.now(ZoneOffset.UTC)).toMinutes())))
                    .map(Event::getTeams)
                    .filter(Objects::nonNull)
                    .stream().flatMap(List::stream)
                    .flatMap(team -> team.getRacers().stream())
                    .collect(Collectors.toList());
    }

    public List<Event> getEventsForTrack(Track track) {
        if (track == null || track.getId() == null) {
            throw new IllegalArgumentException("Missing input field");
//            return null;
        }

        List<Event> events = getAllEvents();
        return events == null || events.isEmpty()
                ? null
                : events.stream()
                    .filter(el -> el.getTrack().getId().equals(track.getId()))
                    .toList();
    }
}
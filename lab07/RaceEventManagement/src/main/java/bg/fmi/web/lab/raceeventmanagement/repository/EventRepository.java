package bg.fmi.web.lab.raceeventmanagement.repository;


import bg.fmi.web.lab.raceeventmanagement.model.Event;
import bg.fmi.web.lab.raceeventmanagement.repository.sequence.EventSequence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EventRepository {

    private Map<Integer, Event> eventTable = new HashMap<>();

    /**
     * Add event to your DB
     * @param event
     */
    public void addEvent(Event event) {
        if (event.getId() != null) {
            throw new IllegalArgumentException("Cannot create Event with already given ID.");
        }
        event.setId(EventSequence.getNextValue());

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

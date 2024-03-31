package bg.fmi.web.lab.raceeventmanagement.repository;

import bg.fmi.web.lab.raceeventmanagement.model.Track;
import bg.fmi.web.lab.raceeventmanagement.repository.sequence.RaceSequence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class TrackRepository {

    private Map<Integer, Track> trackMapTable = new HashMap<>();

    /**
     * Add track to your DB. If the track is already present throw Custom Exception
     * @param track
     */
    public void addTrack(Track track) {
//        // if you are responsible for the id generation (not so frequently usable)
//        if (trackMapTable.containsKey(track.getId())) {
//            throw new RuntimeException("Id already existed");
//        }

        if (track.getId() != null) {
            throw new IllegalArgumentException("Cannot create Track with already given ID.");
        }
        track.setId(RaceSequence.getNextValue());

        trackMapTable.put(track.getId(), track);
    }

    /**
     * Delete track by name. If there is no element to be deleted then return false;
     * @param name
     * @return if there is element to delete -> true, if not -> false
     */
    public boolean deleteTrackByName(String name) {
        return trackMapTable.remove(name) == null ? false : true;
    }

    /**
     * Get track by passed id. If there is no element return Optional empty.
     * @param id
     * @return Optional of Track
     */
    public Optional<Track> getTrackById(Integer id) {
        return Optional.of(trackMapTable.get(id));
    }

    /**
     * Get all tracks
     * @return
     */
    public List<Track> getAllTracks() {
        return trackMapTable.values().stream().collect(Collectors.toList());
    }
}

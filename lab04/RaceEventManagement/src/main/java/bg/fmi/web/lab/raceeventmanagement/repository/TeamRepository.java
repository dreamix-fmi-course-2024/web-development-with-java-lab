package bg.fmi.web.lab.raceeventmanagement.repository;

import bg.fmi.web.lab.raceeventmanagement.model.Team;
import bg.fmi.web.lab.raceeventmanagement.model.Track;
import bg.fmi.web.lab.raceeventmanagement.repository.sequence.RaceSequence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class TeamRepository {
    private Map<String, Team> teamTable = new HashMap<>();

    /**
     * Add team to your DB. If the Team is already present throw Custom Exception
     * @param team
     */
    public void addTeam(Team team) {
        if (teamTable.containsKey(team.getName())) {
            throw new RuntimeException("asdasd");
        }
        teamTable.put(team.getName(), team);
    }

    /**
     * Delete team by name. If there is no element to be deleted then return false;
     * @param name
     * @return if there is element to delete -> true, if not -> false
     */
    public boolean deleteTeamByName(String name) {
        return teamTable.remove(name) == null ? false : true;
    }

    /**
     * Get team by passed name. If there is no element return Optional empty. The search is case-insensitive
     * @param name
     * @return Optional of Team
     */
    public Optional<Team> getTeamByName(String name) {
        return Optional.of(teamTable.get(name));
    }

    /**
     * Get all teams
     * @return
     */
    public List<Team> getAllTeams() {
        return teamTable.values().stream().collect(Collectors.toList());
    }

}

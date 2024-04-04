package bg.fmi.web.lab.raceeventmanagement.repository.sequence;

public class TeamSequence {
    private static Integer sequence = 1000;

    public static Integer getNextValue() {
        return sequence++;
    }
}

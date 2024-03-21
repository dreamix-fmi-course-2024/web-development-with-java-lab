package bg.fmi.web.lab.raceeventmanagement.repository.sequence;

public class TrackSequence {
    private static Integer sequence = 1000;

    public static Integer getNextValue() {
        return sequence++;
    }
}

package bg.fmi.javacourse2024.repository;

public class RaceSequence {
    private static Integer sequence = 1000;

    public static Integer getNextValue() {
        return sequence++;
    }
}

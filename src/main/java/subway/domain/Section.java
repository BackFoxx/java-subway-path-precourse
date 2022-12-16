package subway.domain;

import java.util.Objects;

public class Section {
    private final Station firstStation;
    private final Station lastStation;
    private final int km;
    private final int minute;

    public Section(Station firstStation, Station lastStation, int km, int minute) {
        this.firstStation = firstStation;
        this.lastStation = lastStation;
        this.km = km;
        this.minute = minute;
    }

    @Override
    public String toString() {
        return "Section{" +
                "startStation=" + firstStation +
                ", endStation=" + lastStation +
                ", km=" + km +
                ", minute=" + minute +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Section section = (Section) o;
        return km == section.km && minute == section.minute &&
                firstStation.equals(section.firstStation) &&
                lastStation.equals(section.lastStation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstStation, lastStation, km, minute);
    }

    public Station getFirstStation() {
        return firstStation;
    }

    public Station getLastStation() {
        return lastStation;
    }

    public int getKm() {
        return km;
    }

    public int getMinute() {
        return minute;
    }

    public boolean isFirstStation(Station firstStation) {
        return this.firstStation.equals(firstStation);
    }

    public boolean isLastStation(Station lastStation) {
        return this.lastStation.equals(lastStation);
    }
}

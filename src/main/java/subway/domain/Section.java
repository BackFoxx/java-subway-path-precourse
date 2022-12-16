package subway.domain;

import java.util.Objects;

public class Section {
    private final Station startStation;
    private final Station endStation;
    private final int km;
    private final int minute;

    public Section(Station startStation, Station endStation, int km, int minute) {
        this.startStation = startStation;
        this.endStation = endStation;
        this.km = km;
        this.minute = minute;
    }

    @Override
    public String toString() {
        return "Section{" +
                "startStation=" + startStation +
                ", endStation=" + endStation +
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
        return km == section.km && minute == section.minute && startStation.equals(section.startStation) && endStation.equals(section.endStation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startStation, endStation, km, minute);
    }
}

package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();
    public static final String STATION_NAME_NOT_EXISTING = "존재하지 않는 역 이름입니다.";

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static void deleteAll() {
        stations.clear();
    }

    public static Station findByName(String firstStationName) {
        return stations.stream()
                .filter(station -> station.isName(firstStationName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(STATION_NAME_NOT_EXISTING));
    }

    public static List<Station> findAll() {
        return Collections.unmodifiableList(stations);
    }
}

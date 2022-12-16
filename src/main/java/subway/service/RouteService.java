package subway.service;

import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.util.ShortestPathMaker;
import subway.vo.PathResponse;

import java.util.List;

public class RouteService {

    public static final String SAME_FIRST_LAST_STATION_EXCEPTION = "출발역과 도착역이 동일합니다.";

    public static PathResponse countRouteByDistance(Station firstStation, Station lastStation) {
        Validator.validateOnCountingRoute(firstStation, lastStation);
        return ShortestPathMaker.getShortestPathByDistance(firstStation, lastStation);
    }

    public static PathResponse countRouteByTime(Station firstStation, Station lastStation) {
        Validator.validateOnCountingRoute(firstStation, lastStation);
        return ShortestPathMaker.getShortestPathByTime(firstStation, lastStation);
    }

    public static int countTotalMinutesOf(List<Station> stations) {
        int totalMinute = 0;
        for (int index = 0; index < stations.size() - 1; index++) {
            totalMinute += SectionRepository.findMinuteByFirstAndLastStation(
                    stations.get(index),
                    stations.get(index + 1)
            );
        }
        return totalMinute;
    }

    public static int countTotalKmsOf(List<Station> stations) {
        int totalKms = 0;
        for (int index = 0; index < stations.size() - 1; index++) {
            totalKms += SectionRepository.findKmByFirstAndLastStation(
                    stations.get(index),
                    stations.get(index + 1)
            );
        }
        return totalKms;
    }

    private static class Validator {
        public static void validateOnCountingRoute(Station firstStation, Station lastStation) {
            if (firstStation.equals(lastStation)) {
                throw new IllegalArgumentException(SAME_FIRST_LAST_STATION_EXCEPTION);
            }
        }
    }
}

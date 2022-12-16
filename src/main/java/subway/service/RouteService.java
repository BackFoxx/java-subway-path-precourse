package subway.service;

import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.util.ShortestPathMaker;
import subway.vo.PathResponse;

import java.util.List;

public class RouteService {
    public static PathResponse countRouteByDistance(Station firstStation, Station lastStation) {
        return ShortestPathMaker.getShortestPath(firstStation, lastStation);
    }

    public static int countMinutesOf(List<Station> stationNames) {
        int totalMinute = 0;
        for (int index = 0; index < stationNames.size() - 1; index++) {
            totalMinute += SectionRepository.findMinuteByFirstAndLastStation(
                    stationNames.get(index),
                    stationNames.get(index + 1)
            );
        }
        return totalMinute;
    }
}

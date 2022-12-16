package subway.vo;

import subway.domain.Station;

import java.util.Collections;
import java.util.List;

public class PathResponse {
    private final List<Station> shortestPath;
    private final double distance;

    public PathResponse(List<Station> shortestPath, double distance) {
        this.shortestPath = Collections.unmodifiableList(shortestPath);
        this.distance = distance;
    }

    public List<Station> getShortestPath() {
        return shortestPath;
    }

    public int getDistance() {
        return (int) distance;
    }
}

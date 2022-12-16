package subway.util;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Section;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.vo.PathResponse;
import subway.vo.Standard;

import java.util.List;

public class ShortestPathMaker {

    public static final String STATIONS_NOT_CONNECTED = "출발역과 도착역이 연결되지 않았습니다.";

    public static PathResponse getShortestPathByDistance(Station firstStation, Station lastStation) {
        DijkstraShortestPath dijkstraShortestPath = getShortestPathMaker(Standard.DISTANCE);
        return getPathResponse(firstStation, lastStation, dijkstraShortestPath);
    }

    public static PathResponse getShortestPathByTime(Station firstStation, Station lastStation) {
        DijkstraShortestPath dijkstraShortestPath = getShortestPathMaker(Standard.TIME);
        return getPathResponse(firstStation, lastStation, dijkstraShortestPath);
    }

    private static PathResponse getPathResponse(Station firstStation, Station lastStation, DijkstraShortestPath dijkstraShortestPath) {
        double distance = dijkstraShortestPath.getPathWeight(firstStation, lastStation);
        List<Station> shortestPath = getShortestPath(firstStation, lastStation, dijkstraShortestPath);
        return new PathResponse(shortestPath, distance);
    }

    private static List<Station> getShortestPath(Station firstStation,
                                                Station lastStation,
                                                DijkstraShortestPath dijkstraShortestPath) {
        try {
            return dijkstraShortestPath.getPath(firstStation, lastStation).getVertexList();
        } catch (NullPointerException e) {
            throw new IllegalArgumentException(STATIONS_NOT_CONNECTED);
        }
    }

    private static DijkstraShortestPath getShortestPathMaker(Standard distance) {
        List<Section> sections = SectionRepository.findAll();

        WeightedMultigraph<Station, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
        addVertexes(graph);
        setEdgeWeights(distance, sections, graph);

        return new DijkstraShortestPath(graph);
    }

    private static void setEdgeWeights(Standard distance,
                                       List<Section> sections,
                                       WeightedMultigraph<Station, DefaultWeightedEdge> graph) {
        if (distance == Standard.DISTANCE) {
            setEdgeWeightsByDistance(sections, graph);
        }
        if (distance == Standard.TIME) {
            setEdgeWeightsByTime(sections, graph);
        }
    }

    private static void setEdgeWeightsByDistance(List<Section> sections,
                                                 WeightedMultigraph<Station, DefaultWeightedEdge> graph) {
        for (Section section : sections) {
            graph.setEdgeWeight(makeEdge(graph, section), section.getKm());
        }
    }

    private static void setEdgeWeightsByTime(List<Section> sections,
                                             WeightedMultigraph<Station, DefaultWeightedEdge> graph) {
        for (Section section : sections) {
            graph.setEdgeWeight(makeEdge(graph, section), section.getMinute());
        }
    }

    private static DefaultWeightedEdge makeEdge(WeightedMultigraph<Station, DefaultWeightedEdge> graph,
                                                Section section) {
        return graph.addEdge(section.getFirstStation(), section.getLastStation());
    }

    private static void addVertexes(WeightedMultigraph<Station, DefaultWeightedEdge> graph) {
        List<Station> allStations = StationRepository.findAll();
        for (Station station : allStations) {
            graph.addVertex(station);
        }
    }
}

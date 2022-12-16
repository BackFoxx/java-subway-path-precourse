package subway.util;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Section;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.vo.PathResponse;

import java.util.List;

public class ShortestPathMaker {
    public static PathResponse getShortestPath(Station firstStation, Station lastStation) {
        DijkstraShortestPath dijkstraShortestPath = getShortestPathMaker();

        double distance = dijkstraShortestPath.getPathWeight(firstStation, lastStation);
        List<Station> shortestPath = getShortestPath(firstStation, lastStation, dijkstraShortestPath);

        return new PathResponse(shortestPath, distance);
    }

    private static List<Station> getShortestPath(Station firstStation,
                                                Station lastStation,
                                                DijkstraShortestPath dijkstraShortestPath) {
        return dijkstraShortestPath.getPath(firstStation, lastStation).getVertexList();
    }

    private static DijkstraShortestPath getShortestPathMaker() {
        List<Section> sections = SectionRepository.findAll();
        WeightedMultigraph<Station, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
        addVertexes(graph);
        setEdgeWeights(sections, graph);

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        return dijkstraShortestPath;
    }

    private static void setEdgeWeights(List<Section> sections, WeightedMultigraph<Station, DefaultWeightedEdge> graph) {
        for (Section section : sections) {
            graph.setEdgeWeight(makeEdge(graph, section), section.getKm());
        }
    }

    private static DefaultWeightedEdge makeEdge(WeightedMultigraph<Station, DefaultWeightedEdge> graph, Section section) {
        return graph.addEdge(section.getFirstStation(), section.getLastStation());
    }

    private static void addVertexes(WeightedMultigraph<Station, DefaultWeightedEdge> graph) {
        List<Station> allStations = StationRepository.findAll();
        for (Station station : allStations) {
            graph.addVertex(station);
        }
    }
}

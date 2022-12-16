package subway.controller;

import subway.controller.system.AbstractController;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.inputview.RouteInputView;
import subway.outputview.RouteOutputView;
import subway.service.RouteService;
import subway.util.ReaderHolder;
import subway.vo.PathResponse;

import java.util.List;
import java.util.stream.Collectors;

public class RouteByDistanceController extends AbstractController {
    @Override
    public void doProcess() {
        Station firstStation = getFirstStation();
        Station lastStation = getLastStation();

        PathResponse pathResponse = RouteService.countRouteByDistance(firstStation, lastStation);

        printRouteResult(pathResponse);
    }

    private static void printRouteResult(PathResponse pathResponse) {
        List<Station> shortestPath = pathResponse.getShortestPath();

        List<String> stationNames = shortestPath
                .stream().map(Station::getName)
                .collect(Collectors.toList());
        int km = pathResponse.getDistance();
        int minute = RouteService.countTotalMinutesOf(shortestPath);

        RouteOutputView.printRouteResult(stationNames, km, minute);
    }

    private Station getLastStation() {
        RouteOutputView.printAskingLastStation();
        String lastStationName = RouteInputView.getStationName(ReaderHolder.getReader());
        return StationRepository.findByName(lastStationName);
    }

    private static Station getFirstStation() {
        RouteOutputView.printAskingStartingStation();
        String firstStationName = RouteInputView.getStationName(ReaderHolder.getReader());
        return StationRepository.findByName(firstStationName);
    }
}

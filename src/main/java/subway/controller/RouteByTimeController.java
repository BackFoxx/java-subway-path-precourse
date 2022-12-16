package subway.controller;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.inputview.RouteInputView;
import subway.outputview.RouteOutputView;
import subway.service.RouteService;
import subway.system.ReaderHolder;
import subway.vo.PathResponse;

import java.util.List;
import java.util.stream.Collectors;

public class RouteByTimeController extends AbstractController {
    @Override
    public void doProcess() {
        Station firstStation = getFirstStation();
        Station lastStation = getLastStation();

        PathResponse pathResponse = RouteService.countRouteByTime(firstStation, lastStation);

        printRouteResult(pathResponse);
    }

    private static void printRouteResult(PathResponse pathResponse) {
        List<Station> shortestPath = pathResponse.getShortestPath();

        List<String> stationNames = shortestPath
                .stream().map(Station::getName)
                .collect(Collectors.toList());
        int km = RouteService.countTotalKmsOf(shortestPath);
        int minute = pathResponse.getDistance();

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

package subway.controller;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.inputview.RouteInputView;
import subway.outputview.RouteOutputView;
import subway.system.ReaderHolder;

public class RouteByDistanceController extends AbstractController {
    @Override
    public void doProcess() {
        Station firstStation = getFirstStation();
        Station lastStation = getLastStation();
//        RouteService.countRouteByDistance(firstStation, lastStation);
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

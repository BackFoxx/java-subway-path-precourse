package subway.controller;

import subway.controller.system.AbstractController;
import subway.domain.*;

import java.util.List;

public class SetupController extends AbstractController {
    @Override
    public void doProcess() {
        saveStations(List.of("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"));
        saveLines(List.of("2호선", "3호선", "신분당선"));

        saveSectionsOnLine2();
        saveSectionsOnLine3();
        saveSectionOnLineSin();
    }

    private static void saveSectionOnLineSin() {
        saveSection("신분당선", "강남역", "양재역", 2, 8);
        saveSection("신분당선", "양재역", "양재시민의숲역", 10, 3);
    }

    private static void saveSectionsOnLine3() {
        saveSection("3호선", "교대역", "남부터미널역", 3, 2);
        saveSection("3호선", "남부터미널역", "양재역", 6, 5);
        saveSection("3호선", "양재역", "매봉역", 1, 1);
    }

    private static void saveSectionsOnLine2() {
        saveSection("2호선", "교대역", "강남역", 2, 3);
        saveSection("2호선", "강남역", "역삼역", 2, 3);
    }

    private static void saveSection(String lineName,
                                    String startStationName, String endStationName,
                                    int km, int minute) {
        SectionRepository.addSection(new Line(lineName),
                new Section(
                        new Station(startStationName),
                        new Station(endStationName),
                        km,
                        minute
                ));
    }

    private void saveLines(List<String> lineNames) {
        for (String lineName : lineNames) {
            LineRepository.addLine(new Line(lineName));
        }
    }

    private static void saveStations(List<String> stationNames) {
        for (String stationName : stationNames) {
            StationRepository.addStation(new Station(stationName));
        }
    }
}

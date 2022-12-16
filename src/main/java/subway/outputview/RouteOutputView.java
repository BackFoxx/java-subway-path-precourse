package subway.outputview;

import java.util.List;

public class RouteOutputView {

    public static final String ASKING_STARTING_STATION = "## 출발역을 입력하세요.";
    public static final String ASKING_ENDING_STATION = "## 도착역을 입력하세요.";
    public static final String RESULT_MESSAGE = "## 조회 결과";
    public static final String INFO_FORMAT = "[INFO] %s%n";
    public static final String TOTAL_DISTANCE_FORMAT = "총 거리: %dkm";
    public static final String TOTAL_MINUTE_FORMAT = "총 소요 시간: %d분";
    public static final String LINE_SEPARATOR = "---";

    public static void printAskingStartingStation() {
        System.out.println();
        System.out.println(ASKING_STARTING_STATION);
    }

    public static void printAskingLastStation() {
        System.out.println();
        System.out.println(ASKING_ENDING_STATION);
    }

    public static void printRouteResult(List<String> stationNames, int km, int minute) {
        printResultMessage();
        printDistanceAndTime(km, minute);
        printStationNames(stationNames);
    }

    private static void printDistanceAndTime(int km, int minute) {
        printSmallLineSeparator();
        System.out.printf(INFO_FORMAT, String.format(TOTAL_DISTANCE_FORMAT, km));
        System.out.printf(INFO_FORMAT, String.format(TOTAL_MINUTE_FORMAT, minute));
        printSmallLineSeparator();
    }

    private static void printStationNames(List<String> stationNames) {
        for (String stationName : stationNames) {
            System.out.printf(INFO_FORMAT, stationName);
        }
    }

    private static void printResultMessage() {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
    }

    private static void printSmallLineSeparator() {
        System.out.printf(INFO_FORMAT, String.format(LINE_SEPARATOR));
    }
}

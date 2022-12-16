package subway.outputview;

public class RouteOutputView {

    public static final String ASKING_STARTING_STATION = "## 출발역을 입력하세요.";
    public static final String ASKING_ENDING_STATION = "## 도착역을 입력하세요.";

    public static void printAskingStartingStation() {
        System.out.println();
        System.out.println(ASKING_STARTING_STATION);
    }

    public static void printAskingLastStation() {
        System.out.println();
        System.out.println(ASKING_ENDING_STATION);
    }
}

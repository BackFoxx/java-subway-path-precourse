package subway.system;

import subway.controller.ControllerHolder;
import subway.vo.ControllerName;

import java.util.Scanner;

public class SubwayApplication {
    private final Scanner scanner;

    public SubwayApplication(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        ControllerHolder.get(ControllerName.SETUP).process();
    }
}

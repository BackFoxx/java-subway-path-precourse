package subway.controller.system;

import subway.controller.*;
import subway.vo.ControllerName;

import java.util.HashMap;
import java.util.Map;

public class ControllerHolder {
    private static final Map<ControllerName, Controller> controllers = new HashMap<>();

    static {
        controllers.put(ControllerName.SETUP, new SetupController());
        controllers.put(ControllerName.MAIN, new MainController());
        controllers.put(ControllerName.STANDARD, new SelectingStandardController());
        controllers.put(ControllerName.ROUTE_BY_DISTANCE, new RouteByDistanceController());
        controllers.put(ControllerName.ROUTE_BY_TIME, new RouteByTimeController());
    }

    public static Controller get(ControllerName controllerName) {
        return controllers.get(controllerName);
    }
}

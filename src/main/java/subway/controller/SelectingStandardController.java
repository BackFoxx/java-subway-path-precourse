package subway.controller;

import subway.inputview.StandardInputView;
import subway.outputview.StandardOutputView;
import subway.system.ReaderHolder;
import subway.vo.ControllerName;
import subway.vo.command.StandardCommand;

public class SelectingStandardController extends AbstractController {
    @Override
    public void doProcess() {
        StandardOutputView.printCommands();
        StandardCommand command = StandardInputView.getCommand(ReaderHolder.getReader());
        findRouteByDistance(command);
        if (command == StandardCommand.TIME) {
            ControllerHolder.get(ControllerName.ROUTE_BY_TIME).process();
        }
    }

    private static void findRouteByDistance(StandardCommand command) {
        if (command == StandardCommand.DISTANCE) {
            ControllerHolder.get(ControllerName.ROUTE_BY_DISTANCE).process();
        }
    }
}

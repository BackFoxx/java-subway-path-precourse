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
        if (command == StandardCommand.DISTANCE) {
            ControllerHolder.get(ControllerName.ROUTE_BY_DISTANCE).process();
        }
        if (command == StandardCommand.TIME) {

        }
    }
}

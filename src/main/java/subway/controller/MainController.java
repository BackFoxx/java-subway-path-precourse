package subway.controller;

import subway.controller.system.AbstractController;
import subway.controller.system.ControllerHolder;
import subway.inputview.MainInputView;
import subway.outputview.MainOutputView;
import subway.util.ReaderHolder;
import subway.vo.ControllerName;
import subway.vo.command.MainCommand;

public class MainController extends AbstractController {
    @Override
    public void doProcess() {
        MainCommand command;
        do {
            MainOutputView.printCommands();
            command = MainInputView.getCommand(ReaderHolder.getReader());
            if (command == MainCommand.FIND) {
                ControllerHolder.get(ControllerName.STANDARD).process();
            }
        } while (command != MainCommand.QUIT);
    }
}

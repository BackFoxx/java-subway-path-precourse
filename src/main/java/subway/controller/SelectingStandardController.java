package subway.controller;

import subway.inputview.StandardInputView;
import subway.outputview.StandardOutputView;
import subway.system.ReaderHolder;
import subway.vo.command.StandardCommand;

public class SelectingStandardController extends AbstractController {
    @Override
    public void doProcess() {
        StandardOutputView.printCommands();
        StandardCommand command = StandardInputView.getCommand(ReaderHolder.getReader());
    }
}

package subway.controller;

import subway.outputview.ErrorMessageOutputView;

public abstract class AbstractController implements Controller {
    @Override
    public void process() {
        try {
            doProcess();
        } catch (IllegalArgumentException e) {
            ErrorMessageOutputView.printErrorMessage(e.getMessage());
            process();
        }
    }

    public abstract void doProcess();
}

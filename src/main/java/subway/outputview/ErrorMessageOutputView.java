package subway.outputview;

import static subway.vo.OutputConstant.ERROR_MESSAGE_FORMAT;

public class ErrorMessageOutputView {
    public static void printErrorMessage(String errorMessage) {
        System.out.printf(ERROR_MESSAGE_FORMAT, errorMessage);
    }
}

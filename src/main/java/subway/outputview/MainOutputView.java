package subway.outputview;

import subway.vo.command.MainCommand;

import static subway.vo.OutputConstant.COMMAND_FORMAT;

public class MainOutputView {

    public static final String MENU_MESSAGE = "## 메인 화면";
    public static final String ASKING_COMMAND_MESSAGE = "## 원하는 기능을 선택하세요.";

    public static void printCommands() {
        printMainMessage();
        printMainCommands();
        printAskingCommandMessage();
    }

    private static void printMainCommands() {
        for (MainCommand mainCommand : MainCommand.values()) {
            System.out.printf(COMMAND_FORMAT, mainCommand.getCommand(), mainCommand.getDescription());
        }
    }

    private static void printAskingCommandMessage() {
        System.out.println();
        System.out.println(ASKING_COMMAND_MESSAGE);
    }

    private static void printMainMessage() {
        System.out.println();
        System.out.println(MENU_MESSAGE);
    }
}

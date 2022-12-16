package subway.outputview;

import subway.vo.command.StandardCommand;

public class StandardOutputView {

    public static final String ASKING_COMMAND_MESSAGE = "## 원하는 기능을 선택하세요.";
    public static final String MENU_MESSAGE = "## 경로 기준";

    public static void printCommands() {
        printMainMessage();
        printStandardCommands();
        printAskingCommandMessage();
    }

    private static void printStandardCommands() {
        for (StandardCommand standardCommand : StandardCommand.values()) {
            System.out.printf("%s. %s%n", standardCommand.getCommand(), standardCommand.getDescription());
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

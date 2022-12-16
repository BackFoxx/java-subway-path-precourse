package subway.vo.command;

import java.util.Arrays;

public enum MainCommand {
    FIND("1", "경로 조회"),
    QUIT("Q", "종료");

    public static final String INVALID_COMMAND_VALUE = "잘못된 커멘드 입력입니다.";
    private final String command;
    private final String description;

    MainCommand(String command, String description) {
        this.command = command;
        this.description = description;
    }

    public static MainCommand findByCommand(String command) {
        return Arrays.stream(values())
                .filter(mainCommand -> mainCommand.command.equals(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_COMMAND_VALUE));
    }

    public String getCommand() {
        return command;
    }

    public String getDescription() {
        return description;
    }
}

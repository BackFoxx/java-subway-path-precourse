package subway.vo.command;

import java.util.Arrays;

public enum StandardCommand {
    DISTANCE("1", "최단 거리"),
    TIME("2", "최소 시간"),
    BACK("B", "돌아가기");

    public static final String INVALID_COMMAND_VALUE = "잘못된 커멘드 입력입니다.";
    private final String command;
    private final String description;

    StandardCommand(String command, String description) {
        this.command = command;
        this.description = description;
    }

    public static StandardCommand findByCommand(String command) {
        return Arrays.stream(values())
                .filter(standardCommand -> standardCommand.command.equals(command))
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

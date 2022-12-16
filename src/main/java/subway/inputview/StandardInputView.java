package subway.inputview;

import subway.vo.command.StandardCommand;

import java.util.Scanner;

public class StandardInputView {
    public static StandardCommand getCommand(Scanner reader) {
        return StandardCommand.findByCommand(reader.nextLine());
    }
}

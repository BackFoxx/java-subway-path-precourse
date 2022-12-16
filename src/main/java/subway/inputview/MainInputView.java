package subway.inputview;

import subway.vo.command.MainCommand;

import java.util.Scanner;

public class MainInputView {

    public static MainCommand getCommand(Scanner reader) {
        return MainCommand.findByCommand(reader.nextLine());
    }
}

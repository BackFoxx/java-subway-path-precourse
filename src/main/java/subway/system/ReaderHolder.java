package subway.system;

import java.util.Scanner;

public class ReaderHolder {
    public static final String SCANNER_NOT_INITIALIZED = "Scanner가 등록되지 않음.";
    private static Scanner scanner;

    public static void initializeReader(Scanner target) {
        scanner = target;
    }

    public static Scanner getReader() {
        if (scanner == null) {
            throw new IllegalStateException(SCANNER_NOT_INITIALIZED);
        }
        return scanner;
    }
}

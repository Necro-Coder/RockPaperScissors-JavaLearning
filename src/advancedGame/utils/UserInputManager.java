package advancedGame.utils;

import java.util.Scanner;

public class UserInputManager {
    private static final Scanner SCANNER;

    static {
        SCANNER = new Scanner(System.in);
    }

    public static int readInt() {
        return SCANNER.nextInt();
    }
    public static String readString() {
        return SCANNER.next();
    }
    public static void closeScanner() {
        SCANNER.close();
    }
}

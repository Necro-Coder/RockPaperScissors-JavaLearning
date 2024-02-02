package advancedGame.utils;

import org.jetbrains.annotations.NotNull;

public class Printer {
    public static void print(@NotNull String message, int speed) throws InterruptedException{
        for (char c : message.toCharArray()) {
            Thread.sleep(speed);
            System.out.print(c);
        }
    }
    public static void printLoadingDots(int times) throws InterruptedException {
        for (int i = 1; i < times + 1; i++) {
            Thread.sleep(300);
            System.out.print(".");
            if (i % 3 == 0) {
                System.out.print("\n");
            }
        }
    }
}

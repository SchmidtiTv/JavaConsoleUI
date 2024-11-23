package consoleWindow.input;

import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Get user input from the console without a prompt.
     *
     * @return The user input.
     */
    public static String getInput() {
        return scanner.nextLine();
    }

    /**
     * Get user input from the console with a prompt.
     *
     * @param text The text to display before the input.
     * @return The user input.
     */
    public static String getInput(String text) {
        System.out.print(text);
        return scanner.nextLine();
    }
}

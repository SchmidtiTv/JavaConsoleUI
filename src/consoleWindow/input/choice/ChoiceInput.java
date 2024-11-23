package consoleWindow.input.choice;

import java.util.List;
import java.util.Scanner;

public class ChoiceInput {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Single-parameter choice input.
     * @param options List of available choices.
     * @return The selected choice.
     */
    public static Choice choiceInput(List<Choice> options) {
        validateOptions(options);
        return getChoice(options);
    }

    /**
     * Choice input with a prompt.
     * @param options List of available choices.
     * @param prompt The prompt to display.
     * @return The selected choice.
     */
    public static Choice choiceInput(List<Choice> options, String prompt) {
        validateOptions(options);
        System.out.print(prompt);
        return getChoice(options);
    }

    /**
     * Choice input with optional display of choices.
     * @param options List of available choices.
     * @param showOptions Whether to display the options.
     * @return The selected choice.
     */
    public static Choice choiceInput(List<Choice> options, boolean showOptions) {
        validateOptions(options);
        if (showOptions) {
            displayOptions(options);
        }
        return getChoice(options);
    }

    /**
     * Choice input with prompt and optional display of choices.
     * @param options List of available choices.
     * @param prompt The prompt to display.
     * @param showOptions Whether to display the options.
     * @return The selected choice.
     */
    public static Choice choiceInput(List<Choice> options, String prompt, boolean showOptions) {
        validateOptions(options);
        if (showOptions) {
            displayOptions(options);
        }
        System.out.print(prompt);
        return getChoice(options);
    }

    // Helper to display options
    private static void displayOptions(List<Choice> options) {
        for (Choice option : options) {
            System.out.println(option.getInputKey() + " - " + option.getChoiceText());
        }
    }

    // Helper to validate options
    private static void validateOptions(List<Choice> options) {
        if (options == null || options.isEmpty()) {
            throw new IllegalArgumentException("Options cannot be null or empty.");
        }
    }

    // Helper to get the user choice
    private static Choice getChoice(List<Choice> options) {
        while (true) {
            String input = scanner.nextLine().trim();
            for (Choice option : options) {
                if (option.getInputKey().equalsIgnoreCase(input)) {
                    return option;
                }
            }
            System.out.print("Invalid choice, try again: ");
        }
    }
}

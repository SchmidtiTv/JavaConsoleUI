package consoleWindow.input.checkBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CheckBox {

    /**
     * Static method to display a list of checkbox options and handle user input.
     *
     * @param options The list of checkbox options to display.
     * @param prompt  A prompt to display to the user.
     * @return A list of selected checkbox options.
     */
    public static List<CheckBoxOption> input(List<CheckBoxOption> options, String prompt) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display the current state of checkbox options
            System.out.println(prompt);
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }
            System.out.println("Enter the number to toggle a checkbox, or type 'done' to finish:");

            // Get user input
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("done")) {
                break;
            }

            try {
                int index = Integer.parseInt(input) - 1;
                if (index >= 0 && index < options.size()) {
                    options.get(index).toggle();
                } else {
                    System.out.println("Invalid number, try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a number or 'done'.");
            }
        }

        // Collect and return selected options
        List<CheckBoxOption> selected = new ArrayList<>();
        for (CheckBoxOption option : options) {
            if (option.isChecked()) {
                selected.add(option);
            }
        }
        return selected;
    }
}

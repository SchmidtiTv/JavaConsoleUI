package consoleWindow.input.choice;

public class Choice {
    private final String choiceText;
    private final String key;
    private final String inputKey;

    /**
     * Constructor for a choice.
     * @param choiceText The text describing the choice.
     * @param key An internal identifier for the choice.
     * @param inputKey The key the user types to select the choice.
     */
    public Choice(String choiceText, String key, String inputKey) {
        this.choiceText = choiceText;
        this.key = key;
        this.inputKey = inputKey;
    }

    public String getChoiceText() {
        return choiceText;
    }

    public String getKey() {
        return key;
    }

    public String getInputKey() {
        return inputKey;
    }
}

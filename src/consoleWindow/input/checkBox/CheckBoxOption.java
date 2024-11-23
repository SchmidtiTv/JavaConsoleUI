package consoleWindow.input.checkBox;

public class CheckBoxOption {
    private String label;
    private boolean checked;
    private String key;

    /**
     * Constructor for a checkbox option.
     *
     * @param label   The label for the checkbox option.
     * @param key     The unique key for the option.
     * @param checked The initial state of the checkbox (checked or not).
     */
    public CheckBoxOption(String label, boolean checked, String key) {
        this.label = label;
        this.checked = checked;
        this.key = key;
    }

    public String getLabel() {
        return label;
    }

    public boolean isChecked() {
        return checked;
    }

    public String getKey() {
        return key;
    }

    public void toggle() {
        this.checked = !this.checked;
    }

    @Override
    public String toString() {
        return (checked ? "[x] " : "[ ] ") + label;
    }
}

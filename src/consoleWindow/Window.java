package consoleWindow;

public class Window {
    private int width;
    private int height;
    private StringBuilder content;

    private boolean autoSize = false;

    // Default border characters
    private String sideChar = "║";
    private String topChar = "═";
    private String bottomChar = "═";
    private String leftTopChar = "╔";
    private String rightTopChar = "╗";
    private String leftBottomChar = "╚";
    private String rightBottomChar = "╝";

    /**
     * Constructor to create a window with specified width and height.
     *
     * @param width  The width of the window.
     * @param height The height of the window.
     */
    public Window(int width, int height) {
        this.width = width;
        this.height = height;
        this.content = new StringBuilder();
    }

    /**
     * Constructor to create a window with auto-sized width and height.
     *
     * @param autoSize If true, the window will automatically adjust its size based on the content.
     */
    public Window(boolean autoSize) {
        this.autoSize = autoSize;
        this.content = new StringBuilder();
    }

    /**
     * Adds content inside the ASCII window.
     *
     * @param text The text to add inside the window.
     */
    public void addContent(String text) {
        content.append(text).append("\n");
    }

    /**
     * Customize the border characters of the window.
     *
     * @param sideChar        The character for the vertical sides.
     * @param topChar         The character for the horizontal top border.
     * @param bottomChar      The character for the horizontal bottom border.
     * @param leftTopChar     The character for the top-left corner.
     * @param rightTopChar    The character for the top-right corner.
     * @param leftBottomChar  The character for the bottom-left corner.
     * @param rightBottomChar The character for the bottom-right corner.
     */
    public void setBorder(String sideChar, String topChar, String bottomChar,
                          String leftTopChar, String rightTopChar,
                          String leftBottomChar, String rightBottomChar) {
        this.sideChar = sideChar;
        this.topChar = topChar;
        this.bottomChar = bottomChar;
        this.leftTopChar = leftTopChar;
        this.rightTopChar = rightTopChar;
        this.leftBottomChar = leftBottomChar;
        this.rightBottomChar = rightBottomChar;
    }

    /**
     * Renders the ASCII window with centered content and custom borders.
     */
    public void render() {
        if (autoSize) {
            // Calculate width based on the longest line in the content
            width = content.toString().lines().mapToInt(String::length).max().orElse(0) + 2;

            // Calculate height based on the number of lines in the content
            height = (int) content.toString().lines().count() + 2;
        }

        // Draw the top border
        System.out.println(leftTopChar + topChar.repeat(width - 2) + rightTopChar);

        // Prepare content
        String[] lines = content.toString().split("\n");

        // Render window rows
        for (int i = 0; i < height - 2; i++) {
            if (i < lines.length) {
                // Render content
                String line = lines[i];
                line = line.length() > width - 2 ? line.substring(0, width - 2) : line;
                int padding = (width - 2 - line.length()) / 2;
                System.out.println(sideChar + " ".repeat(padding) + line + " ".repeat(width - 2 - padding - line.length()) + sideChar);
            } else {
                // Render empty rows
                System.out.println(sideChar + " ".repeat(width - 2) + sideChar);
            }
        }

        // Draw the bottom border
        System.out.println(leftBottomChar + bottomChar.repeat(width - 2) + rightBottomChar);
    }
}

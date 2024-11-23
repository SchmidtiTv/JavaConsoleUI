package consoleWindow;

public class ProgressBar {
    private int total;
    private int progress;
    private int barLength;
    private char progressChar;
    private char emptyChar;
    private boolean showPercent;

    public ProgressBar(int total, int barLength, char progressChar, char emptyChar, boolean showPercent) {
        this.total = total;
        this.progress = 0;
        this.barLength = barLength;
        this.progressChar = progressChar;
        this.emptyChar = emptyChar;
        this.showPercent = showPercent;
    }

    public void updateProgress(int newProgress) {
        this.progress = Math.min(newProgress, total);
        displayProgressBar();
    }

    private void displayProgressBar() {
        int completed = (int) (((double) progress / total) * barLength);
        StringBuilder bar = new StringBuilder();
        bar.append("[");
        for (int i = 0; i < barLength; i++) {
            if (i < completed) {
                bar.append(progressChar);
            } else {
                bar.append(emptyChar);
            }
        }
        bar.append("]");
        if(showPercent) {
            int percent = (int) (((double) progress / total) * 100);
            System.out.print("\r" + bar + " " + percent + "%");
            if (progress == total) {
                System.out.print("\r" + bar + " " + percent + "%\n");
            }
        } else {
            System.out.print("\r" + bar);
            if (progress == total) {
                System.out.print("\r" + bar + "\n");
            }
        }
    }
}
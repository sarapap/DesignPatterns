package Command;

public class TogglePixelCommand implements Command {
    private Cursor cursor;

    public TogglePixelCommand(Cursor cursor) {
        this.cursor = cursor;
    }

    public void execute() {
        cursor.togglePixel();
    }
}

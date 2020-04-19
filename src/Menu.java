import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;

public interface Menu
{
    public void display(AsciiPanel gameScreen);

    public Menu userInput(KeyEvent key);

}

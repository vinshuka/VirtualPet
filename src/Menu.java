import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;

//menu interface for graphical control of virtual pet
public interface Menu
{
    public void display(AsciiPanel gameScreen);

    public Menu userInput(KeyEvent key);

}

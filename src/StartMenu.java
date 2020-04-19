import asciiPanel.AsciiPanel;
import java.awt.event.KeyEvent;

public class StartMenu implements Menu
{
    private Pet pet;
    private PetOwner owner;

    public StartMenu(Pet pet, PetOwner owner)
    {
        this.pet = pet;
        this.owner = owner;
    }

    @Override
    public void display(AsciiPanel gameScreen)
    {
        gameScreen.writeCenter("Virtual Pet Please Press Enter", 22);
    }

    @Override
    public Menu userInput(KeyEvent key)
    {
        return key.getKeyCode() == KeyEvent.VK_ENTER ? new PetMenu(this.pet, this.owner) : this;
    }
}

import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

public class HatchMenu implements Menu
{
    private Pet pet;
    private PetOwner owner;

    public HatchMenu(Pet pet, PetOwner owner)
    {
        this.pet = pet;
        this.owner = owner;
    }

    @Override
    public void display(AsciiPanel gameScreen)
    {
        gameScreen.writeCenter("Your pet " + pet.getName() + " has been born", 15);
        gameScreen.writeCenter("Press Enter to continue.", 22);
    }

    @Override
    public Menu userInput(KeyEvent key)
    {
        return key.getKeyCode() == KeyEvent.VK_ENTER ? new PetMenu(this.pet, this.owner) : this;
    }
}

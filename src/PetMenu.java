import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class PetMenu implements Menu
{
    ArrayList<String> petOptions = new ArrayList<>(Arrays.asList("1.FEED", "2.PET", "3.WASH"));

    private Pet pet;
    private PetOwner owner;

    public PetMenu(Pet pet, PetOwner owner)
    {
        this.pet = pet;
        this.owner = owner;
    }

    @Override
    public void display(AsciiPanel gameScreen)
    {
        gameScreen.writeCenter("Your pet " + pet.getName() + " has been born", 15);
        gameScreen.writeCenter(pet.status(), 16);
        gameScreen.writeCenter(petOptions.toString(), 22);
    }

    @Override
    public Menu userInput(KeyEvent key)
    {
        return key.getKeyCode() == KeyEvent.VK_1 ? new FeedMenu(this.pet, this.owner) : this;
    }
}

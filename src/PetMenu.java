import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;

//main petMenu, all other menus lead back to this root menu
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

    //display gives the pet status, the born text may be moved to a hatch screen that runs only when the player starts
    //the game the first time
    @Override
    public void display(AsciiPanel gameScreen)
    {
        gameScreen.writeCenter(pet.status(), 16);
        gameScreen.writeCenter(petOptions.toString(), 22);
    }

    @Override
    public Menu userInput(KeyEvent key)
    {
        switch(key.getKeyCode())
        {
            case KeyEvent.VK_1: return new FeedMenu(this.pet, this.owner);
            case KeyEvent.VK_2: return new Petting(this.pet, this.owner);
            case KeyEvent.VK_3: return new Wash(this.pet, this.owner);
        }
        return this;
    }
}

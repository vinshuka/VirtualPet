import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

public class Eat implements Menu
{
    private Pet pet;
    private PetOwner owner;
    private PetOwner.Food food;

    public Eat(Pet pet, PetOwner owner, PetOwner.Food food)
    {
        this.pet = pet;
        this.owner = owner;
        this.food = food;
    }

    @Override
    public void display(AsciiPanel gameScreen)
    {
        gameScreen.writeCenter(owner.feed(food), 15);
        gameScreen.writeCenter("Press Enter to return", 22);
    }

    @Override
    public Menu userInput(KeyEvent key)
    {
        return key.getKeyCode() == KeyEvent.VK_ENTER ? new PetMenu(this.pet, this.owner) : this;
    }
}

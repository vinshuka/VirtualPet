import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class FeedMenu implements Menu
{
    private Pet pet;
    private PetOwner owner;
    private ArrayList<String> foodList = new ArrayList<>(Arrays.asList("1.MEAT", "2.VEG", "3.CAKE"));

    public FeedMenu(Pet pet, PetOwner owner)
    {
        this.pet = pet;
        this.owner = owner;
    }

    @Override
    public void display(AsciiPanel gameScreen)
    {
        gameScreen.writeCenter("What would you like to feed your pet?", 15);
        gameScreen.writeCenter(foodList.toString(), 22);
    }

    @Override
    public Menu userInput(KeyEvent key)
    {
        switch(key.getKeyCode())
        {
            case KeyEvent.VK_1: return new Eat(this.pet, this.owner, PetOwner.Food.MEAT);
            case KeyEvent.VK_2: return new Eat(this.pet, this.owner, PetOwner.Food.VEG);
            case KeyEvent.VK_3: return new Eat(this.pet, this.owner, PetOwner.Food.CAKE);
        }
        return this;
    }
}

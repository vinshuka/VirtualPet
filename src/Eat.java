import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

//eat menu shows the result of feeding the pet
public class Eat implements Menu
{
    private Pet pet;
    private PetOwner owner;
    private PetOwner.Food food;
    private char[][] eatGraphic = {
            {' ','N','O','M','!'},
            {'N','O','M','!',' '},
            {' ','N','O','M','!'},
            {'N','O','M','!',' '},
    };

    public Eat(Pet pet, PetOwner owner, PetOwner.Food food)
    {
        this.pet = pet;
        this.owner = owner;
        this.food = food;
    }

    @Override
    public void display(AsciiPanel gameScreen)
    {
        for(int y = 0; y < 4; y++)
        {
            for(int x = 0; x < 5; x++)
            {
                gameScreen.write(eatGraphic[y][x], x+38, y+9);
            }
        }
        gameScreen.writeCenter(owner.feed(food), 15);
        gameScreen.writeCenter("Press Enter to return", 22);
    }

    @Override
    public Menu userInput(KeyEvent key)
    {
        return key.getKeyCode() == KeyEvent.VK_ENTER ? new PetMenu(this.pet, this.owner) : this;
    }
}

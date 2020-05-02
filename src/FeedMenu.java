import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;

//feed menu displays food options, may move the food enum from petOwner class to this class
public class FeedMenu implements Menu
{
    private Pet pet;
    private PetOwner owner;
    private ArrayList<String> foodList = new ArrayList<>(Arrays.asList("1.MEAT", "2.VEG", "3.CAKE"));
    private char[][] foodGraphic = {
            {(char)240,(char)240,(char)240,(char)240,(char)240,(char)240},
            {(char)47,(char)0,(char)0,(char)0,(char)0,(char)92},
            {(char)179,(char)70,(char)79,(char)79,(char)68,(char)179},
            {(char)179,(char)0,(char)0,(char)0,(char)0,(char)179},
            {(char)196,(char)196,(char)196,(char)196,(char)196,(char)196}
    };

    public FeedMenu(Pet pet, PetOwner owner)
    {
        this.pet = pet;
        this.owner = owner;
    }

    @Override
    public void display(AsciiPanel gameScreen, Render render)
    {
        for(int y = 0; y < 5; y++)
        {
            for(int x = 0; x < 6; x++)
            {
                gameScreen.write(foodGraphic[y][x], x+37, y+9);
            }
        }
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

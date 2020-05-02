import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

public class HatchMenu implements Menu
{
    private Pet pet;
    private PetOwner owner;
    private char[][] hatchGraphic = {
            {(char)47,(char)196,(char)196,(char)47,(char)196,(char)196,(char)92},
            {(char)179,(char)0,(char)0,(char)92,(char)0,(char)0,(char)179},
            {(char)179,(char)0,(char)0,(char)47,(char)0,(char)0,(char)179},
            {(char)179,(char)0,(char)0,(char)92,(char)0,(char)0,(char)179},
            {(char)92,(char)196,(char)196,(char)196,(char)196,(char)196,(char)47}
    };

    public HatchMenu(Pet pet, PetOwner owner)
    {
        this.pet = pet;
        this.owner = owner;
    }

    @Override
    public void display(AsciiPanel gameScreen)
    {
        for(int y = 0; y < 5; y++)
        {
            for(int x = 0; x < 7; x++)
            {
                gameScreen.write(hatchGraphic[y][x], x+38, y+8);
            }
        }
        gameScreen.writeCenter("Your pet " + pet.getName() + " has been born", 15);
        gameScreen.writeCenter("Press Enter to continue.", 22);
    }

    @Override
    public Menu userInput(KeyEvent key)
    {
        return key.getKeyCode() == KeyEvent.VK_ENTER ? new PetMenu(this.pet, this.owner) : this;
    }
}

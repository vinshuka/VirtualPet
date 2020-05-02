import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

public class Petting implements Menu
{
    private Pet pet;
    private PetOwner owner;
    private char[][] pettingGraphic = {
            {' ',(char)3,'P','E','T'},
            {'P','E','T',(char)3,' '},
            {' ',(char)3,'P','E','T'},
            {'P','E','T',(char)3,' '}
    };

    public Petting(Pet pet, PetOwner owner)
    {
        this.pet = pet;
        this.owner = owner;
    }

    @Override
    public void display(AsciiPanel gameScreen, Render render)
    {
        for(int y = 0; y < 4; y++)
        {
            for(int x = 0; x < 5; x++)
            {
                gameScreen.write(pettingGraphic[y][x], x+38, y+9);
            }
        }
        gameScreen.writeCenter(owner.pet(), 15);
        gameScreen.writeCenter("Press Enter to return", 22);
    }

    @Override
    public Menu userInput(KeyEvent key)
    {
        return key.getKeyCode() == KeyEvent.VK_ENTER ? new PetMenu(this.pet, this.owner) : this;
    }
}

import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

public class Wash implements Menu
{
    private Pet pet;
    private PetOwner owner;
    private char[][] washGraphic = {
            {' ',(char)248,'S','C','R','U','B',(char)15},
            {(char)15,'S','C','R','U','B',(char)248,' '},
            {' ',(char)248,'S','C','R','U','B',(char)15},
            {(char)15,'S','C','R','U','B',(char)248,' '}
    };

    public Wash(Pet pet, PetOwner owner)
    {
        this.pet = pet;
        this.owner = owner;
    }

    @Override
    public void display(AsciiPanel gameScreen)
    {
        for(int y = 0; y < 4; y++)
        {
            for(int x = 0; x < 8; x++)
            {
                gameScreen.write(washGraphic[y][x], x+38, y+9);
            }
        }
        gameScreen.writeCenter(owner.wash(), 15);
        gameScreen.writeCenter("Press Enter to return", 22);
    }

    @Override
    public Menu userInput(KeyEvent key)
    {
        return key.getKeyCode() == KeyEvent.VK_ENTER ? new PetMenu(this.pet, this.owner) : this;
    }
}

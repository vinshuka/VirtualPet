import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

//main petMenu, all other menus lead back to this root menu
public class PetMenu implements Menu
{
    ArrayList<String> petOptions = new ArrayList<>(Arrays.asList("1.FEED", "2.PET", "3.WASH"));

    private Pet pet;
    private PetOwner owner;
    //move pet graphic to pet class to make it more dynamic, we can change which graphic is shown based off, pet status
    private char[][] petGraphic = {
            {(char)218,(char)196,(char)196,(char)196,(char)191},
            {(char)179,(char)233,(char)0,(char)233,(char)179},
            {(char)179,(char)0,(char)45,(char)0,(char)179},
            {(char)192,(char)196,(char)196,(char)196,(char)217}
    };
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    LocalDateTime now = LocalDateTime.now();

    public PetMenu(Pet pet, PetOwner owner)
    {
        this.pet = pet;
        this.owner = owner;
    }

    //display shows the current date, a simple graphic of the pet(we will try to make this animated later), the pet's
    //status, and the menu
    @Override
    public void display(AsciiPanel gameScreen, Render render)
    {
        gameScreen.writeCenter(dtf.format(now), 8);
//        for(int y = 0; y < 4; y++)
//        {
//            for(int x = 0; x < 5; x++)
//            {
//                gameScreen.write(petGraphic[y][x], x+38, y+11);
//            }
//        }
        render.drawGraphic("Pet", gameScreen);
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

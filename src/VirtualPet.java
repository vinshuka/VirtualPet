import asciiPanel.AsciiPanel;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

/**
 * VirtualPet is the game engine class.
 * It handles all the variables and methods required to process inputs from the player, variable updates and rendering.
 */
public class VirtualPet extends JFrame implements KeyListener
{
    /**
     * VirtualPet instance variables, includes game graphics data currently, this data will be moved to an outside file
     * format in the future.
     */
    private AsciiPanel gameScreen;
    private String menu;
    private Pet pet;
    private PetOwner owner;
    private int food = 0;
    private boolean hasEaten = true;
    private String eating;
    private int patValue = 25;
    private int washValue = 25;
    private HashMap<String, Character[][]> graphics;
    private HashMap<String, String> messages;
    private HashMap<String, String> menuOptions;
    private int frames = 0;
    private int currentFrame = 1;

    //Graphics

    //hatchGraphic
    private Character[][] hatchGraphic = {
            {(char)47,(char)196,(char)196,(char)47,(char)196,(char)196,(char)92},
            {(char)179,(char)0,(char)0,(char)92,(char)0,(char)0,(char)179},
            {(char)179,(char)0,(char)0,(char)47,(char)0,(char)0,(char)179},
            {(char)179,(char)0,(char)0,(char)92,(char)0,(char)0,(char)179},
            {(char)92,(char)196,(char)196,(char)196,(char)196,(char)196,(char)47}
    };

    //petGraphic
    private Character[][] petGraphicHappy1 = {
            {(char)218,(char)196,(char)196,(char)196,(char)191},
            {(char)179,(char)94,(char)0,(char)94,(char)179},
            {(char)179,(char)0,(char)31,(char)0,(char)179},
            {(char)192,(char)196,(char)196,(char)196,(char)217}
    };

    private Character[][] petGraphicHappy2 = {
            {(char)218,(char)196,(char)196,(char)196,(char)191},
            {(char)179,(char)233,(char)0,(char)233,(char)179},
            {(char)179,(char)0,(char)31,(char)0,(char)179},
            {(char)192,(char)196,(char)196,(char)196,(char)217}
    };

    private Character[][] petGraphicContent1 = {
            {(char)218,(char)196,(char)196,(char)196,(char)191},
            {(char)179,(char)233,(char)0,(char)233,(char)179},
            {(char)179,(char)0,(char)45,(char)0,(char)179},
            {(char)192,(char)196,(char)196,(char)196,(char)217}
    };

    private Character[][] petGraphicContent2 = {
            {(char)218,(char)196,(char)196,(char)196,(char)191},
            {(char)179,(char)45,(char)0,(char)45,(char)179},
            {(char)179,(char)0,(char)45,(char)0,(char)179},
            {(char)192,(char)196,(char)196,(char)196,(char)217}
    };

    private Character[][] petGraphicSad1 = {
            {(char)218,(char)196,(char)196,(char)196,(char)191},
            {(char)179,(char)233,(char)0,(char)233,(char)179},
            {(char)179,(char)0,(char)30,(char)0,(char)179},
            {(char)192,(char)196,(char)196,(char)196,(char)217}
    };

    private Character[][] petGraphicSad2 = {
            {(char)218,(char)196,(char)196,(char)196,(char)191},
            {(char)179,(char)62,(char)0,(char)60,(char)179},
            {(char)179,(char)0,(char)30,(char)0,(char)179},
            {(char)192,(char)196,(char)196,(char)196,(char)217}
    };


    //feedGraphic
    private Character[][] feedGraphic = {
            {(char)240,(char)240,(char)240,(char)240,(char)240,(char)240},
            {(char)47,(char)0,(char)0,(char)0,(char)0,(char)92},
            {(char)179,(char)70,(char)79,(char)79,(char)68,(char)179},
            {(char)179,(char)0,(char)0,(char)0,(char)0,(char)179},
            {(char)196,(char)196,(char)196,(char)196,(char)196,(char)196}
    };

    //eatGraphic
    private Character[][] eatGraphic1 = {
            {' ','N','O','M','!'},
            {'N','O','M','!',' '},
            {' ','N','O','M','!'},
            {'N','O','M','!',' '},
    };

    private Character[][] eatGraphic2 = {
            {'N','O','M','!',' '},
            {' ','N','O','M','!'},
            {'N','O','M','!',' '},
            {' ','N','O','M','!'},
    };

    //pettingGraphic
    private Character[][] pettingGraphic1 = {
            {' ',(char)3,'P','E','T'},
            {'P','E','T',(char)3,' '},
            {' ',(char)3,'P','E','T'},
            {'P','E','T',(char)3,' '}
    };

    private Character[][] pettingGraphic2 = {
            {'P','E','T',(char)3,' '},
            {' ',(char)3,'P','E','T'},
            {'P','E','T',(char)3,' '},
            {' ',(char)3,'P','E','T'}
    };

    //washGraphic
    private Character[][] washGraphic1 = {
            {' ',(char)248,'S','C','R','U','B',(char)15},
            {(char)15,'S','C','R','U','B',(char)248,' '},
            {' ',(char)248,'S','C','R','U','B',(char)15},
            {(char)15,'S','C','R','U','B',(char)248,' '}
    };

    private Character[][] washGraphic2 = {
            {(char)15,'S','C','R','U','B',(char)248,' '},
            {' ',(char)248,'S','C','R','U','B',(char)15},
            {(char)15,'S','C','R','U','B',(char)248,' '},
            {' ',(char)248,'S','C','R','U','B',(char)15}
    };

    //messages

    //title
    private String title = "Virtual Pet!";

    //hatched
    private String hatched = "Your Pet has been born";

    //chooseFood
    private String chooseFood = "What would you like to feed your pet?";

    //eatMeat
    private String eatMeat = "ate a MEAT.";
    //eatVeg
    private String eatVeg = "ate a VEG.";
    //eatCake
    private String eatCake = "ate a CAKE.";

    //petting
    private String petting = "is patted nicely.";

    //washing
    private String washing = "is bathed.";

    //menuOptions

    //petOptions
    private String petOptions = "[1.FEED, 2.PET, 3.WASH]";

    //foodOptions
    private String foodOptions = "[1.MEAT, 2.VEG, 3.CAKE]";

    //enterContinue
    private String enterContinue = "Press ENTER to continue.";

    /**
     * VirtualPet initializer, sets up the HashMaps that store game graphics, menus, and messages. Prepares the JFrame,
     * initializes the Pet and PetOwner objects, sets the keyListener.
     */
    public VirtualPet()
    {
        graphics = new HashMap<>();
        graphics.put("hatchGraphic",hatchGraphic);
        graphics.put("petGraphicHappy1",petGraphicHappy1);
        graphics.put("petGraphicHappy2", petGraphicHappy2);
        graphics.put("petGraphicContent1", petGraphicContent1);
        graphics.put("petGraphicContent2", petGraphicContent2);
        graphics.put("petGraphicSad1", petGraphicSad1);
        graphics.put("petGraphicSad2", petGraphicSad2);
        graphics.put("feedGraphic",feedGraphic);
        graphics.put("eatGraphic1",eatGraphic1);
        graphics.put("eatGraphic2",eatGraphic2);
        graphics.put("pettingGraphic1",pettingGraphic1);
        graphics.put("pettingGraphic2",pettingGraphic2);
        graphics.put("washGraphic1",washGraphic1);
        graphics.put("washGraphic2",washGraphic2);
        messages = new HashMap<>();
        messages.put("title", title);
        messages.put("hatched", hatched);
        messages.put("chooseFood", chooseFood);
        messages.put("eatMeat", eatMeat);
        messages.put("eatVeg", eatVeg);
        messages.put("eatCake", eatCake);
        messages.put("petting", petting);
        messages.put("washing", washing);
        menuOptions = new HashMap<>();
        menuOptions.put("petOptions", petOptions);
        menuOptions.put("foodOptions", foodOptions);
        menuOptions.put("enterContinue", enterContinue);

        gameScreen = new AsciiPanel();
        add(gameScreen);
        pack();
        menu = "startMenu";
        pet = new Pet("Fido", 10, 10, 10);
        owner = new PetOwner("Melissa", pet);
        addKeyListener(this);
    }

    /**
     * Getter for menu variable
     * @return
     */
    public String getMenu()
    {
        return menu;
    }

    /**
     * Setter for menu variable, returns a String
     * @param menu
     */
    public void setMenu(String menu)
    {
        this.menu = menu;
    }

    /**
     * changeFrame swaps the current frame of the graphic currently being displayed, this occurs currently every 24
     * "frames"
     */
    public void changeFrame()
    {
        if(frames % 24 == 0)
        {
            if(currentFrame == 1)
            {
                currentFrame = 2;
            }
            else
            {
                currentFrame = 1;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    /**
     * Overrides keyPressed. Calls processInput, passing in the currentMenu and the KeyEvent. Clears the screen, renders
     * the new screen, and repaints the JFrame with the new screen
     */
    public void keyPressed(KeyEvent e)
    {
        processInput(e, getMenu());
        gameScreen.clear();
        render(getMenu(), gameScreen);
        super.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e)
    {

    }

    /**
     * processInput, sets the menu based on the KeyEvent it is passed and the currentMenu the game is on. If pet variables
     * need to be updated, values used for updating are set here.
     * @param e
     * @param currentMenu
     */
    public void processInput(KeyEvent e, String currentMenu)
    {
        int code = e.getKeyCode();
        if (currentMenu.equals("startMenu"))
        {
            if (code == KeyEvent.VK_ENTER)
            {
                setMenu("hatchMenu");
            }
        }

        if (currentMenu.equals("hatchMenu"))
        {
            if (code == KeyEvent.VK_ENTER)
            {
                setMenu("petMenu");
            }
        }

        if(currentMenu.equals("petMenu"))
        {
            if(code == KeyEvent.VK_1)
            {
                setMenu("feedMenu");
            }
            else if(code == KeyEvent.VK_2)
            {
                setMenu("pettingMenu");
            }
            else if(code == KeyEvent.VK_3)
            {
                setMenu("washMenu");
            }
        }

        //hasEaten value, makes sure that the food value isn't cleared by update method before being applied.
        if(currentMenu.equals("feedMenu"))
        {
            if(code == KeyEvent.VK_1)
            {
                setMenu("eatMenu");
                hasEaten = false;
                eating = "meat";
                food = 25;
            }
            else if(code == KeyEvent.VK_2)
            {
                setMenu("eatMenu");
                eating = "veg";
                hasEaten = false;
                food = 15;
            }
            else if(code == KeyEvent.VK_3)
            {
                setMenu("eatMenu");
                eating = "cake";
                hasEaten = false;
                food = 20;
            }
        }

        if(currentMenu.equals("eatMenu"))
        {
            if(code == KeyEvent.VK_ENTER)
            {
                setMenu("petMenu");
            }
        }
        if(currentMenu.equals("pettingMenu"))
        {
            if(code == KeyEvent.VK_ENTER)
            {
                setMenu("petMenu");
                patValue = 25;
            }
        }
        if(currentMenu.equals("washMenu"))
        {
            if(code == KeyEvent.VK_ENTER)
            {
                setMenu("petMenu");
                washValue = 25;
            }
        }

    }

    /**
     * update processes changes to Pet variables based on the currentMenu. The frames variable is increased here during
     * each cycle of the game loop. We change frame here as well.
     * @param currentMenu
     */
    public void update(String currentMenu)
    {
        frames++;
        changeFrame();
        if(currentMenu.equals("eatMenu"))
        {
            if(!hasEaten)
            {
                owner.feed(food);
            }
            food = 0;
            hasEaten = true;

        }
        if(currentMenu.equals("pettingMenu"))
        {
            owner.pat(patValue);
            patValue = 0;
        }
        if(currentMenu.equals("washMenu"))
        {
            owner.wash(washValue);
            washValue = 0;
        }

    }

    /**
     * render method, sets up what is displayed on our JFrame based on the currentMenu. The currentFrame variable is
     * evaluated here to determine which frame of animation to show.
     * @param currentMenu
     * @param gameScreen
     */
    public void render(String currentMenu, AsciiPanel gameScreen)
    {
        if(currentMenu.equals("startMenu"))
        {
            writeMessage("title", gameScreen, currentMenu);
            writeMenuOptions("enterContinue", gameScreen);
        }
        if(currentMenu.equals("hatchMenu"))
        {
            draw("hatchGraphic", gameScreen, 5, 7);
            writeMessage("hatched", gameScreen, currentMenu);
            writeMenuOptions("enterContinue", gameScreen);
        }
        if(currentMenu.equals("petMenu"))
        {
            switch (pet.getMood())
            {
                case "happy":
                    if(currentFrame == 1)
                    {
                        draw("petGraphicHappy1", gameScreen, 4, 5);
                    }
                    if(currentFrame == 2)
                    {
                        draw("petGraphicHappy2", gameScreen, 4, 5);
                    }
                    break;
                case "content":
                    if(currentFrame == 1)
                    {
                        draw("petGraphicContent1", gameScreen, 4, 5);
                    }
                    if(currentFrame == 2)
                    {
                        draw("petGraphicContent2", gameScreen, 4, 5);
                    }
                    //draw("petGraphicContent", gameScreen, 4, 5);
                    break;
                case "sad":
                    if(currentFrame == 1)
                    {
                        draw("petGraphicSad1", gameScreen, 4, 5);
                    }
                    if(currentFrame == 2)
                    {
                        draw("petGraphicSad2", gameScreen, 4, 5);
                    }
                    break;
            }
            petStatus(pet, gameScreen);
            writeMenuOptions("petOptions", gameScreen);
        }
        if(currentMenu.equals("feedMenu"))
        {
            draw("feedGraphic", gameScreen, 5, 6);
            writeMessage("chooseFood", gameScreen, currentMenu);
            writeMenuOptions("foodOptions", gameScreen);
        }
        if(currentMenu.equals("eatMenu"))
        {
            if(currentFrame == 1)
            {
                draw("eatGraphic1", gameScreen, 4, 5);
            }
            if(currentFrame == 2)
            {
                draw("eatGraphic2", gameScreen, 4, 5);
            }
            switch (eating)
            {
                case "meat": writeMessage("eatMeat", gameScreen, currentMenu); break;
                case "veg": writeMessage("eatVeg", gameScreen,currentMenu); break;
                case "cake": writeMessage("eatCake", gameScreen,currentMenu);break;
            }
            writeMenuOptions("enterContinue", gameScreen);
        }
        if(currentMenu.equals("pettingMenu"))
        {
            if(currentFrame == 1)
            {
                draw("pettingGraphic1", gameScreen, 4, 5);
            }
            if(currentFrame == 2)
            {
                draw("pettingGraphic2", gameScreen, 4, 5);
            }
            writeMessage("petting", gameScreen, currentMenu);
            writeMenuOptions("enterContinue", gameScreen);
        }
        if(currentMenu.equals("washMenu"))
        {
            if(currentFrame == 1)
            {
                draw("washGraphic1", gameScreen, 4, 8);
            }
            if(currentFrame == 2)
            {
                draw("washGraphic2", gameScreen, 4, 8);
            }
            writeMessage("washing", gameScreen, currentMenu);
            writeMenuOptions("enterContinue", gameScreen);
        }
        super.repaint();
    }

    /**
     * draw grabs the selected graphic from the graphics HashMap, includes parameters for the number of rows and columns
     * to allow variable sized graphics. Currently the screen position of the graphics is hard coded, this may be changed
     * later.
     * @param selectedGraphic
     * @param gameScreen
     * @param row
     * @param col
     */
    public void draw(String selectedGraphic, AsciiPanel gameScreen, int row, int col)
    {
        for(int y = 0; y < row; y++)
        {
            for(int x = 0; x < col; x++)
            {
                gameScreen.write(graphics.get(selectedGraphic)[y][x], x+38, y+9);
            }
        }
    }

    /**
     * petStatus displays a String based on the current state of our pet.
     * @param pet
     * @param gameScreen
     */
    public void petStatus(Pet pet, AsciiPanel gameScreen)
    {
        gameScreen.writeCenter(pet.status(), 16);
    }

    /**
     * displays the selected message from the messages HashMap.
     * @param selectedMessage
     * @param gameScreen
     */
    public void writeMessage(String selectedMessage, AsciiPanel gameScreen, String currentMenu)
    {
        switch(currentMenu)
        {
            case "startMenu":
            case "hatchMenu":
            case "feedMenu":
                gameScreen.writeCenter(messages.get(selectedMessage), 15);
                break;
            case "eatMenu":
            case "pettingMenu":
            case "washMenu":
                gameScreen.writeCenter(pet.getName() + " " +messages.get(selectedMessage), 15);
                break;
        }
        //gameScreen.writeCenter(messages.get(selectedMessage), 15);
    }

    /**
     * displays the selected menu options from the menuOptions HashMap.
     * @param selectedMenu
     * @param gameScreen
     */
    public void writeMenuOptions(String selectedMenu, AsciiPanel gameScreen)
    {
        gameScreen.writeCenter(menuOptions.get(selectedMenu), 22);
    }


    public static void main(String[] args) throws InterruptedException
    {
        VirtualPet app = new VirtualPet();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
        app.setFocusable(true);
        app.render(app.getMenu(), app.gameScreen);
        //main game loop
        while(true)
        {
            app.update(app.getMenu());
            //currently this sleep is required to slow processing down enough for our variables to be updated, otherwise
            //incorrect values are rendered.
            Thread.sleep(16);
            app.render(app.getMenu(), app.gameScreen);
        }
    }
}

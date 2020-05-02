import asciiPanel.AsciiPanel;

import java.util.HashMap;

//render class should take the state of the game and respond, the state being the current menu
public class Render
{
    //hashmap stores list of graphics
    private HashMap<String, Character[][]> graphicsData = new HashMap<>();
    //constructor
    public Render(HashMap<String, Character[][]> graphicsData)
    {
        this.graphicsData = graphicsData;
    }
    //method draw
    public void drawGraphic(String selectedGraphic, AsciiPanel gameScreen)
    {
        for(int y = 0; y < 4; y++)
        {
            for(int x = 0; x < 5; x++)
            {
                gameScreen.write(graphicsData.get(selectedGraphic)[y][x], x+38, y+11);
            }
        }
    }
}

import javax.swing.JFrame;
import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ApplicationMain extends JFrame implements KeyListener
{
    private static final long serialVersionUID = 1060623638149583738L;

    private AsciiPanel gameScreen;
    private Menu menu;

    public ApplicationMain()
    {
        super();
        Pet a = new Pet("A", 75);
        PetOwner owner = new PetOwner("Melissa", a);
        gameScreen = new AsciiPanel();
        add(gameScreen);
        pack();
        menu = new StartMenu(a, owner);
        addKeyListener(this);
        repaint();
    }

    public void repaint(){
        gameScreen.clear();
        menu.display(gameScreen);
        super.repaint();
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        menu = menu.userInput(e);
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    public static void main(String[] args)
    {
        ApplicationMain app = new ApplicationMain();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }


}

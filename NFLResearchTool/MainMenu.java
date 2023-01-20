import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.GridLayout;

/**
 * Write a description of class MainMenu here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MainMenu extends JFrame
{
    public MainMenu()
    {
        MainPanel mainPanel = new MainPanel();
        add(mainPanel);
    
        this.setTitle("NFL Research Tool");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(500, 325));
        this.pack();
        this.setVisible(true);
    }
    
    public static void main(String [] args)
    {
        new MainMenu();     
    }
}

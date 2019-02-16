package gui.shuttle.sort;

import javax.swing.*;
import java.awt.*;

/**
 * This program can be used to display how different sorting methods look.
 * @author Leon Wilberforce
 */

public class Application {
    
    public static void main(String[] args) {
        
        //Creating the JFrame what will contain the menu.
        JFrame application = new JFrame("Visual Sorting");

        application.setSize(new Dimension(300,300));

        MenuPanel menuPanel = new MenuPanel();

        application.add(menuPanel);

        application.setVisible(true);
        
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}

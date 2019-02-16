/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.shuttle.sort;

import java.awt.BorderLayout;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 * This 
 * @author Leon Wilberforce
 */
public class GUIShuttleSort {
    BarPanel myBars;


    public GUIShuttleSort(int[] array, int speed) throws InterruptedException{
        // TODO code application logic here
        
        JFrame myFrame = new JFrame("GUI Stuff");
        
        
        myBars = new BarPanel(array.length, array, speed);
        myFrame.add(myBars, BorderLayout.SOUTH);
        myFrame.setVisible(true);
        myFrame.pack();
        
        
        

        
    }
    
}

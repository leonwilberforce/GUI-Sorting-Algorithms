package gui.shuttle.sort;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MenuPanel extends JPanel implements ActionListener{
    int[] tmpArray;
    
    // Declaring the GUI elements that will be used within the program.
    JLabel labelTitle;
    
    JLabel labelArrayTitle;
    JLabel labelArray;
    JTextField fieldArray;
    JButton buttonRandom;
    JLabel labelArraySize;
    JTextField fieldArraySize;
    
    JLabel labelSortingTitle;
    JButton buttonShuttle;
    JButton buttonBubble;
    JButton buttonAllSort;
    JLabel labelSpeed;
    JTextField fieldSpeed;
    JButton buttonShaker;


    // Constructor for the menu panel. This will creat the menu that the user can interact with.
    public MenuPanel() {
        
        // Setting properties for the Main Title.
        labelTitle = new JLabel("Sorting Visualiser");
        labelTitle.setFont(new Font(labelTitle.getFont().getName(), Font.PLAIN, 24));
        this.setLayout(new BorderLayout());
        labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(labelTitle,BorderLayout.NORTH);
        
        //That panel wich will have al of the customisations for the array that the user can input into the system.
        JPanel arrayPanel = new JPanel();
        arrayPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0; // This determins which place it will be within the grid.
        c.gridy = 0;
        c.gridwidth = 2; // how many cells the object will take.
        
        // Creating the subtitle for the array panel.
        labelArrayTitle = new JLabel("Array");
        labelArrayTitle.setFont(new Font(labelTitle.getFont().getName(), Font.PLAIN, 18));
        labelArrayTitle.setVerticalAlignment(SwingConstants.TOP);
        labelArrayTitle.setHorizontalAlignment(SwingConstants.CENTER);
        arrayPanel.add(labelArrayTitle,c);
        
        // The label for the array that will be used in the sorting.
        c.fill = GridBagConstraints.HORIZONTAL;
        labelArray = new JLabel("Array:");
        labelArray.setHorizontalAlignment(SwingConstants.RIGHT);
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        arrayPanel.add(labelArray,c);
        
        // Adding the textfield that will store the array.
        c.gridx = 1;
        fieldArray = new JTextField();
        fieldArray.setPreferredSize(new Dimension(150, 20));
        arrayPanel.add(fieldArray,c);
        
        // Adding tabel for the array size.
        c.gridx = 0;
        c.gridy = 2;
        labelArraySize = new JLabel("Array size: ");
        labelArraySize.setHorizontalAlignment(SwingConstants.RIGHT);
        arrayPanel.add(labelArraySize,c);
        
        // Adding the field for the array size.
        c.gridx = 1;
        c.gridy = 2;
        fieldArraySize = new JTextField();
        fieldArraySize.setPreferredSize(new Dimension(50, 20));
        arrayPanel.add(fieldArraySize,c);
        
        // Adding the button that will randomly generate an array baced on the inputted array size.
        buttonRandom = new JButton("Randomise");
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 2;
        arrayPanel.add(buttonRandom,c);
        buttonRandom.addActionListener(this);
        
        // Adding the subtite for the sorting elements.
        labelSortingTitle = new JLabel("Sorting");
        labelSortingTitle.setFont(new Font(labelSortingTitle.getFont().getName(), Font.PLAIN, 18));
        labelSortingTitle.setHorizontalAlignment(SwingConstants.CENTER);
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 2;
        arrayPanel.add(labelSortingTitle,c);
        
        // Adding the label for the speed field.
        labelSpeed = new JLabel("Speed:");
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 1;
        labelSpeed.setHorizontalAlignment(SwingConstants.RIGHT);
        arrayPanel.add(labelSpeed,c);
        
        // Adding the field for the speed.
        fieldSpeed = new JTextField("500");
        fieldSpeed.setPreferredSize(new Dimension(150, 20));
        c.gridx = 1;
        c.gridy = 5;
        arrayPanel.add(fieldSpeed,c);
        
        
        
        // Adding the button for the Shuttle Sort
        buttonShuttle = new JButton("Shuttle Sort");
        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 1;
        arrayPanel.add(buttonShuttle,c);
        buttonShuttle.addActionListener(this);
        
        // Adding the button for the Bubble Sort
        buttonBubble = new JButton("Bubble Sort");
        c.gridx = 1;
        c.gridy = 6;
        c.gridwidth = 1;
        arrayPanel.add(buttonBubble,c);
        buttonBubble.addActionListener(this);
        
        // Adding the button for the Shaker Sort
        buttonShaker = new JButton("Shaker Sort");
        c.gridx = 0;
        c.gridy = 7;
        c.gridwidth = 1;
        arrayPanel.add(buttonShaker,c);
        buttonShaker.addActionListener(this);
        
        // Adding the button for the All Sort
        c.gridx = 0;
        c.gridy = 8;
        c.gridwidth = 2;
        buttonAllSort = new JButton("All");
        arrayPanel.add(buttonAllSort,c);
        buttonAllSort.addActionListener(this);

        
        
        this.add(arrayPanel,BorderLayout.CENTER);
    }
    
    //Method that is called when a button is called.
    @Override
    public void actionPerformed(ActionEvent e){
        
        if (e.getSource() == buttonRandom) {
            
            RandomiseArray(); // Changes the array depending on the array size.
            
        }else if(e.getSource() == buttonShuttle){
            UpdateArray(); // Gets the array infomation from the Array Text Field.
            
            // The Sort is ran in its own thread using its own JFrame
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        GUIShuttleSort mySort = new GUIShuttleSort(tmpArray, Integer.valueOf(fieldSpeed.getText()));

                        mySort.myBars.ShuttleSort();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MenuPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }     
            });
            t.start();

        }else if(e.getSource() == buttonShaker){
            UpdateArray();
            
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        GUIShuttleSort mySort = new GUIShuttleSort(tmpArray, Integer.valueOf(fieldSpeed.getText()));

                        mySort.myBars.shakerSort();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MenuPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }     
            });
            t.start();
            
        }else if(e.getSource() == buttonBubble){
            UpdateArray();
            
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        GUIShuttleSort myBubbleSort = new GUIShuttleSort(tmpArray, Integer.valueOf(fieldSpeed.getText()));

                        myBubbleSort.myBars.BubbleSort();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MenuPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }     
            });
            t.start();
            
            
        }else if(e.getSource() ==  buttonAllSort){ // Adding all of the frames with all of the sort.
            UpdateArray();
            
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        GUIShuttleSort myBubbleSort = new GUIShuttleSort(tmpArray, Integer.valueOf(fieldSpeed.getText()));

                        myBubbleSort.myBars.BubbleSort();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MenuPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }     
            });
            
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        GUIShuttleSort myShuttleSort = new GUIShuttleSort(tmpArray, Integer.valueOf(fieldSpeed.getText()));

                        myShuttleSort.myBars.ShuttleSort();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MenuPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }     
            });
            
            Thread t3 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        GUIShuttleSort myShakerSort = new GUIShuttleSort(tmpArray, Integer.valueOf(fieldSpeed.getText()));

                        myShakerSort.myBars.shakerSort();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MenuPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }     
            });
            
            t3.start();
            
            t.start();
            
            t2.start();
        }
    }
    
    /**
     * Update method that updates the var tmpArray with the information within the array text field.
     */
    public void UpdateArray(){
            tmpArray = new int[Integer.valueOf(fieldArraySize.getText())];
            
            for (int i = 0; i < fieldArray.getText().split(",").length; i++) {
                tmpArray[i] = Integer.valueOf(fieldArray.getText().split(",")[i]);
            }
    }
    
    /**
     * This is used to make the array in the field random.
     */
    public void RandomiseArray(){
        int arraySize = 10;
        if(fieldArraySize.getText().equals("")){
            fieldArraySize.setText("10");
        }else{
            arraySize = Integer.parseInt(fieldArraySize.getText());
        }
        Random randomGenerator = new Random();
        int[] array = new int[arraySize];
        fieldArray.setText("");
        String output = "";
        for (int i = 0; i < arraySize; i++){
            output += randomGenerator.nextInt(99) + ",";
        }
        fieldArray.setText(output);
    }
}

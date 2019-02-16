/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.shuttle.sort;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * <h1> Bar Panel</h1>
 * @author leon Wilberforce
 */
public class BarPanel extends JPanel{
    JLabel[] bars;
    int[] array;
    private int speed = 500;
    
    public BarPanel(int arraySize, int[] array, int speed) throws InterruptedException {
        
        this.speed = speed;
        
        this.setBackground(Color.black);
        
        this.array = array;
        bars = new JLabel[arraySize];
        
        // For loop to make the array of JLabels with the text and size that is contained within the array.
        for (int i = 0; i < this.array.length; i++) {
            bars[i] = new JLabel(String.valueOf(array[i]));
            bars[i].setPreferredSize(new Dimension(20, this.array[i]*2));
            
            Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
            bars[i].setBackground(Color.WHITE);
            bars[i].setOpaque(true);
            bars[i].setBorder(border);
//            bars[i].setVerticalAlignment(SwingConstants.BOTTOM); // Need to find a way to align this to bottom.
            this.add(bars[i]);
            
        }
    }
    
    //The sorting method for the Shuttle Sort.
    public void ShuttleSort() throws InterruptedException{
        Thread.sleep(1000);
        
        int passes = 0;
        int checks = 0;
        int swaps = 0;
        boolean isDone;
        for (int i = 0; i < array.length-1; i++) {
            bars[i+1].setBackground(Color.GREEN);
            bars[i+1].setBorder(BorderFactory.createLineBorder(Color.GREEN));
            bars[i].setBackground(Color.WHITE);
            bars[i].setBorder(BorderFactory.createLineBorder(Color.WHITE));
            passes++;
            this.revalidate();
            Thread.sleep(speed);
            for (int j = i; j>=0; j--) {
                checks++;
                if (array[j] > array[j+1]) {
                    swaps++;
                    bars[j].setBorder(BorderFactory.createLineBorder(Color.RED));
                    bars[j+1].setBorder(BorderFactory.createLineBorder(Color.RED));
                    bars[j].setBackground(Color.red);
                    bars[j+1].setBackground(Color.red);
                    bars[i+1].setBackground(Color.GREEN);
                    bars[i+1].setBorder(BorderFactory.createLineBorder(Color.GREEN));
                    swap(array, j, j+1);
                    this.revalidate();
                    Thread.sleep(speed);
                    
                    updateBars();
                    
                    Thread.sleep(speed);
                    
                    bars[j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    bars[j+1].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    bars[j].setBackground(Color.WHITE);
                    bars[j+1].setBackground(Color.WHITE);
                    bars[i+1].setBackground(Color.GREEN);
                    bars[i+1].setBorder(BorderFactory.createLineBorder(Color.GREEN));
                    
                    this.revalidate();
                    
                }else{
                    break;
                }
            }
            bars[i].setBackground(Color.WHITE);
            bars[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
        
        for (int i = 0; i <= array.length-1; i++) {
            Thread.sleep(50);
            bars[i].setBackground(Color.GREEN);
            this.revalidate();
        }
        
//        System.out.println("\nPasses: "+ passes + "\nChecks: " + checks + "\nSwaps: " +swaps + "\n");
//        for(int a: array){
//            System.out.print(a+" ");
//        }
    }
    
    // The sorting method of the bubble sort.
    public void BubbleSort() throws InterruptedException{
        Thread.sleep(1000);
        int passes = 0;
        int checks = 0;
        int swaps = 0;
        for (int i = 0; i < array.length; i++) {
            passes++;
            this.revalidate();
            Thread.sleep(speed);
            for (int j = 0; j < array.length-1; j++) {
                checks++;
                if (array[j]>array[j+1]) {
                    swaps++;
                    bars[j].setBorder(BorderFactory.createLineBorder(Color.RED));
                    bars[j+1].setBorder(BorderFactory.createLineBorder(Color.RED));
                    bars[j].setBackground(Color.red);
                    bars[j+1].setBackground(Color.red);
                    swap(array, j, j+1);
                    this.revalidate();
                    Thread.sleep(speed);
                    
                    updateBars();
                    
                    Thread.sleep(speed);
                    
                    bars[j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    bars[j+1].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    bars[j].setBackground(Color.WHITE);
                    bars[j+1].setBackground(Color.WHITE);
                    
                    this.revalidate();
                }
            }
        }
        for (int i = 0; i <= array.length-1; i++) {
            Thread.sleep(50);
            bars[i].setBackground(Color.GREEN);
            this.revalidate();
        }
        
        System.out.println("BubbleSort: ");
        System.out.println("\nPasses: "+ passes + "\nChecks: " + checks + "\nSwaps: " +swaps + "\n");
        for(int a: array){
            System.out.print(a+" ");
        }
        
    }
    
    // The sorting method for the shaker sort.
    public void shakerSort() throws InterruptedException{
        Thread.sleep(1000);
        int passes = 0;
        int checks = 0;
        int swaps = 0;
        for (int i = 0; i < array.length; i++) {
            bars[i].setBackground(Color.RED);
            bars[i].setBorder(BorderFactory.createLineBorder(Color.RED));
            passes++;
            this.revalidate();
            Thread.sleep(speed);
            for (int j = 0; j < array.length-1; j++) {
                checks++;
                bars[j].setBorder(BorderFactory.createLineBorder(Color.RED));
                bars[j].setBackground(Color.red);
                this.revalidate();
                if (array[j]>array[j+1]) {
                    swaps++;
                    bars[j].setBorder(BorderFactory.createLineBorder(Color.RED));
                    bars[j+1].setBorder(BorderFactory.createLineBorder(Color.RED));
                    bars[j].setBackground(Color.red);
                    bars[j+1].setBackground(Color.red);
                    swap(array, j, j+1);
                    this.revalidate();
                    Thread.sleep(speed);
                    updateBars();
                    
                    Thread.sleep(speed);
                    
                    bars[j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    bars[j+1].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    bars[j].setBackground(Color.WHITE);
                    bars[j+1].setBackground(Color.WHITE);
                    
                    this.revalidate();
                }
                bars[j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                bars[j].setBackground(Color.WHITE);
                this.revalidate();
            }
            for (int j = array.length-1; j > 0; j--) {
                checks++;
                if (array[j] < array[j-1]) {
                    swaps++;
                    bars[j].setBorder(BorderFactory.createLineBorder(Color.RED));
                    bars[j-1].setBorder(BorderFactory.createLineBorder(Color.RED));
                    bars[j].setBackground(Color.red);
                    bars[j-1].setBackground(Color.red);
                    swap(array, j, j-1);
                    this.revalidate();
                    Thread.sleep(speed);
                    updateBars();
                    
                    Thread.sleep(speed);
                    
                    bars[j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    bars[j-1].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    bars[j].setBackground(Color.WHITE);
                    bars[j-1].setBackground(Color.WHITE);
                    
                    this.revalidate();
                }
            }
        }
        for (int i = 0; i <= array.length-1; i++) {
            Thread.sleep(50);
            bars[i].setBackground(Color.GREEN);
            this.revalidate();
        }
        System.out.println("Shaker Sort");
        System.out.println("\nPasses: "+ passes + "\nChecks: " + checks + "\nSwaps: " +swaps + "\n");
        for(int a: array){
            System.out.print(a+" ");
        }
        
    }
    
    // The method used to update the bars
    public void updateBars(){
        // A for loop that changes all the bars within the screen to have the text and size equal to the array.
        for (int k = 0; k < this.array.length; k++) {
            bars[k].setText(String.valueOf(array[k]));
            bars[k].setPreferredSize(new Dimension(20, this.array[k]*2));

            this.revalidate();
        }
    }
    
    // swap method used for swapping elements within the array.
    static void swap(int[] a, int k, int l){
        int temp = a[k];
        a[k] = a[l];
        a[l] = temp;
    }
    
}

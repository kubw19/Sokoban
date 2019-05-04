package com;

import java.awt.*;
import javax.swing.*;

public class Game extends Canvas implements Runnable {

    public static int width = 300;
    public static int height = width / 16 * 9;
    public static int scale = 3;

    private JFrame frame;
    private Thread thread;
    private boolean running = false;

    public Game(){
         Dimension size = new Dimension(width * scale, height * scale);
         setPreferredSize(size);

         frame = new JFrame();
    }

    public synchronized void start(){
        thread = new Thread(this, "Display");
        thread.start();
        running = true;
    }

    public synchronized void stop(){
        running = false;
        try {
            thread.join();
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public void run(){
     while(running){

     }
    }

    public static void main(String[] args){

        Game g = new Game();
        g.frame.setResizable(false);
        g.frame.setTitle("Gra");
        g.frame.add(g);
        g.frame.pack();
        g.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        g.frame.setLocationRelativeTo(null);
        g.frame.setVisible(true);

        g.start();
    }
}

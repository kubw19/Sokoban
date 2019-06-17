package com;

import javax.swing.*;

public class Window {
    public static int width = 300;
    public static int height = width / 16 * 9;
    public static int scale = 4;
    public JFrame frame;

    /**
     * konstruktor okna tworzący JFrame pod obslugę graficzną
     * @param g gra wyświetlana na tym oknie
     */
    public Window(Game g){
        frame = new JFrame();
        frame.setResizable(false);
        frame.setTitle("Gra");
        frame.add(g);
        frame.pack();
        frame.setBounds(0, 0, width * scale, height * scale);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void main(String[] args){
        Game g = new Game(scale);
        Window window = new Window(g);
        g.setWindow(window);
    }
}

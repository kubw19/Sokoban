package com;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Game extends JPanel implements KeyListener {


    private boolean running = false;

    private int licznik =0;
    private int licznik2 =0;

    public Game(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        System.out.println("duaasd");
    }

    public void paint(Graphics gr){
        super.paint(gr);//czyszczenie panelu
        //kwadrat niebieski
        gr.setColor(Color.BLUE);
        gr.fillRect(licznik,licznik2,10, 10);

        //gr.dispose();
    }


    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)licznik+=2;
        if(e.getKeyCode() == KeyEvent.VK_LEFT)licznik-=2;
        if(e.getKeyCode() == KeyEvent.VK_UP)licznik2-=2;
        if(e.getKeyCode() == KeyEvent.VK_DOWN)licznik2+=2;
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) { }
}

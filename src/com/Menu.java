package com;

import com.Button;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Menu implements MouseListener {
    Button startLevelButton;
    private Game g;
    BufferedImage background;
    public Menu(Game g){

        this.g = g;
        try {
            background = ImageIO.read(new File("src/com/background.png"));
        }
        catch(IOException e){}

   }

    public void draw(Graphics gr){
        gr.drawImage(background, 0,0 , g.getWidth(), g.getHeight() ,null);
        startLevelButton = new Button(50,250, Game.getNormalizedPosition(0,0, 250, 50), g, "Gra");
        startLevelButton.draw(gr);
    }

    public void mouseReleased(MouseEvent e) {

        if(startLevelButton.intersectionArea.contains(e.getPoint())) {
            g.startLevel();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("teasd");
        if(startLevelButton.intersectionArea.contains(e.getPoint())) {
            startLevelButton.textureHover();
            g.repaint();
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Wjsadsadsadechałem");
    }
}

package com;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Klasa singleton opisująca menu główne gry
 */
public class Menu{
    private Button startLevelButton;
    private Button levelCreatorButton;
    private Game g;
    private BufferedImage background;

    /**
     * konstruktor Klasy Menu tworzący obiekt klasy Menu
     * @param g
     */
    public Menu(Game g){
        this.g = g;
        try {
            background = ImageIO.read(new File("src/com/resources/background.png"));
        }
        catch(IOException e){}
        startLevelButton = new Button(50,250, Game.getNormalizedPosition(0,1, 250, 50), g, "Gra");
        levelCreatorButton = new Button(50,250, Game.getNormalizedPosition(0,0, 250, 50), g, "Kreator");

    }

    /**
     * metoda rysująca menu gry
     * @param gr
     */
    public void draw(Graphics gr){
        gr.drawImage(background, 0,0 , g.getWidth(), g.getHeight() ,null);
        startLevelButton.draw(gr);
        levelCreatorButton.draw(gr);
    }

}

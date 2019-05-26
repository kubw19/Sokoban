package com;
import com.Game;
import com.Vector2d;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Button{
    protected int height;
    protected int width;

    protected BufferedImage texture, textureMain, textureHover;
    public Rectangle intersectionArea;
    protected Graphics graphics;
    protected Vector2d position;
    protected Game game;


    public Button(int height, int width, Vector2d position,Game game, String text){
        this.height = height;
        this.width = width;
        this.position = position;
        this.game=game;
        this.intersectionArea = new Rectangle(position.getX(), position.getY(), width, height);

        switch(text){
            case "Gra":
                try {
                textureMain = ImageIO.read(new File("src/com/button" + text + ".png"));
                textureHover = ImageIO.read(new File("src/com/buttonHovered" + text + ".png"));
                texture = textureMain;
                }
                catch(IOException e){}

                break;
        }
    }

    public void textureMain(){
         texture = textureMain;
    }

    public void textureHover(){
        texture = textureHover;
    }

    public void draw(Graphics gr){
        this.graphics = gr;
        this.intersectionArea = new Rectangle(position.getX(), position.getY(), width, height);
        this.graphics.drawImage(texture, position.getX(),position.getY(), width, height,null);
    }
    public String toString(){
        return "(" + position.getX() + ", " + position.getY() + ")";
    }
    public void setX(int x){
        this.position.setX(x);
    }
    public void setY(int y){
        this.position.setY(y);
    }
    public int getX(){
        return this.position.getX();
    }
    public int getY(){
        return this.position.getY();
    }



}

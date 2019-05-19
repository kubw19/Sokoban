package com;

import fIgures.Brick;
import fIgures.Square;
import fIgures.Box;
import fIgures.Target;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends Square {
    private int moves = 0;
    protected String text;
    Player(Game game,int size, Vector2d position){
        super(size, position, game);
        try {
            texture = ImageIO.read(new File("src/figures/resources/left1.png"));
        }
        catch(IOException e){}

        text="left1";
    }

    public void moveUp(){
        if(collisionDetection("UP") == null) {
            position.moveUp();
            if(text=="up1"){
                try {
                    texture = ImageIO.read(new File("src/figures/resources/up2.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                text="up2";
            }else{
                try {
                    texture=ImageIO.read(new File("src/figures/resources/up1.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                text="up1";
            }
        }
    }

    public void moveDown() {
        if (collisionDetection("DOWN") == null)
            position.moveDown();
        if (text == "down1") {
            try {
                texture = ImageIO.read(new File("src/figures/resources/down2.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            text = "down2";
        } else {
            try {
                texture = ImageIO.read(new File("src/figures/resources/down1.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            text = "down1";
        }
    }
    public void moveRight() {
        System.out.println(collisionDetection("RIGHT"));
        if (collisionDetection("RIGHT") == null)
            position.moveRight();
        if (text == "right1") {
            try {
                texture = ImageIO.read(new File("src/figures/resources/right2.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            text = "right2";
        } else {
            try {
                texture = ImageIO.read(new File("src/figures/resources/right1.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            text = "right1";
        }
    }
    public void moveLeft(){
        System.out.println("Left: " + collisionDetection("LEFT"));
        Square square;
        if(!((square = collisionDetection("LEFT")) instanceof Brick)){
            if(square instanceof Box){
                System.out.println("mamy box");
                if((!((Box) square).moveLeft()))return;
            }
            position.moveLeft();
        }



        if(text=="left1"){
            try {
                texture = ImageIO.read(new File("src/figures/resources/left2.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            text="left2";
        }else {
            try {
                texture = ImageIO.read(new File("src/figures/resources/left1.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            text = "left1";
        }
    }
}

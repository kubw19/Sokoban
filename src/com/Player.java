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

public class Player {
    private int moves = 0;
    private Game game;
    protected TextureSet textureSet;
    private BufferedImage texture;
    protected String text;
    private int size;
    Player(Game game,int size){
        textureSet=new TextureSet(this);
        this.game = game;
        this.size=size;
        texture=textureSet.getActive();
    }

    public void draw(Graphics gr){
        //texture=textureSet.getActive();
        Vector2d w = Game.getNormalizedPosition(game.getPlayersPosition().getX(),game.getPlayersPosition().getY());
        gr.drawImage(texture, w.getX(),w.getY(), size, size,null);
    }

    public int collisionDetection(String dir){
        Rectangle newPosition = null;
        switch(dir) {
            case "UP":
                newPosition = new Rectangle(game.getPlayersPositionNormalized().getX(), game.getPlayersPositionNormalized(0,1).getY(), Game.getBrickSize(), Game.getBrickSize());
                break;
            case "DOWN":
                 newPosition = new Rectangle(game.getPlayersPositionNormalized().getX(), game.getPlayersPositionNormalized(0,-1).getY(), Game.getBrickSize(), Game.getBrickSize());
                 break;
            case "RIGHT":
                newPosition = new Rectangle(game.getPlayersPositionNormalized(1,0).getX(), game.getPlayersPositionNormalized().getY(), Game.getBrickSize(), Game.getBrickSize());
                break;
            case "LEFT":
                newPosition = new Rectangle(game.getPlayersPositionNormalized(-1,0).getX(), game.getPlayersPositionNormalized().getY(), Game.getBrickSize(), Game.getBrickSize());
                break;
        }

        for(Square square : game.getObecnyPoziom().objects){
            if(square.intersectionArea.intersects(newPosition)){
                if(square instanceof Brick)
                    return -1;
                if(square instanceof Box) {
                    switch(dir) {
                        case "UP":
                            if(((Box)square).moveUp()) return -1;
                            break;
                        case "DOWN":
                            if(((Box)square).moveDown())return -1;
                            break;
                        case "RIGHT":
                            if(((Box)square).moveRight())return -1;
                            break;
                        case "LEFT":
                            if(((Box)square).moveLeft()) return -1;
                            break;
                    }
                    return 0;
                }
            }
        }
        return 0;
    }

    public void moveUp(){
        //textureSet.setActive("UP");
        if(collisionDetection("UP") == 0)
            game.playersPosition.setY(game.playersPosition.getY() + 1);
        textureSet.setActive("UP");
    }
    public void moveDown() {
        if (collisionDetection("DOWN") == 0)
            game.playersPosition.setY(game.playersPosition.getY() - 1);
        textureSet.setActive("DOWN");
    }
    public void moveRight() {
        if (collisionDetection("RIGHT") == 0)
            game.playersPosition.setX(game.playersPosition.getX() + 1);
        textureSet.setActive("RIGHT");
    }
    public void moveLeft(){
        if(collisionDetection("LEFT") == 0)
            game.playersPosition.setX(game.playersPosition.getX() - 1);
        textureSet.setActive("LEFT");
    }
}

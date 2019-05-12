package com;

import fIgures.Brick;
import fIgures.Square;

import java.awt.*;

public class Player  {
    private int moves = 0;
    private Game game;

    Player(Game game){
        this.game = game;
    }

    public void draw(Graphics gr){
        gr.setColor(Color.RED);
        Vector2d w = Game.getNormalizedPosition(game.getPlayersPosition().getX(),game.getPlayersPosition().getY());
        gr.fillRect(w.getX(),w.getY(),Game.getBrickSize(), Game.getBrickSize());
    }

    private int collisionDetection(String dir){
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
            }
        }

        return 0;
    }

    public void moveUp(){
        if(collisionDetection("UP") == 0) {
            game.playersPosition.setY(game.playersPosition.getY() + 1);
        }
    }

    public void moveDown(){
        if(collisionDetection("DOWN") == 0)
            game.playersPosition.setY(game.playersPosition.getY() - 1);
    }

    public void moveRight(){
        if(collisionDetection("RIGHT") == 0)
            game.playersPosition.setX(game.playersPosition.getX() + 1);
    }

    public void moveLeft(){
        if(collisionDetection("LEFT") == 0)
            game.playersPosition.setX(game.playersPosition.getX() - 1);
    }
}

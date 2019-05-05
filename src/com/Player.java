package com;

import java.awt.*;

public class Player {
    private int moves = 0;


    public void draw(Game game, Graphics gr){
        gr.setColor(Color.RED);
        int posX = (game.getPlayersPosition().getX() * game.getGridSize()) + game.getRelativeX() - game.getBrickSize()/2;
        int posY = (game.getPlayersPosition().getY() * game.getGridSize()) + game.getRelativeY()  - game.getBrickSize()/2;
        gr.fillRect(posX,posY,game.getBrickSize(), game.getBrickSize());
    }
}

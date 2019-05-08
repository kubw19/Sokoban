package com;

import fIgures.Square;

import java.awt.*;

public class Player  {
    private int moves = 0;

    public void draw(Game game, Graphics gr){
        gr.setColor(Color.RED);
        Vector2d w = Game.getNormalizedPosition(game.getPlayersPosition().getX(),game.getPlayersPosition().getY());
        gr.fillRect(w.getX(),w.getY(),Game.getBrickSize(), Game.getBrickSize());
    }
}

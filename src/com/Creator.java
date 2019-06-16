package com;

import fIgures.*;

import java.awt.*;
import java.util.ArrayList;

public class Creator {

    private static ArrayList<Square> objects = new ArrayList<>();

    public static void startCreator(Game game){//zainicjowanie tworzenia poziomów
        game.setCreatingLevel(true);
        game.setObecnyPoziom(new Poziom(game));
        game.setPlayer(new Player(game,Game.getBrickSize(), game.getObecnyPoziom().getStartingPoint()));
        objects.add(new Brick(Game.getBrickSize(), game.getNormalizedPosition(-8, 0), game));
        objects.add(new Box(Game.getBrickSize(), game.getNormalizedPosition(-8, 2), game));
    }

    public static void displayCreator(Graphics gr, Game game){//rysowanie kreatora
        gr.setColor(new Color(10, 77, 46));
        gr.fillRect(0, 0, game.getWidth(), game.getHeight());

        for(Square square : objects){
            square.draw(gr);
        }

        game.getObecnyPoziom().draw(gr);
        game.getPlayer().draw(gr);
    }
}

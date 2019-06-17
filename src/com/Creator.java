package com;

import fIgures.*;

import java.awt.*;
import java.util.ArrayList;

public class Creator {

    private static ArrayList<Square> objectsToSelect = new ArrayList<>();

    private static Square material;

    private static Button saveLevelButton;
    private static Button exitButton;

    public static void startCreator(Game game){//zainicjowanie tworzenia poziomów
        game.setCreatingLevel(true);
        game.setObecnyPoziom(new Poziom(game));
        game.setPlayer(new Player(game,Game.getBrickSize(), game.getObecnyPoziom().getStartingPoint()));
        objectsToSelect.add(new Brick(Game.getBrickSize(), game.getNormalizedPosition(-8, 3), game));
        objectsToSelect.add(new Box(Game.getBrickSize(), game.getNormalizedPosition(-8, 1), game));
        objectsToSelect.add(new Target(Game.getBrickSize(), game.getNormalizedPosition(-8, 0), game));
        objectsToSelect.add(new StartingPoint(Game.getBrickSize(), game.getNormalizedPosition(-8, 2), game));
        saveLevelButton = new Button(40,150, new Vector2d(game.getWidth()/2 - 155,game.getHeight() - 40), game, "ZapiszPoziom");
        exitButton = new Button(40,150, new Vector2d(game.getWidth()/2 + 5 ,game.getHeight() - 40), game, "LeaveCreator");

    }

    public static void displayCreator(Graphics gr, Game game){//rysowanie kreatora
        gr.setColor(new Color(10, 77, 46));
        gr.fillRect(0, 0, game.getWidth(), game.getHeight());

        for(Square square : objectsToSelect){
            square.draw(gr);
        }

        game.getObecnyPoziom().draw(gr);
        game.getPlayer().draw(gr);
        //game.getObecnyPoziom().setStartingPoint(null);

        saveLevelButton.draw(gr);
        exitButton.draw(gr);


    }

    public static void newElement(Game game){

        Square position = game.getPlayer();
        boolean selectMaterial = false;
        for(Square square : objectsToSelect){
            if(square.getPosition().equals(position.getPosition())){
                selectMaterial = true;
                material = square;
                System.out.println("wybrane");
            }
        }
        if(!selectMaterial){

            for(Square sq : game.getObecnyPoziom().getObjects()){
                if(game.getPlayer().getPosition().equals(sq.getPosition()))return;
            }

            if(material instanceof Brick){
                game.getObecnyPoziom().addElement(new Brick(Game.getBrickSize(), new Vector2d(game.getPlayer().getPosition()), game));
            }
            else if(material instanceof Box){
                game.getObecnyPoziom().addElement(new Box(Game.getBrickSize(), new Vector2d(game.getPlayer().getPosition()), game));
            }
            else if(material instanceof Target){
                game.getObecnyPoziom().addElement(new Target(Game.getBrickSize(), new Vector2d(game.getPlayer().getPosition()), game));
            }
            else if(material instanceof StartingPoint){
                for(int i = 0; i<game.getObecnyPoziom().getObjects().size();i++){
                    Square sq = game.getObecnyPoziom().getObjects().get(i);
                    if(sq instanceof StartingPoint){
                        game.getObecnyPoziom().getObjects().remove(sq);
                    }
                }
                game.getObecnyPoziom().addElement(new StartingPoint(Game.getBrickSize(), new Vector2d(game.getPlayer().getPosition()), game));
                game.getObecnyPoziom().setStartingPoint(new Vector2d(game.getPlayer().getPosition()));
                //System.out.println("ustawiam " +game.getObecnyPoziom().getStartingPoint());
            }

        }


    }
    public static void deleteElement(Game game){
        Square position = game.getPlayer();
        game.getObecnyPoziom().removeElement(position.getPosition());
    }
}

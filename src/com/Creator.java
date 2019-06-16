package com;

import fIgures.*;

import java.awt.*;
import java.util.ArrayList;

public class Creator {

    private static ArrayList<Square> objectsToSelect = new ArrayList<>();

    private static Square material;

    private static Button saveLevelButton;

    public static void startCreator(Game game){//zainicjowanie tworzenia poziomów
        game.setCreatingLevel(true);
        game.setObecnyPoziom(new Poziom(game));
        game.setPlayer(new Player(game,Game.getBrickSize(), game.getObecnyPoziom().getStartingPoint()));
        objectsToSelect.add(new Brick(Game.getBrickSize(), game.getNormalizedPosition(-8, 2), game));
        objectsToSelect.add(new Box(Game.getBrickSize(), game.getNormalizedPosition(-8, 4), game));
        objectsToSelect.add(new StartingPoint(Game.getBrickSize(), game.getNormalizedPosition(-8, 0), game));
        saveLevelButton = new Button(50,250, Game.getNormalizedPosition(-7,-2, 250, 50), game, "ZapiszPoziom");

    }

    public static void displayCreator(Graphics gr, Game game){//rysowanie kreatora
        gr.setColor(new Color(10, 77, 46));
        gr.fillRect(0, 0, game.getWidth(), game.getHeight());

        for(Square square : objectsToSelect){
            square.draw(gr);
        }


        game.getPlayer().draw(gr);
        game.getObecnyPoziom().draw(gr);
        saveLevelButton.draw(gr);


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
            if(material instanceof Brick){
                game.getObecnyPoziom().addElement(new Brick(Game.getBrickSize(), new Vector2d(game.getPlayer().getPosition()), game));
            }
            else if(material instanceof Box){
                game.getObecnyPoziom().addElement(new Box(Game.getBrickSize(), new Vector2d(game.getPlayer().getPosition()), game));
            }
            else if(material instanceof StartingPoint){
                for(Square sq : game.getObecnyPoziom().getObjects()){
                    if(sq instanceof StartingPoint)game.getObecnyPoziom().getObjects().remove(sq);
                    break;
                }
                game.getObecnyPoziom().addElement(new StartingPoint(Game.getBrickSize(), new Vector2d(game.getPlayer().getPosition()), game));
            }

        }


    }
    public static void deleteElement(Game game){
        Square position = game.getPlayer();
        game.getObecnyPoziom().removeElement(position.getPosition());
    }
}

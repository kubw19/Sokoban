package com;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import fIgures.Brick;
import fIgures.Box;
import fIgures.Target;
import fIgures.Square;

public class Poziom {
    private int winCondition;
    private Vector2d startingPoint;
    private ArrayList<Square> objects;
    private Game game;
    private String id;

    public Poziom(Game game, String id){
        this.id = id;
        objects = new ArrayList<>();
        this.game = game;
        winCondition=0;
        this.build();
    }
    private void build(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(id + ".txt"));
            String line;
            line=reader.readLine();
            String[] parts = line.split(";");
            startingPoint=Game.getNormalizedPosition(Integer.valueOf(parts[0]), Integer.valueOf(parts[1]));
             while((line =reader.readLine()) != null){
                parts = line.split(";");
                switch(parts[0]){
                    case "W":
                        objects.add(new Brick(game.getBrickSize(), Game.getNormalizedPosition(Integer.valueOf(parts[1]), Integer.valueOf(parts[2])),game));
                        break;
                    case "B":
                        objects.add(new Box(game.getBrickSize(), Game.getNormalizedPosition(Integer.valueOf(parts[1]), Integer.valueOf(parts[2])),game));
                        break;
                    case "T":
                        objects.add(new Target(game.getBrickSize(), Game.getNormalizedPosition(Integer.valueOf(parts[1]), Integer.valueOf(parts[2])),game));
                        winCondition++;
                        break;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public int getWinCondition(){
        return winCondition;
    }
    public void draw(Graphics gr) {
        for (Square square : objects) {
                square.draw(gr);
        }
    }
    public Vector2d getStartingPoint(){
        return startingPoint;
    }
    public ArrayList<Square> getObjects(){return objects;}
}

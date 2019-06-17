package com;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

import fIgures.*;

public class Level {
    private int winCondition;
    private Vector2d startingPoint;
    private ArrayList<Square> objects;
    private Game game;
    private String id;

    /**
     * konstruktor Level tworzący obiekt klasy Level
     * @param game panel gry w którym ma być wyświetlany poziom
     * @param id numer poziomu używany jako nazwa pliku (id+".xtx")
     * @throws IOException
     */
    public Level(Game game, String id)throws IOException{
        this.id = id;
        objects = new ArrayList<>();
        this.game = game;
        winCondition=0;
        this.build();
    }

    /**
     *  konstruktor Level tworzący obiekt klasy Level
     * @param game panel gry w którym ma być wyświetlany poziom
     */
    public Level(Game game){
        this.game=game;
        winCondition=0;
        objects = new ArrayList<>();
        startingPoint=Game.getNormalizedPosition(0,0);
    }

    /**
     * metoda dodająca obiekty do listy objects poziomu
     * obiekty dodawane są z pliku (id+".txt")
     * @throws IOException
     */
    private void build() throws IOException{
        BufferedReader reader;
            reader = new BufferedReader(new FileReader(id + ".txt"));
            String line;
            line=reader.readLine();
            String[] parts = line.split(";");
            startingPoint=new Vector2d(Integer.valueOf(parts[0]), Integer.valueOf(parts[1]));
             while((line =reader.readLine()) != null){
                parts = line.split(";");
                switch(parts[0]){
                    case "W":
                        objects.add(new Brick(game.getBrickSize(), new Vector2d(Integer.valueOf(parts[1]), Integer.valueOf(parts[2])),game));
                        break;
                    case "B":
                        objects.add(new Box(game.getBrickSize(), new Vector2d(Integer.valueOf(parts[1]), Integer.valueOf(parts[2])),game));
                        break;
                    case "T":
                        objects.add(new Target(game.getBrickSize(), new Vector2d(Integer.valueOf(parts[1]), Integer.valueOf(parts[2])),game));
                        winCondition++;
                        break;
                }
            }
    }

    /**
     * zwraca liczbę skrzyń jaka musi być na polach Target żeby zakończyć poziom
     * @return
     */
    public int getWinCondition(){
        return winCondition;
    }

    /**
     * rysuje wszystkie obiekty poziomu
     * @param gr
     */
    public void draw(Graphics gr) {
        for (Square square : objects) {
                square.draw(gr);
        }
    }

    /**
     * @return startingPoint jako obiekt klasy Vector2d
     */
    public Vector2d getStartingPoint(){
        return startingPoint;
    }

    /**
     *
     * @return lista(ArrayList) obiektów należączych do danego poziomu
     */
    public ArrayList<Square> getObjects(){return objects;}

    /**
     * dodanie elementu do listy objects poziomu
     * @param square dodawany element
     */
    public void addElement(Square square){
        objects.add(square);
    }

    /**
     * usuwa element o wskazanej pozycji
     * @param position pozycja elementu który ma zostać usunięty
     */
    public void removeElement(Vector2d position){
        Square removed=null;
        for(Square square:objects){
            if(square.getX()==position.getX()&&square.getY()==position.getY())removed=square;
        }
        if(removed!=null)
        objects.remove(removed);
    }

    /**
     * ustawienie pozycji początkowej gracza
     * @param position pozycja początkowa gracza
     */
    public void setStartingPoint(Vector2d position){
        startingPoint=position;
    }

    /**
     * zapisanie poziomu do pliku o pierwszym wolnym indeksie
     * ograniczenie liczby istniejących poziomów 100
     */
    public void saveLevel(){
        BufferedReader reader;
        for(int i=1;i<100;i++) {
            try {
                reader = new BufferedReader(new FileReader(i + ".txt"));
                try {reader.close(); } catch (IOException e1){}
            } catch (FileNotFoundException e) {
                try {
                    File file=new File(i+".txt");
                    file.createNewFile();
                } catch (IOException e1) { }
                BufferedWriter writer = null;
                try { writer = new BufferedWriter(new FileWriter(i + ".txt")); } catch (IOException e1) { }
                try { writer.write(startingPoint.getX()+";"+startingPoint.getY()); } catch (IOException e1) { }
                for(Square square:objects){
                    try {
                        if(square instanceof Target){
                            writer.newLine();
                            writer.write("T;"+square.getX()+";"+square.getY());
                        }
                    }catch (IOException e1) { }
                }
                for(Square square:objects){
                    try {
                        if(square instanceof Brick){
                            writer.newLine();
                            writer.write("W;"+square.getX()+";"+square.getY());
                        }
                    }catch (IOException e1) { }
                }
                for(Square square:objects){
                    try {
                        if(square instanceof Box){
                            writer.newLine();
                            writer.write("B;"+square.getX()+";"+square.getY());
                        }
                    }catch (IOException e1) { }
                }
                try { writer.close(); } catch (IOException e1) { }
                return;
            }
        }
    }
}

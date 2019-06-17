package com;

import fIgures.*;
import fIgures.Box;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;

/**
 * Klasa opisująca panel gry, na którym rysowane są elementy
 */
public class Game extends JPanel implements KeyListener{

    private Player player;
    private Level currentLevel;
    private Menu menu;
    private static int scale;
    private static int relativeX;
    private static int relativeY;
    private static int gridSize;
    private static int brickSize;
    private boolean inMenu = true;

    /**
     * Funkcja przywracająca ekran menu startowego gry z dowolnego miejsca w grze
     */
    public void returnToMenu(){
        currentLevel = null;
        creatingLevel = false;
        player = null;
        id = 0;
        inMenu = true;
    }

    /**
     * Włącza lub wyłącza tryb tworzenia poziomów
     * @param creatingLevel Parametr oznaczający stan kreatora, który chcemy włączyć.
     */
    public void setCreatingLevel(boolean creatingLevel) {
        inMenu = false;
        this.creatingLevel = creatingLevel;
    }

    /**
     * Funkcja zwracająca wartość typu boolean oznaczającą stan używania kreatora poziomów
     * @return boolean Stan używania kreatora poziomów
     */
    public boolean isCreatingLevel() {
        return creatingLevel;
    }

    private boolean creatingLevel;
    private static Integer id=0;
    private Window window;
    private Button nextLevelButton;

    /**
     * Funcja ustawiająca obiekt typu Window, w którym rysowany jest panel Game
     * @param window referencja na obiekt Window
     */
    public void setWindow(Window window) {
        this.window = window;
    }

    /**
     * Funkcja przekształcająca współrzędna podaną względem środa ekranu na współrzędna względem układu używanego przez bilbiotekę swing
     *
     * @param x współrzędna x
     * @param y współrzędna y
     * @return zwraca współrzędną  względem układu używanego przez bilbiotekę swing
     */
    public static Vector2d getNormalizedPosition(int x, int y){
        Vector2d w = new Vector2d(x,y);
        w.setX(relativeX + x * gridSize - brickSize/2);
        w.setY((relativeY + y * (-1) * gridSize - brickSize/2));
        return w;
    }
    /**
     * Funkcja przekształcająca współrzędna podaną względem środa ekranu na współrzędna względem układu używanego przez bilbiotekę swing
     * To przeciążenie przyjmuje zmienioną szerokość i wysokość obiektu, dla ktorego tworzymy współrzędną
     * @param x współrzędna x
     * @param y współrzędna y
     * @param brickWidth szerokość obiektu
     * @param brickHeight wysokość obiektu
     * @return zwraca współrzędną  względem układu używanego przez bilbiotekę swing
     */
    public static Vector2d getNormalizedPosition(int x, int y, int brickWidth, int brickHeight){
        Vector2d w = new Vector2d(x,y);
        w.setX(relativeX + x * gridSize - brickWidth/2);
        w.setY((relativeY + y * (-1) * gridSize - brickHeight/2));
        return w;
    }

    /**
     * Konstruktor tworzący nową instancję klasy Game
     * @param scale skala z jaką rysowana jest gra
     */
    public Game(int scale){
        this.scale = scale;
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        gridSize = 16 * scale;
        brickSize = 16 * scale;
        relativeX = 300 * scale / 2;
        relativeY = 300 /16 * 9 * scale/ 2 + 24 * scale;
        currentLevel = null;
        player = null;
        menu = new Menu(this);
        nextLevelButton = new Button(50,250, new Vector2d(getWidth()/2,0), this, "NastepnyPoziom");

    }

    /**
     * Uruchamia nastepny poziom
     */
    public void startLevel(){
        try {
            currentLevel=new Level(this,(++id).toString());
        }catch (FileNotFoundException e) { this.returnToMenu(); } catch (IOException e) { }

        if(currentLevel != null)
            player = new Player(this,brickSize, currentLevel.getStartingPoint());
        inMenu = false;
        repaint();
    }
    public void paint(Graphics gr){
        relativeX = getWidth() / 2;
        relativeY = getHeight() / 2 + 24 * scale;
        if(creatingLevel == true){
            Creator.displayCreator(gr, this);
        }
        else if(currentLevel == null || player == null){
            menu.draw(gr);
        }
        else {
            gr.setColor(new Color(10, 77, 46));
            gr.fillRect(0, 0, getWidth(), getHeight());
            currentLevel.draw(gr);
            player.draw(gr);



            for (Square square : this.getCurrentLevel().getObjects()) {
                if (square instanceof Target) {
                    ((Target) square).isOccupied();
                }
            }
            if (this.koniecGry()){
                repaint();
                nextLevelButton.draw(gr);
            }
            gr.setColor(new Color(247, 54, 54));
            gr.setFont(new Font("TimesRoman", Font.BOLD, 20));
            gr.drawString("Poziom: "+ id, 1000,20);
            gr.setColor(Color.WHITE);
            gr.drawString("Liczba ruchów: "+player.getMoves(), 1000,40);
        }

        repaint();
    }
    @Override
    public void keyTyped(KeyEvent e) { }
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER && creatingLevel){
            Creator.newElement(this);
        }
        else if(e.getKeyCode() == KeyEvent.VK_ENTER && !creatingLevel && koniecGry()){
            startLevel();
        }

        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            returnToMenu();
        }

        if(e.getKeyCode() == KeyEvent.VK_DELETE && creatingLevel){
            Creator.deleteElement(this);
        }

        if(e.getKeyCode() == KeyEvent.VK_RIGHT  && !inMenu){
            player.moveRight();
        };
        if(e.getKeyCode() == KeyEvent.VK_LEFT  && !inMenu){
            player.moveLeft();
        };
        if(e.getKeyCode() == KeyEvent.VK_UP  && !inMenu){
            player.moveUp();
        };
        if(e.getKeyCode() == KeyEvent.VK_DOWN && !inMenu){
            player.moveDown();
        }

        repaint();
    }
    @Override
    public void keyReleased(KeyEvent e) { }

    /**
     * Getter gridSize
     * @return rozmiar siatki ekranu
     */
    public static int getGridSize() {return gridSize;}

    /**
     * Getter brickSize
     * @return rozmiar pojedynczego bloku na ekranie
     */
    public static int getBrickSize() { return brickSize; }

    /**
     *
     * @return Referencja na obecny poziom
     */
    public Level getCurrentLevel() { return currentLevel; }

    /**
     * Ustawia obecny poziom
     * @param currentLevel referemcja na poziom do ustawienia jako obecny
     */
    public void setCurrentLevel(Level currentLevel) { this.currentLevel = currentLevel;}

    /**
     * Ustawia obecnego gracza
     * @param player referencja na gracza Player
     */
    public void setPlayer(Player player){this.player = player;}

    /**
     * Zwraca aktualnego gracza
     * @return Aktualny gracz
     */
    public Player getPlayer() { return player; }
    private boolean koniecGry(){
        int winPoints=0;
        for(Square square : this.getCurrentLevel().getObjects()) {
            if(square instanceof Target){
                if(((Target) square).getOccupied()){
                    winPoints++;
                }
            }
        }
        if(winPoints==this.currentLevel.getWinCondition()){
            return true;
        }
        return false;
    }

    /**
     * Getter atrybutu inMenu, oznacza czy gra wyświetla menu główne
     * @return wartość, czy gra wyświetla menu główne
     */
    public boolean isInMenu(){
        return inMenu;
    }




}

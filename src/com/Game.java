package com;

import fIgures.Player;
import fIgures.Square;
import fIgures.Target;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Game extends JPanel implements KeyListener{

    private Player player;
    private Poziom obecnyPoziom;
    private Menu menu;
    private static int scale;
    private static int relativeX;
    private static int relativeY;
    private static int gridSize;
    private static int brickSize;
    private static Integer id=0;

    public static Vector2d getNormalizedPosition(int x, int y){
        Vector2d w = new Vector2d(x,y);
        w.setX(relativeX + x * gridSize - brickSize/2);
        w.setY((relativeY + y * (-1) * gridSize - brickSize/2));
        return w;
    }
    public static Vector2d getNormalizedPosition(int x, int y, int brickWidth, int brickHeight){
        Vector2d w = new Vector2d(x,y);
        w.setX(relativeX + x * gridSize - brickWidth/2);
        w.setY((relativeY + y * (-1) * gridSize - brickHeight/2));
        return w;
    }
    public Game(int scale){
        this.scale = scale;
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        menu = new Menu(this);
        addMouseListener(menu);
        gridSize = 16 * scale;
        brickSize = 16 * scale;
        relativeX = 300 * scale / 2;
        relativeY = 300 /16 * 9 * scale/ 2 + 24 * scale;
        obecnyPoziom = null;
        player = null;
    }
    public void startLevel(){
        obecnyPoziom=new Poziom(this,(++id).toString());
        player = new Player(this,brickSize, obecnyPoziom.getStartingPoint());
        repaint();
    }
    public void paint(Graphics gr){
        relativeX = getWidth() / 2;
        relativeY = getHeight() / 2 + 24 * scale;
        if(obecnyPoziom == null || player == null){
            menu.draw(gr);
        }
        else {
            gr.setColor(new Color(10, 77, 46));
            gr.fillRect(0, 0, getWidth(), getHeight());
            obecnyPoziom.draw(gr);
            player.draw(gr);
            for (Square square : this.getObecnyPoziom().getObjects()) {
                if (square instanceof Target) {
                    ((Target) square).isOccupied();
                }
            }
            if (this.koniecGry()){
                repaint();
                menu.draw(gr);//zamiast tego pasuje wstawic menu po skonczeniu poziomu i jakoś opóźnić wyświetlanie żeby było widać kolejny poziom
            }
        }
        repaint();
    }
    @Override
    public void keyTyped(KeyEvent e) { }
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            player.moveRight();
        };
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            player.moveLeft();
        };
        if(e.getKeyCode() == KeyEvent.VK_UP){
            player.moveUp();
        };
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            player.moveDown();
        }

        repaint();
    }
    @Override
    public void keyReleased(KeyEvent e) { }
    public static int getScale() {
        return scale;
    }
    public static int getRelativeX() {return relativeX;}
    public static int getRelativeY() {return relativeY;}
    public static int getGridSize() {return gridSize;}
    public static int getBrickSize() { return brickSize; }
    public Poziom getObecnyPoziom() { return obecnyPoziom; }
    private boolean koniecGry(){
        int winPoints=0;
        for(Square square : this.getObecnyPoziom().getObjects()) {
            if(square instanceof Target){
                if(((Target) square).getOccupied()){
                    winPoints++;
                }
            }
        }
        if(winPoints==this.obecnyPoziom.getWinCondition()){
            return true;
        }
        return false;
    }



}

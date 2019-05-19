package com;

import fIgures.Player;
import fIgures.Square;
import fIgures.Target;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

import static java.lang.Thread.sleep;

public class Game extends JPanel implements KeyListener {

    private Player player;
    private Poziom obecnyPoziom;

    private static int scale;
    private static int relativeX;
    private static int relativeY;
    private static int gridSize;
    private static int brickSize;


    public static Vector2d getNormalizedPosition(int x, int y){
        Vector2d w = new Vector2d(x,y);

        w.setX(relativeX + x * gridSize - brickSize/2);
        w.setY((relativeY + y * (-1) * gridSize - brickSize/2));

        return w;
    }


    public Game(int scale){
        this.scale = scale;
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        //System.out.println(relativeX);
        gridSize = 16 * scale;
        brickSize = 16 * scale;

        relativeX = 300 * scale / 2;
        relativeY = 300 /16 * 9 * scale/ 2 + 24 * scale;

        obecnyPoziom = new Poziom(this,'1');//docelowo trzeba tu wsadzić zmienną zamiast liczby jako id
        player = new Player(this,brickSize, obecnyPoziom.getStartingPoint());
    }

    public void paint(Graphics gr){
        relativeX = getWidth() / 2;
        relativeY = getHeight() / 2 + 24 * scale;
        //System.out.println(getWidth());

        gr.setColor(new Color(10, 77, 46));
        gr.fillRect(0,0,getWidth(), getHeight());

        //gr.setColor(new Color(66, 22, 46));
        //gr.fillRect(Game.getNormalizedPosition(0,0).getX(),Game.getNormalizedPosition(0,0).getY(),20, 20);

        obecnyPoziom.draw(gr);
        player.draw(gr);
        //
        for(Square square : this.getObecnyPoziom().objects) {
            if(square instanceof Target){
                ((Target) square).isOccupied();
            }
        }
        repaint();
            //tu powinno być opóźnienie żeby się pojawiał chociaż na chwilę ostatni układ poziomu
        //nie może być w ifie niżej bo się potyka
        if (this.koniecGry()){
            System.out.println("koniec");
            obecnyPoziom=new Poziom(this,'1');//zamiast liczby inkrementacja jakiejs zmiennej
            player=new Player(this,brickSize, obecnyPoziom.getStartingPoint());
            repaint();
        }
        //
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

    public static int getRelativeX() {
        return relativeX;
    }

    public static int getRelativeY() {
        return relativeY;
    }

    public static int getGridSize() {
        return gridSize;
    }

    public static int getBrickSize() {
        return brickSize;
    }



    public Poziom getObecnyPoziom() {
        return obecnyPoziom;
    }
    public boolean koniecGry(){
        int winPoints=0;
        for(Square square : this.getObecnyPoziom().objects) {
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

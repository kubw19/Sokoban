package com;

import fIgures.Square;
import fIgures.Target;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Game extends JPanel implements KeyListener {

    private Player player;
    private Poziom obecnyPoziom;
    public Vector2d playersPosition;

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

        player = new Player(this,brickSize);

        obecnyPoziom = new Poziom(this,'2');
        playersPosition = obecnyPoziom.getStartingPoint();
    }

    public void paint(Graphics gr){
        relativeX = getWidth() / 2;
        relativeY = getHeight() / 2 + 24 * scale;

        gr.setColor(new Color(10, 77, 46));
        gr.fillRect(0,0,getWidth(), getHeight());

        obecnyPoziom.draw(gr);
        player.draw(gr);
        //
        for(Square square : this.getObecnyPoziom().objects) {
            if(square instanceof Target){
                ((Target) square).isOccupied();
            }
        }
        if (this.koniecGry()){
            obecnyPoziom=new Poziom(this,'1');
            playersPosition = obecnyPoziom.getStartingPoint();
            player=new Player(this,brickSize);
            System.out.println("koniec");
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

    public Vector2d getPlayersPosition() {
        return playersPosition;
    }

    public Vector2d getPlayersPositionNormalized() {
        Vector2d w = getNormalizedPosition(playersPosition.getX(), playersPosition.getY());
        return w;
    }

    public Vector2d getPlayersPositionNormalized(int offsetX, int offsetY) {
        Vector2d w = getNormalizedPosition(playersPosition.getX() + offsetX, playersPosition.getY() + offsetY);
        return w;
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

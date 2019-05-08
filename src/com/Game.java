package com;

import fIgures.Brick;
import poziomy.PoziomPierwszy;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Game extends JPanel implements KeyListener {

    private Player player;
    private Poziom obecnyPoziom;
    private PoziomPierwszy poziomPierwszy;
    private Vector2d playersPosition;

    private static int scale;
    private static int relativeX;
    private static int relativeY;
    private static int gridSize;
    private static int brickSize;


    public static Vector2d getNormalizedPosition(int x, int y){
        Vector2d w = new Vector2d(x,y);

        w.setX(relativeX + x * gridSize - brickSize/2);
        w.setY(relativeY + y * gridSize - brickSize/2);

        return w;
    }


    public Game(int scale){
        this.scale = scale;
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        System.out.println(relativeX);
        gridSize = 16 * scale;
        brickSize = 16 * scale;

        player = new Player();
        poziomPierwszy = new PoziomPierwszy();
        obecnyPoziom = poziomPierwszy;
        playersPosition = obecnyPoziom.getStartingPoint();
    }

    public void paint(Graphics gr){
        relativeX = getWidth() / 2;
        relativeY = getHeight() / 2 + 24 * scale;

        super.paint(gr);//czyszczenie panelu

        gr.setColor(new Color(122, 77, 46));
        gr.fillRect(0,0,getWidth(), getHeight());

        poziomPierwszy.draw(this, gr);
        player.draw(this, gr);

        gr.dispose();
    }


    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            playersPosition.setX(playersPosition.getX() + 1);
        };
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            playersPosition.setX(playersPosition.getX() - 1);
        };
        if(e.getKeyCode() == KeyEvent.VK_UP){
            playersPosition.setY(playersPosition.getY() - 1);
        };
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            playersPosition.setY(playersPosition.getY() + 1);
        };


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
}

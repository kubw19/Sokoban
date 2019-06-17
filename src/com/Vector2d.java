package com;

import java.awt.*;

public class Vector2d {
    private int x, y;

    /**
     * konstruktor obiektu klasy Vector2d
     * @param x współrzędna x wektora
     * @param y współrzędna y wektora
     */
    public Vector2d(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * konstruktor obiektu klasy Vector2d
     * @param v klonowany obiekt klasy Vector2d
     */
    public Vector2d(Vector2d v){
        this.x = v.getX();
        this.y = v.getY();
    }

    /**
     * zmiana współrzędnej przy ruchu w górę
     */
    public void moveUp(){ y -= Game.getGridSize(); }
    /**
     * zmiana współrzędnej przy ruchu w dół
     */
    public void moveDown(){ y += Game.getGridSize(); }
    /**
     * zmiana współrzędnej przy ruchu w lewo
     */
    public void moveLeft(){ x -= Game.getGridSize(); }
    /**
     * zmiana współrzędnej przy ruchu w prawo
     */
    public void moveRight(){ x += Game.getGridSize(); }

    /**
     * zwraca aktualną współrzędną x
     * @return współrzędna x
     */
    public int getX() { return x; }

    /**
     * ustawia współrzęną x na wartość argumentu
     * @param x nowa wartość współrzędnej x
     */
    public void setX(int x) { this.x = x; }
    /**
     * zwraca aktualną współrzędną y
     * @return współrzędna y
     */
    public int getY() { return y; }
    /**
     * ustawia współrzęną y na wartość argumentu
     * @param y nowa wartość współrzędnej y
     */
    public void setY(int y) { this.y = y; }

    /**
     * porównanie dwóch obiektów klasy Vector2d
     * @param v obiekt porównywany z wywołującym
     * @return true jeśli obiekty są identyczne false w przeciwnym przypadku
     */
    public boolean equals(Vector2d v){
        if(v.getX() == x && v.getY() == y)return true;
        return false;
    }
}

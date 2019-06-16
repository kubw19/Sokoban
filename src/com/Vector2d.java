package com;

import java.awt.*;

public class Vector2d {
    private int x, y;
    public Vector2d(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Vector2d(Vector2d v){
        this.x = v.getX();
        this.y = v.getY();
    }
    public void moveUp(){
        y -= Game.getGridSize();
    }
    public void moveDown(){
        y += Game.getGridSize();
    }
    public void moveLeft(){
        x -= Game.getGridSize();
    }
    public void moveRight(){
        x += Game.getGridSize();
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public String toString(){
        return "(" + x + ", " + y +")";
    }

    public boolean equals(Vector2d v){
        if(v.getX() == x && v.getY() == y)return true;
        return false;
    }

    public static Vector2d toVector(Point point){
        return new Vector2d(point.x, point.y);
    }
}

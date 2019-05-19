package com;

public class Vector2d {
    private int x, y;
    public Vector2d(int x, int y){
        this.x = x;
        this.y = y;
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
}

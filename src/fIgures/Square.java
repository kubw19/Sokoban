package fIgures;
import com.Game;
import com.Vector2d;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Square{
    protected int size;
    protected BufferedImage texture;
    public Rectangle intersectionArea;
    private Graphics graphics;
    private Vector2d position;
    public String str = "asdasd";
    public Square(int size, Graphics gr, Vector2d position){
        this.size = size;
        this.graphics = gr;
        this.position = position;
    }

        public void draw(Graphics gr, Vector2d w){
        graphics = gr;
        intersectionArea = new Rectangle(w.getX(), w.getY(), size, size);
        this.position = w;
        graphics.drawImage(texture, w.getX(),w.getY(), size, size,null);
    }

    public void draw(Graphics gr){
        graphics = gr;
        intersectionArea = new Rectangle(position.getX(), position.getY(), size, size);
        graphics.drawImage(texture, position.getX(),position.getY(), size, size,null);
    }

    public String toString(){
        return "(" + position.getX() + ", " + position.getY() + ")";
    }
    public void setX(int x){
        this.position.setX(x);
    }
    public void setY(int y){
        this.position.setX(y);
    }
    public int getX(){
        return this.position.getX();
    }
    public int getY(){
        return this.position.getY();
    }
}

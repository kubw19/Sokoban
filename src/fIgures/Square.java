package fIgures;
import com.Game;
import com.Vector2d;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Square{
    protected int size;
    protected BufferedImage texture;
    public Rectangle intersectionArea;
    protected Graphics graphics;
    protected Vector2d position;
    protected Game game;
    public Square(int size, Vector2d position,Game game){
        this.size = size;
        this.position = position;
        this.game=game;
        this.intersectionArea = new Rectangle(position.getX(), position.getY(), size, size);
    }
    public void draw(Graphics gr, Vector2d w){
        this.graphics = gr;
        this.intersectionArea = new Rectangle(w.getX(), w.getY(), size, size);
        this.position = w;
        this.graphics.drawImage(texture, w.getX(),w.getY(), size, size,null);
    }
    public void draw(Graphics gr){
        this.graphics = gr;
        this.intersectionArea = new Rectangle(position.getX(), position.getY(), size, size);
        this.graphics.drawImage(texture, position.getX(),position.getY(), size, size,null);
    }
    public String toString(){
        return "(" + position.getX() + ", " + position.getY() + ")";
    }
    public void setX(int x){
        this.position.setX(x);
    }
    public void setY(int y){
        this.position.setY(y);
    }
    public int getX(){
        return this.position.getX();
    }
    public int getY(){
        return this.position.getY();
    }
    public Square collisionDetection(String dir){
        Rectangle newPosition = null;
        switch(dir) {
            case "UP":
                newPosition = new Rectangle(this.getX(), this.getY()-this.size, Game.getBrickSize(), Game.getBrickSize());
                break;
            case "DOWN":
                newPosition = new Rectangle(this.getX(), this.getY()+this.size, Game.getBrickSize(), Game.getBrickSize());
                break;
            case "RIGHT":
                newPosition = new Rectangle(this.getX()+this.size, this.getY(), Game.getBrickSize(), Game.getBrickSize());
                break;
            case "LEFT":
                newPosition = new Rectangle(this.getX()-this.size, this.getY(), Game.getBrickSize(), Game.getBrickSize());
                break;
        }
        Square temp=null;
        for(Square square : game.getObecnyPoziom().getObjects()){
            if(square.intersectionArea.intersects(newPosition)){
                temp=square;
            }
        }
        return temp;
     }

     public Vector2d getPosition(){
        return position;
     }
}

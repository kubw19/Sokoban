package fIgures;

import com.Game;
import com.Vector2d;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Box extends Square{
    private Game game;
    public Box(Graphics gr, int size, Vector2d position,Game game){
        super(size, gr, position);
        try {
            texture = ImageIO.read(new File("src/figures/resources/box.jpg"));
        }
        catch(IOException e){}
        this.game=game;
    }
    private int collisionDetection(String dir){
        Rectangle newPosition = null;
        switch(dir) {
            case "UP":
                newPosition = new Rectangle(this.getX(), this.getY()+this.size, Game.getBrickSize(), Game.getBrickSize());
                break;
            case "DOWN":
                newPosition = new Rectangle(this.getX(), this.getY()-this.size, Game.getBrickSize(), Game.getBrickSize());
                break;
            case "RIGHT":
                newPosition = new Rectangle(this.getX()+this.size, this.getY(), Game.getBrickSize(), Game.getBrickSize());
                break;
            case "LEFT":
                newPosition = new Rectangle(this.getX()-this.size, this.getY(), Game.getBrickSize(), Game.getBrickSize());
                break;
        }

        for(Square square : game.getObecnyPoziom().objects){
            if(square.intersectionArea.intersects(newPosition)){
                if(square instanceof Brick)
                    return -1;
            }
        }

        return 0;
    }
    public boolean moveUp() {
        if (collisionDetection("UP") == 0) {
            this.setY(this.getY() + this.size);
            return false;
        }
        return true;
    }

    public void moveDown(){
        if(collisionDetection("DOWN") == 0) {
            this.setY(this.getY() - this.size);
        }
    }

    public void moveRight(){
        if(collisionDetection("RIGHT") == 0)
            this.setX(this.getX() +this.size);
    }

    public boolean moveLeft(){
        if(collisionDetection("LEFT") == 0) {
            this.setX(this.getX() - this.size);
            return false;
        }
        return true;
    }
}

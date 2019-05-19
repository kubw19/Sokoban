package fIgures;

import com.Game;
import com.Vector2d;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Box extends Square{
    public Box(int size, Vector2d position,Game game){
        super(size, position,game);
        try {
            texture = ImageIO.read(new File("src/figures/resources/box.png"));
        }
        catch(IOException e){}
    }
    public boolean moveUp() {
        if (collisionDetection("UP") == null) {
            this.setY(this.getY() - this.size);
            return false;
        }
        else if(collisionDetection("UP") instanceof Target) {
            this.setY(this.getY() - this.size);
            return false;
        }
        return true;
    }

    public boolean moveDown(){
        if(collisionDetection("DOWN") == null) {
            this.setY(this.getY() + this.size);
            return false;
        }
        else if(collisionDetection("DOWN") instanceof Target) {
            this.setY(this.getY() + this.size);
            return false;
        }
        return true;
    }

    public boolean moveRight(){
        if(collisionDetection("RIGHT") == null) {
            this.setX(this.getX() + this.size);
            return false;
        }
        else if(collisionDetection("RIGHT") instanceof Target) {
            this.setX(this.getX() + this.size);
            return false;
        }
        return true;
    }

    public boolean moveLeft(){
        System.out.println("Typ" + collisionDetection("LEFT"));
        if(collisionDetection("LEFT") instanceof Brick) {
            System.out.println("CEGLA");
            //this.setX(this.getX() - this.size);
            return false;
        }
        else if(collisionDetection("LEFT") instanceof Target) {
            System.out.println("TARGER");
            position.moveLeft();
            return true;
        }
        position.moveLeft();
        return true;
    }
}

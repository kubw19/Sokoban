package fIgures;

import com.Game;
import com.Vector2d;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Box extends Square{
    public Box(Graphics gr, int size, Vector2d position,Game game){
        super(size, gr, position,game);
        try {
            texture = ImageIO.read(new File("src/figures/resources/box.png"));
        }
        catch(IOException e){}
    }
    public boolean moveUp() {
        if (collisionDetection("UP") == 0) {
            this.setY(this.getY() - this.size);
            return false;
        }
        if(collisionDetection("UP") == 1) {
            this.setY(this.getY() - this.size);
            return false;
        }
        return true;
    }

    public boolean moveDown(){
        if(collisionDetection("DOWN") == 0) {
            this.setY(this.getY() + this.size);
            return false;
        }
        if(collisionDetection("DOWN") == 1) {
            this.setY(this.getY() + this.size);
            return false;
        }
        return true;
    }

    public boolean moveRight(){
        if(collisionDetection("RIGHT") == 0) {
            this.setX(this.getX() + this.size);
            return false;
        }
        if(collisionDetection("RIGHT") == 1) {
            this.setX(this.getX() + this.size);
            return false;
        }
        return true;
    }

    public boolean moveLeft(){
        if(collisionDetection("LEFT") == 0) {
            this.setX(this.getX() - this.size);
            return false;
        }
        if(collisionDetection("LEFT") == 1) {
            this.setX(this.getX() - this.size);
            return false;
        }
        return true;
    }
}

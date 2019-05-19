package fIgures;

import com.Game;
import com.Vector2d;

import javax.imageio.ImageIO;
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
        System.out.println("Typ" + collisionDetection("UP"));
        if(collisionDetection("UP") instanceof Brick) {
            System.out.println("CEGLA");
            return false;
        }
        else if(collisionDetection("UP") instanceof Target) {
            System.out.println("TARGET");
            position.moveUp();
            return true;
        }
        position.moveUp();
        return true;
    }

    public boolean moveDown(){
        System.out.println("Typ" + collisionDetection("DOWN"));
        if(collisionDetection("DOWN") instanceof Brick) {
            System.out.println("CEGLA");
            return false;
        }
        else if(collisionDetection("DOWN") instanceof Target) {
            System.out.println("TARGET");
            position.moveDown();
            return true;
        }
        position.moveDown();
        return true;
    }

    public boolean moveRight(){
        System.out.println("Typ" + collisionDetection("RIGHT"));
        if(collisionDetection("RIGHT") instanceof Brick) {
            System.out.println("CEGLA");
            return false;
        }
        else if(collisionDetection("RIGHT") instanceof Target) {
            System.out.println("TARGER");
            position.moveRight();
            return true;
        }
        position.moveRight();
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

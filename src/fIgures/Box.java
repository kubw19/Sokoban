package fIgures;

import com.Game;
import com.Vector2d;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Box extends Square{
    private BufferedImage onTarget;
    public Box(int size, Vector2d position,Game game){
        super(size, position,game);
        try {
            texture = ImageIO.read(new File("src/figures/resources/box.png"));
            onTarget = ImageIO.read(new File("src/figures/resources/onTarget.png"));
        }
        catch(IOException e){}
    }
    public void draw(Graphics gr){

        this.graphics = gr;
        this.intersectionArea = new Rectangle(position.getX(), position.getY(), size, size);
        if(this.isOnTarget()){
            this.graphics.drawImage(onTarget, position.getX(),position.getY(), size, size,null);
        }else{
            this.graphics.drawImage(texture, position.getX(),position.getY(), size, size,null);
        }

    }
    public boolean moveUp() {
        System.out.println("Typ" + collisionDetection("UP"));
        if(collisionDetection("UP") instanceof Brick ||collisionDetection("UP") instanceof Box) {
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
        if(collisionDetection("DOWN") instanceof Brick||collisionDetection("DOWN") instanceof Box) {
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
        if(collisionDetection("RIGHT") instanceof Brick||collisionDetection("RIGHT") instanceof Box) {
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
        if(collisionDetection("LEFT") instanceof Brick||collisionDetection("LEFT") instanceof Box) {
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
    private boolean isOnTarget(){
        Rectangle newPosition = new Rectangle(this.getX(), this.getY(), Game.getBrickSize(), Game.getBrickSize());
        for(Square square : game.getObecnyPoziom().getObjects()) {
            if (square instanceof Target) {
                if (square.intersectionArea.intersects(newPosition)) {
                    return true;
                }
            }
        }
        return false;
    }
}

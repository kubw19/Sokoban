package fIgures;

import com.Game;
import com.Vector2d;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Player extends Square {
    private int moves = 0;
    protected String text;
    private TextureSet textureSet;
    public Player(Game game, int size, Vector2d position){
        super(size, position, game);
        this.textureSet=new TextureSet(this);
        texture = textureSet.getActive();


        text="left1";
    }

    public void moveUp(){
        textureSet.setActive("UP");
        texture = textureSet.getActive();
        System.out.println("Up: "+collisionDetection("UP"));
        Square square;
        if(!((square = collisionDetection("UP")) instanceof Brick)){
            if(square instanceof Box){
                System.out.println("mamy box");
                if((!((Box) square).moveUp()))return;
            }
            position.moveUp();
        }
    }

    public void moveDown() {
        textureSet.setActive("DOWN");
        texture = textureSet.getActive();
        System.out.println("Down: "+collisionDetection("DOWN"));
        Square square;
        if(!((square = collisionDetection("DOWN")) instanceof Brick)){
            if(square instanceof Box){
                System.out.println("mamy box");
                if((!((Box) square).moveDown()))return;
            }
            position.moveDown();
        }
    }
    public void moveRight() {
        textureSet.setActive("RIGHT");
        texture = textureSet.getActive();
        System.out.println("Right: "+collisionDetection("RIGHT"));
        Square square;
        if(!((square = collisionDetection("RIGHT")) instanceof Brick)){
            if(square instanceof Box){
                System.out.println("mamy box");
                if((!((Box) square).moveRight()))return;
            }
            position.moveRight();
        }
    }
    public void moveLeft(){
        textureSet.setActive("LEFT");
        texture = textureSet.getActive();
        System.out.println("Left: " + collisionDetection("LEFT"));
        Square square;
        if(!((square = collisionDetection("LEFT")) instanceof Brick)){
            if(square instanceof Box){
                System.out.println("mamy box");
                if((!((Box) square).moveLeft()))return;
            }
            position.moveLeft();
        }
    }
}

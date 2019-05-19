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
        System.out.println("Up: "+collisionDetection("UP"));
        Square square;
        if(!((square = collisionDetection("UP")) instanceof Brick)){
            if(square instanceof Box){
                System.out.println("mamy box");
                if((!((Box) square).moveUp()))return;
            }
            position.moveUp();
        }
        textureSet.setActive("UP");
        texture = textureSet.getActive();
    }

    public void moveDown() {
        System.out.println("Down: "+collisionDetection("DOWN"));
        Square square;
        if(!((square = collisionDetection("DOWN")) instanceof Brick)){
            if(square instanceof Box){
                System.out.println("mamy box");
                if((!((Box) square).moveDown()))return;
            }
            position.moveDown();
        }
        textureSet.setActive("DOWN");
        texture = textureSet.getActive();
    }
    public void moveRight() {
        System.out.println("Right: "+collisionDetection("RIGHT"));
        Square square;
        if(!((square = collisionDetection("RIGHT")) instanceof Brick)){
            if(square instanceof Box){
                System.out.println("mamy box");
                if((!((Box) square).moveRight()))return;
            }
            position.moveRight();
        }
        textureSet.setActive("RIGHT");
        texture = textureSet.getActive();
    }
    public void moveLeft(){
        System.out.println("Left: " + collisionDetection("LEFT"));
        Square square;
        if(!((square = collisionDetection("LEFT")) instanceof Brick)){
            if(square instanceof Box){
                System.out.println("mamy box");
                if((!((Box) square).moveLeft()))return;
            }
            position.moveLeft();
        }
        textureSet.setActive("LEFT");
        texture = textureSet.getActive();
        /*if(text=="left1"){
            try {
                texture = ImageIO.read(new File("src/figures/resources/left2.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            text="left2";
        }else {
            try {
                texture = ImageIO.read(new File("src/figures/resources/left1.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            text = "left1";
        }*/
    }
}

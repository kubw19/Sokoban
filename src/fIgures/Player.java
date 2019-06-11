package fIgures;

import com.Game;
import com.Vector2d;
public class Player extends Square {
    private int moves = 0;
    private TextureSet textureSet;

    public Player(Game game, int size, Vector2d position){
        super(size, position, game);
        this.textureSet=new TextureSet(this);
        texture = textureSet.getActive();
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
            moves++;
            System.out.println("moves: "+moves);
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
            moves++;
            System.out.println("moves: "+moves);
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
            moves++;
            System.out.println("moves: "+moves);
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
            moves++;
            System.out.println("moves: "+moves);
        }
    }
    public void resetMoves(){this.moves=0;}
}

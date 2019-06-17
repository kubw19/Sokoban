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

    /**
     * Konstruktor klasy Box tworzy obiekt skrzynki
     * @param size rozmiar Boxa w pixelach
     * @param position pozycja lewego górnego wierzchołka obietku na ekranie
     * @param game panel gry w którym ma być wyświetlony obiekt
     */
    public Box(int size, Vector2d position,Game game){
        super(size, position,game);
        try {
            texture = ImageIO.read(new File("src/figures/resources/box.png"));
            onTarget = ImageIO.read(new File("src/figures/resources/onTarget.png"));
        }
        catch(IOException e){}
    }

    /**
     * rysowanie obiektów na ekranie
     * @param gr
     */
    public void draw(Graphics gr){
        this.graphics = gr;
        this.intersectionArea = new Rectangle(position.getX(), position.getY(), size, size);
        if(this.isOnTarget()){
            this.graphics.drawImage(onTarget, position.getX(),position.getY(), size, size,null);
        }else{
            this.graphics.drawImage(texture, position.getX(),position.getY(), size, size,null);
        }
    }

    /**
     * żądanie przesunięcia obiektu w górę
     * @return true jeśli udało się przesunąć obiekt false jeśli droga jest zablokowana przez inny obiekt
     */
    public boolean moveUp() {
        if(collisionDetection("UP") instanceof Brick ||collisionDetection("UP") instanceof Box) return false;
        else if(collisionDetection("UP") instanceof Target) {
            position.moveUp();
            return true;
        }
        position.moveUp();
        return true;
    }
    /**
     * żądanie przesunięcia obiektu w dół
     * @return true jeśli udało się przesunąć obiekt false jeśli droga jest zablokowana przez inny obiekt
     */
    public boolean moveDown(){
        if(collisionDetection("DOWN") instanceof Brick||collisionDetection("DOWN") instanceof Box)return false;
        else if(collisionDetection("DOWN") instanceof Target) {
            position.moveDown();
            return true;
        }
        position.moveDown();
        return true;
    }
    /**
     * żądanie przesunięcia obiektu w prawo
     * @return true jeśli udało się przesunąć obiekt false jeśli droga jest zablokowana przez inny obiekt
     */
    public boolean moveRight(){
        if(collisionDetection("RIGHT") instanceof Brick||collisionDetection("RIGHT") instanceof Box) return false;
        else if(collisionDetection("RIGHT") instanceof Target) {
            position.moveRight();
            return true;
        }
        position.moveRight();
        return true;
    }
    /**
     * żądanie przesunięcia obiektu w lewo
     * @return true jeśli udało się przesunąć obiekt false jeśli droga jest zablokowana przez inny obiekt
     */
    public boolean moveLeft(){
        if(collisionDetection("LEFT") instanceof Brick||collisionDetection("LEFT") instanceof Box) return false;
        else if(collisionDetection("LEFT") instanceof Target) {
            position.moveLeft();
            return true;
        }
        position.moveLeft();
        return true;
    }

    private boolean isOnTarget(){
        Rectangle newPosition = new Rectangle(this.getX(), this.getY(), Game.getBrickSize(), Game.getBrickSize());
        for(Square square : game.getCurrentLevel().getObjects()) {
            if (square instanceof Target) {
                if (square.intersectionArea.intersects(newPosition)) {
                    return true;
                }
            }
        }
        return false;
    }
}

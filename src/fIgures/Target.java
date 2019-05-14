package fIgures;

import com.Game;
import com.Vector2d;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Target extends Square {
    private boolean occupied;
    public Target(Graphics gr, int size, Vector2d position, Game game){
        super(size, gr, position,game);
        try {
            texture = ImageIO.read(new File("src/figures/resources/target.jpg"));
            occupied=false;
        }
        catch(IOException e){}
    }
    private int isOccupied(){
        Rectangle newPosition = new Rectangle(this.getX(), this.getY(), Game.getBrickSize(), Game.getBrickSize());
        for(Square square : game.getObecnyPoziom().objects) {
            if (square instanceof Box) {
                if (square.intersectionArea.intersects(newPosition)) {
                    occupied = true;
                    return 0;
                }
            }
        }
        occupied=false;
        return 1;
    }
    public void draw(Graphics gr){
        graphics = gr;
        intersectionArea = new Rectangle(position.getX(), position.getY(), size, size);
        graphics.drawImage(texture, position.getX(),position.getY(), size, size,null);
        isOccupied();
        System.out.println(occupied);
    }
}

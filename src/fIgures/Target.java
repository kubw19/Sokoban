package fIgures;

import com.Game;
import com.Vector2d;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Target extends Square {
    private Game game;
    public Target(Graphics gr, int size, Vector2d position, Game game){
        super(size, gr, position);
        try {
            texture = ImageIO.read(new File("src/figures/resources/target.jpg"));
        }
        catch(IOException e){}
        this.game=game;
    }

}

package fIgures;

import com.Game;
import com.Vector2d;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class StartingPoint extends Square {

    public StartingPoint(int size, Vector2d position, Game game){
        super(size, position,game);
        try {
            texture = ImageIO.read(new File("src/figures/resources/startingPoint.png"));
        }
        catch(IOException e){}
    }
    public int getSize(){
        return size;
    }
}


package fIgures;

import com.Vector2d;
import com.Game;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Brick extends Square {
    public Brick(int size, Vector2d position,Game game){
        super(size, position,game);
        try {
            texture = ImageIO.read(new File("src/figures/resources/brick.png"));
        }
        catch(IOException e){}
    }

    public int getSize(){
        return size;
    }
}


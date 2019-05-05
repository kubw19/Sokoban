package fIgures;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Brick extends Square {
    public Brick(Graphics gr, int size){
        super(size, gr);
        try {
            texture = ImageIO.read(new File("src/figures/resources/brick.jpg"));
        }
        catch(IOException e){}
    }

    public int getSize(){
        return width;
    }
}


package fIgures;
import java.awt.*;

public class Square extends Figure {
    public Square(int size, Graphics gr){
        super(size, size, gr);
    }

    public void draw(int positionX, int positionY, boolean centered){
        if(centered){
            positionX -= width / 2;
            positionY -= height / 2;
        }
        graphics.drawImage(texture, positionX,positionY, width, height,null);
    }
}

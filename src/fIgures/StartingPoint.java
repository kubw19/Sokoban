package fIgures;

import com.Game;
import com.Vector2d;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class StartingPoint extends Square {
    /**
     * konstruktor klasy StartingPoint tworzy obiekt typu StartingPoint
     * @param size rozmiar Bricka w pixelach
     * @param position pozycja lewego górnego wierzchołka obietku na ekranie
     * @param game panel gry w którym ma być wyświetlony obiekt
     */
    public StartingPoint(int size, Vector2d position, Game game){
        super(size, position,game);
        try {
            texture = ImageIO.read(new File("src/figures/resources/startingPoint.png"));
        }
        catch(IOException e){}
    }
}


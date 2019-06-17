package fIgures;

import com.Vector2d;
import com.Game;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Klasa opisująca obiekt typu Brick. Jest to "cegła" wyznaczająca granice jednego poziomu
 */
public class Brick extends Square {
    /**
     * Konstruktor klasy Brick tworzy obiekt ściany
     * @param size rozmiar Bricka w pixelach
     * @param position pozycja lewego górnego wierzchołka obietku na ekranie
     * @param game panel gry w którym ma być wyświetlony obiekt
     */
    public Brick(int size, Vector2d position,Game game){
        super(size, position,game);
        try {
            texture = ImageIO.read(new File("src/figures/resources/brick.png"));
        }
        catch(IOException e){}
    }
}


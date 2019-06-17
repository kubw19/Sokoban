package fIgures;

import com.Game;
import com.Vector2d;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Klasa opisująca obiekt typu  Box. Jest to miejsce, w którym gracz musi umieścić skrzynkę
 */
public class Target extends Square {
    private boolean occupied;

    /**
     * konstruktor klasy Target tworzy obiekt typu Target
     * @param size rozmiar Bricka w pixelach
     * @param position pozycja lewego górnego wierzchołka obietku na ekranie
     * @param game panel gry w którym ma być wyświetlony obiekt
     */
    public Target(int size, Vector2d position, Game game){
        super(size, position,game);
        try {
            texture = ImageIO.read(new File("src/figures/resources/target.png"));
            occupied=false;
        } catch(IOException e){}
    }
    /**
     *sprawdza czy pole celu jest zajęte przez skrzynkę i ustawia flagę w skrzynce na true jeśli tak jest oraz na false w przeciwnym przypadku
     */
    public void isOccupied(){
        Rectangle newPosition = new Rectangle(this.getX(), this.getY(), Game.getBrickSize(), Game.getBrickSize());
        for(Square square : game.getCurrentLevel().getObjects()) {
            if (square instanceof Box) {
                if (square.intersectionArea.intersects(newPosition)) {
                    occupied = true;
                    return;
                }
            }
        }
        occupied=false;
        return;
    }
    /**
     * rysowanie obiektu na ekranie
     * @param gr
     */
    public void draw(Graphics gr){
        graphics = gr;
        intersectionArea = new Rectangle(position.getX(), position.getY(), size, size);
        graphics.drawImage(texture, position.getX(),position.getY(), size, size,null);
    }
    /**
     * sprawdzenie czy obiekt celu jest zajęty przez obiekt skrzynki
     * @return true jeśli jest zajęty, false w przeciwnym przypadku
     */
    public boolean getOccupied(){return occupied;}
}

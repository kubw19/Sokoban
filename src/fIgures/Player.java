package fIgures;

import com.Game;
import com.Vector2d;

/**
 * Klasa opisująca instancje gracza
 */
public class Player extends Square {
    private int moves = 0;
    private TextureSet textureSet;
    /**
     * Konstruktor klasy Player tworzy obiekt gracza
     * @param size rozmiar Playera w pixelach
     * @param position pozycja lewego górnego wierzchołka obietku na ekranie
     * @param game panel gry w którym ma być wyświetlony obiekt
     */
    public Player(Game game, int size, Vector2d position){
        super(size, position, game);
        this.textureSet=new TextureSet(this);
        texture = textureSet.getActive();
    }

    /**
     * metoda odpowiadająca za ruch gracza w górę.
     * W trakcie gry kontroluje kolizje i przesunięcia obiekt.
     * Podczas tworzenia poziomu porusza sie dowolnie.
     */
    public void moveUp(){
        textureSet.setActive("UP");
        texture = textureSet.getActive();
        Square square;
        if(!((square = collisionDetection("UP")) instanceof Brick)){
            if(square instanceof Box)
                if(!game.isCreatingLevel())
                    if((!((Box) square).moveUp()))return;
            position.moveUp();
            moves++;
        }
        else if(game.isCreatingLevel())
            position.moveUp();
    }
    /**
     * metoda odpowiadająca za ruch gracza w dół.
     * W trakcie gry kontroluje kolizje i przesunięcia obiekt.
     * Podczas tworzenia poziomu porusza sie dowolnie.
     */
    public void moveDown() {
        textureSet.setActive("DOWN");
        texture = textureSet.getActive();
        Square square;
        if(!((square = collisionDetection("DOWN")) instanceof Brick)){
            if(square instanceof Box)
                if(!game.isCreatingLevel())
                    if ((!((Box) square).moveDown())) return;
            position.moveDown();
            moves++;
        }
        else if(game.isCreatingLevel())
            position.moveDown();
    }
    /**
     * metoda odpowiadająca za ruch gracza w prawo.
     * W trakcie gry kontroluje kolizje i przesunięcia obiekt.
     * Podczas tworzenia poziomu porusza sie dowolnie.
     */
    public void moveRight() {
        textureSet.setActive("RIGHT");
        texture = textureSet.getActive();
        Square square;
        if(!((square = collisionDetection("RIGHT")) instanceof Brick)){
            if(square instanceof Box)
                if(!game.isCreatingLevel())
                    if((!((Box) square).moveRight()))return;
            position.moveRight();
            moves++;
        }

        else if(game.isCreatingLevel())
            position.moveRight();
    }
    /**
     * metoda odpowiadająca za ruch gracza w lewo.
     * W trakcie gry kontroluje kolizje i przesunięcia obiekt.
     * Podczas tworzenia poziomu porusza sie dowolnie.
     */
    public void moveLeft(){
        textureSet.setActive("LEFT");
        texture = textureSet.getActive();
        Square square;
        if(!((square = collisionDetection("LEFT")) instanceof Brick)){
            if(square instanceof Box)
                if(!game.isCreatingLevel())
                    if((!((Box) square).moveLeft()))return;
            position.moveLeft();
            moves++;
        }
        else if(game.isCreatingLevel())
            position.moveLeft();
    }

    /**
     * Funkcja zwracająca liczbę ruchów gracza w danym poziomie
     * @return int Liczba ruchów danego gracza
     */
    public int getMoves(){return this.moves;}
}

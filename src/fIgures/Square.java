package fIgures;
import com.Game;
import com.Vector2d;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Square{
    protected int size;
    protected BufferedImage texture;
    public Rectangle intersectionArea;
    protected Graphics graphics;
    protected Vector2d position;
    protected Game game;
    /**
     * konstruktor obiektu generycznej klasy Square
     * @param size rozmiar obiektu w pixelach
     * @param position pozycja lewego górnego wierzchołka obietku na ekranie
     * @param game panel gry w którym ma być wyświetlony obiekt
     */
    public Square(int size, Vector2d position,Game game){
        this.size = size;
        this.position = position;
        this.game=game;
        this.intersectionArea = new Rectangle(position.getX(), position.getY(), size, size);
    }
    /**
     * rysuje obiekt
     * @param gr
     */
    public void draw(Graphics gr){
        this.graphics = gr;
        this.intersectionArea = new Rectangle(position.getX(), position.getY(), size, size);
        this.graphics.drawImage(texture, position.getX(),position.getY(), size, size,null);
    }

    /**
     * @return współrzędna x pozycji obiektu
     */
    public int getX(){ return this.position.getX(); }

    /**
     * @return współrzędna y pozycji obiektu
     */
    public int getY(){ return this.position.getY(); }

    /**
     * wykrywa czy po ruchu we wskazanym kierunku zajdzie kolizja z innym obiektem
     * @param dir kierunek sprawdzania kolizji "UP","DOWN","LEFT","RIGHT"
     * @return zwraca obiekt z którym zachodzi kolizja lub null jeśli brak kolizji
     */
    public Square collisionDetection(String dir){
        Rectangle newPosition = null;
        switch(dir) {
            case "UP":
                newPosition = new Rectangle(this.getX(), this.getY()-this.size, Game.getBrickSize(), Game.getBrickSize());
                break;
            case "DOWN":
                newPosition = new Rectangle(this.getX(), this.getY()+this.size, Game.getBrickSize(), Game.getBrickSize());
                break;
            case "RIGHT":
                newPosition = new Rectangle(this.getX()+this.size, this.getY(), Game.getBrickSize(), Game.getBrickSize());
                break;
            case "LEFT":
                newPosition = new Rectangle(this.getX()-this.size, this.getY(), Game.getBrickSize(), Game.getBrickSize());
                break;
        }
        Square temp=null;
        for(Square square : game.getObecnyPoziom().getObjects()){
            if(square.intersectionArea.intersects(newPosition))temp=square;
        }
        return temp;
     }

    /**
     * @return pozycja obiektu przechowywana w obiekcie typu Vector2d
     */
     public Vector2d getPosition(){
        return position;
     }
}

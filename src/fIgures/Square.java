package fIgures;
import com.Vector2d;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Square{
    protected int size;
    protected BufferedImage texture;
    private Graphics graphics;
    public Square(int size, Graphics gr){
        this.size = size;
        this.graphics = gr;
    }

    public void draw(Vector2d w){
        graphics.drawImage(texture, w.getX(),w.getY(), size, size,null);
    }
}

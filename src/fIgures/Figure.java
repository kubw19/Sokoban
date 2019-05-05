package fIgures;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Figure {
    protected int width;
    protected int height;
    BufferedImage texture;
    Graphics graphics;

    public Figure(int width, int height, Graphics gr){
        this.width = width;
        this.height = height;
        this.graphics = gr;
    }

    public void draw(int positionX, int positionY){
        graphics.drawImage(texture, positionX,positionY,null);
    }
}

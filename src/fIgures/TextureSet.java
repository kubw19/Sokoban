package fIgures;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TextureSet {
    private Player player;
    private BufferedImage activeImage;
    private BufferedImage image[] = new BufferedImage[16];

    /**
     * konstruktor klasy TextureSet. Tworzy obiekt tyou TextureSet
     * zawiera wszystkie grafiki używane do animacji gracza
     * @param player gracz którego animacje przechowuje ten obiekt
     */
    public TextureSet(Player player) {
        String active[] = {"up1", "up2", "up1_push", "up2_push",
                "down1", "down2", "down1_push", "down2_push",
                "left1", "left2", "left1_push", "left2_push",
                "right1", "right2", "right1_push", "right2_push"};
        for (int i = 0; i < 16; i++) {
            try {
                image[i] = ImageIO.read(new File("src/figures/resources/" + active[i] + ".png"));
            } catch (IOException e) {
            }
        }

        activeImage = image[0];
        this.player = player;
    }

    /**
     * zwraca aktywną grafikę dla gracza
     * @return BufferedImage z aktywną grafiką dla nowej klatki animacji
     */
    public BufferedImage getActive() {return activeImage; }
    /**
     * ustawia nową aktywną grafikę dla gracza zależną od kierunku ruchu i obecnej aktywnej grafiki
     * @param dir kierunek ruchu w formacie String "UP", "DOWN","LEFT", "RIGHT"
     */
    public void setActive(String dir) {
        Square collider = player.collisionDetection(dir);
        switch (dir) {
            case "UP":
                setNewActive(0, collider);
                break;
            case "DOWN":
                setNewActive(1,collider);
                break;
            case "LEFT":
                setNewActive(2,collider);
                break;
            case "RIGHT":
                setNewActive(3,collider);
                break;
        }
    }
    private void setNewActive(int i, Square collider) {
        i=i*4;
        if (collider==null) {
            if (activeImage == image[i]) {
                activeImage = image[i + 1];
            } else {
                activeImage = image[i];
            }
        } else {
            if (activeImage == image[i + 2]) {
                activeImage = image[i + 3];
            } else {
                activeImage = image[i + 2];
            }
        }
    }
}
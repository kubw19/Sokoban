package com;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TextureSet {
    private Player player;
    private BufferedImage activeImage;
    private BufferedImage image[] = new BufferedImage[16];

    public TextureSet(Player player) {
        String active[] = {"left1", "left2", "left1_push", "left2_push",
                "up1", "up2", "up1_push", "up2_push",
                "down1", "down2", "down1_push", "down2_push",
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

    public BufferedImage getActive() {
        return activeImage;
    }

    public void setActive(String dir) {
        int collider = player.collisionDetection(dir);
        switch (dir) {
            case "UP":
                setNewActive(1, collider);
                break;
            case "DOWN":
                setNewActive(2,collider);
                break;
            case "LEFT":
                setNewActive(0,collider);
                break;
            case "RIGHT":
                setNewActive(3,collider);
                break;
        }
    }

    public void setNewActive(int i, int collider) {
        i=i*4;
        if (collider == 0) {
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
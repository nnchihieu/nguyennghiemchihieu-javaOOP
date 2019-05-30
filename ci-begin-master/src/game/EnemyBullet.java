package game;

import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EnemyBullet {
    BufferedImage image;
    Vector2D position;

    public EnemyBullet() {
        image = SpriteUtils.loadImage("assets/images/enemies/bullets/blue.png");
        position = new Vector2D();
    }

    public void render(Graphics g) {
        g.drawImage(image, (int) position.x, (int) position.y, null);
    }
    public void run () {
        position.y += 5;
        }
    }


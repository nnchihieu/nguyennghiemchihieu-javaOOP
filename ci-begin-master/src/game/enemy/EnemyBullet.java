package game.enemy;

import game.GameObject;
import game.Settings;
import game.Vector2D;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EnemyBullet extends GameObject {

    public EnemyBullet() {
        image = SpriteUtils.loadImage("assets/images/enemies/bullets/blue.png");
    }

    public void render(Graphics g) {
        g.drawImage(image, (int) position.x, (int) position.y, null);
    }
    @Override
    public void run () {
        position.y += Settings.ENEMY_BULLET_SPEED;
        }
    }


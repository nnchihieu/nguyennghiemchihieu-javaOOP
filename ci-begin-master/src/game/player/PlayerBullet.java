package game.player;

import game.GameObject;
import game.Settings;
import game.Vector2D;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerBullet extends GameObject {

    public PlayerBullet() {
        image = SpriteUtils.loadImage("assets/images/player-bullets/a/1.png");
    }

    public void render(Graphics g) {g.drawImage(image, (int)position.x, (int)position.y, null);
    }
    @Override
    public void run() {
        position.y -= Settings.PLAYER_BULLET_SPEED;
    }
}

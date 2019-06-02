package game.player;
import game.GameObject;
import game.KeyEventPress;
import game.Settings;
import game.Vector2D;
import tklibs.Mathx;
import tklibs.SpriteUtils;

import java.awt.*;
import java .awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject {
//    ArrayList<PlayerBullet> bullets;
//    public BufferedImage getImage() {
//        return image;
//    }
//    public void setImage(BufferedImage image) {
//        if(image == null) {
//            return;
//        }
//        this.image = image;
//    }

    public Player() {
        image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        position.set(Settings.PLAYER_START_WIDTH, Settings.PLAYER_START_HEIGHT);
    }
    @Override
    public void run() {
        this.move();
        this.limitPositon();
        this.fire();

    }
    int count = 0;
    private void fire() {
        count++;
        if(KeyEventPress.isFirePress && count > 10) {
            PlayerBullet bullet = new PlayerBullet();
            bullet.position.set(this.position.x, this.position.y);
            PlayerBullet bullet2 = new PlayerBullet();
            bullet2.position.set(this.position.x-20, this.position.y);
            PlayerBullet bullet3 = new PlayerBullet();
            bullet3.position.set(this.position.x+20, this.position.y);
            PlayerBullet bullet4 = new PlayerBullet();
            bullet4.position.set(this.position.x+10, this.position.y);
            PlayerBullet bullet5 = new PlayerBullet();
            bullet5.position.set(this.position.x-10, this.position.y);
            count = 0;
        }
    }


    private void limitPositon() {
        position.x = Mathx.clamp(position.x, 0, Settings.BACKGROUND_WIDTH- Settings.PLAYER_WIDTH);
        position.y = Mathx.clamp(position.y, 0, Settings.BACKGROUND_HEIGHT-Settings.PLAYER_HEIGHT);
    }

    public void move() {
        if(KeyEventPress.isUpPress) {
            position.y -= Settings.PLAYER_SPEED;
        }
        if(KeyEventPress.isDownPress) {
            position.y += Settings.PLAYER_SPEED;
        }
        if(KeyEventPress.isLeftPress) {
            position.x -= Settings.PLAYER_SPEED;
        }
        if(KeyEventPress.isRightPress) {
            position.x += Settings.PLAYER_SPEED;
        }
    }
}



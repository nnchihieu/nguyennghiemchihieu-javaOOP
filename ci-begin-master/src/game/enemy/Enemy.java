package game.enemy;

import game.GameObject;
import game.Settings;
import game.Vector2D;
import tklibs.Mathx;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends GameObject/*extends GameObject*/{
//    ArrayList<EnemyBullet> bullets;

    public Enemy() {
        image = SpriteUtils.loadImage("assets/images/enemies/level0/black/0.png");
        position.set(Mathx.random(0, Settings.ENEMY_MAX_WIDTH), 0);

    }

    @Override
    public void run() {
        this.move();
        this.fire();
    }

    public void move() {
        position.y += 3;
        if (position.y > Settings.GAME_HEIGHT) {
            position.y = -50;
            position.x = Mathx.random(0, Settings.ENEMY_MAX_WIDTH);
        }
    }
    int count = 0;
    public void fire(){
        count++;
        if(count > 20){
            EnemyBullet bullet = new EnemyBullet();
            bullet.position.set(this.position.x, this.position.y);
            count = 0;
        }
    }

}




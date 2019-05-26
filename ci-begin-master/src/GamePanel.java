import tklibs.Mathx;
import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class GamePanel extends JPanel {
    BufferedImage playerImage;
//    int playerX;
//    int playerY;
    Vector2D playerPosition;
    BufferedImage backgroundImage;
//    int backgroundX;
//    int backgroundY;
    Vector2D backgroundPosition;
//    BufferedImage bulletImage;
//    int bulletX;
//    int bulletY;
    BufferedImage enemyImage;
//    int enemyX;
//    int enemyY;
    Vector2D enemyPosition;
    double fps;
    public GamePanel() {
        backgroundImage = SpriteUtils.loadImage("assets/images/background/0.png");
//        backgroundX = 0;
//        backgroundY = 600 - 3109;
        backgroundPosition = new Vector2D(0, 600 -3109);
        playerImage = SpriteUtils.loadImage("assets/images/players/straight/0.png");
//        playerX = 200;
//        playerY = 300;
        playerPosition = new Vector2D(200, 300);
        enemyImage = SpriteUtils.loadImage("assets/images/enemies/level0/black/0.png");
        enemyPosition = new Vector2D(200,250);
        enemyPosition.x = Mathx.random(0, 360);
        enemyPosition.y = -50;
//        bulletImage = SpriteUtils.loadImage("assets/images/enemies/bullets/white.png");
//        bulletX = 200;
//        bulletY = 250;
        fps = 0;
    }

    @Override
    public void paint(Graphics g) {
//        super.paint(g); //JPanel.paint()
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 800, 600);

        g.drawImage(backgroundImage, (int)backgroundPosition.x, (int)backgroundPosition.y, null);
        g.drawImage(playerImage, (int)playerPosition.x, (int)playerPosition.y, null);
//        g.drawImage(bulletImage, bulletX, bulletY, null);
        g.drawImage(enemyImage, (int)enemyPosition.x, (int)enemyPosition.y, null);
        g.setColor(Color.RED);
        g.drawString("fps " + fps, 700, 40);
    }

    public void runAll() {
        //background run
        //move
        backgroundPosition.y += 10;
        //limit position
        if(backgroundPosition.y >= 0) {
            backgroundPosition.y = 0;
        }
        //enemy run
        enemyPosition.y += 3;
        if(enemyPosition.y > 600) {
            enemyPosition.y = -50;
            enemyPosition.x = Mathx.random(0, 360);
        }
        //player run
        if(KeyEventPress.isUpPress) {
            playerPosition.y -= 2;
        }
        if(KeyEventPress.isDownPress) {
            playerPosition.y += 2;
        }
        if(KeyEventPress.isLeftPress) {
            playerPosition.x -= 2;
        }
        if(KeyEventPress.isRightPress) {
            playerPosition.x += 2;
        }

//        if(playerX < 0) {
//            playerX = 0;
//        }
//        if(playerX > 384 - 32) {
//            playerX = 384 - 32;
//        }
        playerPosition.x = Mathx.clamp(playerPosition.x, 0, 384 - 32);
        playerPosition.y = Mathx.clamp(playerPosition.y, 0, 600 - 48);
    }

    public void gameLoop() {
//        repaint() >> paint()
        long lastTime = 0;
        long delay = 1000 / 60; //~17
        while(true) {
            long currentTime = System.currentTimeMillis();
            if(currentTime - lastTime > delay) {
                fps = 1000 / (currentTime - lastTime);
                repaint(); // call paint()
                runAll();
                lastTime = currentTime;
            }
        }
    }
}
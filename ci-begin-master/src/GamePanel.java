import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel {
    BufferedImage playerImage;
    int playerX;
    int playerY;
    BufferedImage backgroundImage;
    int backgroundX;
    int backgroundY;
    BufferedImage bulletImage;
    int bulletX;
    int bulletY;
    BufferedImage enemyImage;
    int enemyX;
    int enemyY;
    double fps;
    public GamePanel() {
        backgroundImage = SpriteUtils.loadImage("assets/images/background/0.png");
        backgroundX = 0;
        backgroundY = 600 - 3109;
        playerImage = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        playerX = 200;
        playerY = 300;
        enemyImage = SpriteUtils.loadImage("assets/images/enemies/level0/black/0.png");
        enemyX = 200;
        enemyY = 50;
        bulletImage = SpriteUtils.loadImage("assets/images/enemies/bullets/white.png");
        bulletX = 200;
        bulletY = 250;
        fps = 0;
    }

    @Override
    public void paint(Graphics g) {
//        super.paint(g); //JPanel.paint()
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 800, 600);

        g.drawImage(backgroundImage, backgroundX, backgroundY, null);
        g.drawImage(playerImage, playerX, playerY, null);
        g.drawImage(bulletImage, bulletX, bulletY, null);
        g.drawImage(enemyImage, enemyX, enemyY, null);
        g.setColor(Color.RED);
        g.drawString("fps" + fps, 700, 40);
    }

    public void runAll(int i) {
        //background run
        //move
        backgroundY += 10;
        //limit position
        if(backgroundY >= 0) {
            backgroundY = 600 - 3109;
        }
        if (i % 2 == 0) {
            enemyX = 100;
            enemyY = 10;
        }
        else {
            enemyX = 150;
            enemyY = 30;
            if (i % 3 == 0) {
                enemyY = 20;
                enemyX = 250;
            }
        }
    }

    public void gameLoop() {
//        repaint() >> paint()
        long lastTime = 0;
        int i = 0;
        long delay = 1000 / 10; //~17
        while(true) {
            long currentTime = System.currentTimeMillis();
            if(currentTime - lastTime > delay) {
                fps = 1000 / (currentTime - lastTime);
                repaint(); // call paint()
                runAll(i);
                lastTime = currentTime;
                i++;
            }
        }
    }
}
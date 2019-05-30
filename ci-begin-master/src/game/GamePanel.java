package game;

import tklibs.Mathx;
import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel {
    Player player;
    Background background;
    Enemy enemy;

    double fps;

    public GamePanel() {
        player = new Player();
        background = new Background();
        enemy = new Enemy();
        fps = 0;
    }

    @Override
    public void paint(Graphics g) {
//        super.paint(g); //JPanel.paint()
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 800, 600);
        background.render(g);
        player.render(g);
        enemy.render(g);
        g.setColor(Color.RED);
        g.drawString("fps " + fps, 700, 40);
    }

    public void runAll() {
        //background run
        background.run();
        //enemy run
        enemy.run();
        //player run
        player.run();
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
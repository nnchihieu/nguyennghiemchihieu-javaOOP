package game;

import game.enemy.Enemy;
import game.player.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    Player player;
    Background background;
    Enemy enemy;

    double fps;

    public GamePanel() {
        background = new Background();
        player = new Player();
        enemy = new Enemy();
        fps = 0;
    }

    @Override
    public void paint(Graphics g) {
//        super.paint(g); //JPanel.paint()
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, Settings.GAME_WIDTH, Settings.GAME_HEIGHT);
//        background.render(g);
//        player.render(g);
//        enemy.render(g);
        GameObject.renderAll(g);
        g.setColor(Color.RED);
        g.drawString("fps " + fps, 700, 40);
    }

    public void runAll() {
//        //background run
//        background.run();
//        //enemy run
//        enemy.run();
//        //player run
//        player.run();
        GameObject.runAll();
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
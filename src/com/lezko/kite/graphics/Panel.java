package com.lezko.kite.graphics;

import com.lezko.kite.components.*;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by uleziko_t_a on 26.09.2022.
 */
public class Panel extends JPanel {

    private Timer timer;

    private Ground ground;
    private Kite kite;
    private Lamp lamp;
    private Rain rain;
    private Station station;
    private Lightning lightning;

    private int width, height;
    private boolean lightningState = false;
    private int lightningTime = 0, lightningDuration = 100;

    public Panel(int width, int height) {
        this.width = width;
        this.height = height;
        setPreferredSize(new Dimension(width, height));

        ground = new Ground(0, height / 4 * 3);

        station = new Station(50, 500);
        kite = new Kite(100, 100, Color.blue);
        lamp = new Lamp(50, 420);
        rain = new Rain(0, 0);
        lightning = new Lightning(width / 4, height / 5);

        initTimer(10);
    }

    private void initTimer(int period) {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                repaint();
            }
        }, 0, period);
    }

    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    private void updateComponents(Graphics2D g) {
        g.setColor(Color.lightGray);
        g.fillRect(0, 0, width, height);

        ground.setSize(width, height / 4);
        ground.draw(g);

        if (lightningTime == lightningDuration) {
            lightningTime = 0;
            lightningState = false;
        }

        if (lightningState) {
            lightningTime++;
        } else {
            lightningState = ((int) (Math.random() * 100)) == 50;
        }

        lightning.setSize(width / 2, height / 2);
        if (lightningState) {
            lightning.draw(g);
        }
        g.setStroke(new BasicStroke());

        station.setSize(width / 4, height / 10);
        station.draw(g);

        kite.setSize(width / 3, height / 3);
        kite.setFlowRect(width / 3, 0, width / 3, height / 3);
        kite.update();
        kite.draw(g);

        g.setColor(lightningState ? Color.yellow : Color.black);
        g.drawLine(station.getX() + station.getWidth(), station.getY(), kite.getX(), kite.getY() + kite.getHeight());

        lamp.setSize(width / 9, height / 8);
        lamp.setState(lightningState);
        lamp.draw(g);

        rain.setSize(width, height);
        rain.update(g);

        getToolkit().sync();
    }

    public void paintComponent(Graphics graphics) {
        updateComponents((Graphics2D) graphics);
    }
}

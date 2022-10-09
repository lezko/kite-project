package com.lezko.kite.components;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Rain extends MyComponent {

    private int x, y;
    private List<Drop> drops = new LinkedList<>();
    private List<Drop> failedDrops = new LinkedList<>();

    private int currentTime = 0, dropGenerationTime = 1;

    public Rain(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void update(Graphics2D g) {
        currentTime++;
        if (currentTime == dropGenerationTime) {
            currentTime = 0;
            int randomX = (int) (Math.random() * getWidth()) - 100;
            drops.add(new Drop(randomX, 1));
        }


        for (Drop drop : drops) {
            drop.fall();
            if (drop.getY() > getHeight()) {
                failedDrops.add(drop);
            } else {
                drop.draw(g);
            }
        }
        for (Drop drop : failedDrops) {
            drops.remove(drop);
        }
        failedDrops.clear();
    }

    @Override
    public void setSize(int width, int height) {
        super.setSize(width, height);
        for (Drop drop : drops) {
            drop.setSize(width / 100, height / 30);
        }
    }
}

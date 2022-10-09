package com.lezko.kite.components;

import java.awt.*;

public class Drop extends MyComponent {

    private double x, y;

    public Drop(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void fall() {
        x += getWidth() / 5.0;
        y += getHeight() / 5.0;
    }

    public void draw(Graphics2D g) {
        g.setColor(Color.gray);
        g.drawLine((int) x, (int) y, (int) x + getWidth(), (int) y + getHeight());
    }

    public int getY() {
        return (int) y;
    }
}

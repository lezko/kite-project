package com.lezko.kite.components;

import java.awt.*;

public class Station extends MyComponent {

    private int x, y;

    public Station(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fillRect(x, y, getWidth(), getHeight());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

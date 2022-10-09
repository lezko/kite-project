package com.lezko.kite.components;

import java.awt.*;

public class Ground extends MyComponent {

    private int x, y;

    public Ground(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics2D g) {
        g.setColor(new Color(18, 75, 35));
        g.fillRect(x, y, getWidth(), getHeight());
    }
}

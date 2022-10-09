package com.lezko.kite.components;

import java.awt.*;

public class Lightning extends MyComponent {

    private int x, y;

    public Lightning(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics2D g) {
        g.setColor(Color.cyan);
        g.setStroke(new BasicStroke(7));
        g.drawLine(x, y + getHeight(), x + getWidth() / 3, y + getHeight() / 3);
        g.drawLine(x + getWidth() / 3, y + getHeight() / 3, x + getWidth() / 2, y + getHeight() / 2);
        g.drawLine(x + getWidth() / 2, y + getHeight() / 2, x + getWidth(), y);
    }
}

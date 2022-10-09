package com.lezko.kite.components;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class Lamp extends MyComponent {

    private int x, y;
    private Color color = Color.yellow;

    public Lamp(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics2D g) {
        g.setColor(color);
        int a = getWidth() / 10, b = getHeight() / 10;
        int circleHeight = (int) (getHeight() / 1.3);
        g.fillOval(x, y, getWidth(), circleHeight);

        g.setColor(Color.gray);
        GeneralPath shape = new GeneralPath();

        shape.moveTo(x + 2 * a, y + circleHeight - b);
        shape.lineTo(x + 8 * a, y + circleHeight - b);
        shape.lineTo(x + 8 * a, y + 9 * b);
        shape.lineTo(x + getWidth() / 2.0, y + getHeight());
        shape.lineTo(x + 2 * a, y + 9 * b);
        shape.closePath();

        g.fill(shape);
    }

    public void setState(boolean isOn) {
        color = isOn ? Color.yellow : Color.white;
    }
}

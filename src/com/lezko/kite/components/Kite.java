package com.lezko.kite.components;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class Kite {

    private int x, y, width, height;
    private Color color;

    public Kite(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void draw(Graphics2D g) {
        GeneralPath shape = new GeneralPath();
        int a = width / 10, b = height / 10;

        shape.moveTo(x + 0, y + 2 * b);
        shape.lineTo(x + 2 * a, y + 0);
        shape.lineTo(x + 6 * a, y + 0);
        shape.lineTo(x + 10 * a, y + 6 * b);
        shape.lineTo(x + 8 * a, y + 8 * b);
        shape.lineTo(x + 5 * a, y + 8 * b);
        shape.closePath();

        g.fill(shape);

        // drawing tail
        // todo draw tail in loop
    }

    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }
}

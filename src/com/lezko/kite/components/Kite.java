package com.lezko.kite.components;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class Kite {

    private final int TAIL_ELEMENT_SIZE = 20;

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

        // Drawing base shape
        GeneralPath shape = new GeneralPath();
        int a = width / 10, b = height / 10;

        shape.moveTo(x + 0, y + 2 * b);
        shape.lineTo(x + 2 * a, y + 0);
        shape.lineTo(x + 6 * a, y + 0);
        shape.lineTo(x + 10 * a, y + 6 * b);
        shape.lineTo(x + 8 * a, y + 8 * b);
        shape.lineTo(x + 5 * a, y + 8 * b);
        shape.closePath();

        g.setColor(color);
        g.fill(shape);

        // Drawing connecting threads
        g.setColor(Color.black);
        g.drawLine(x + 0, y + height, x + 2 * a, y + 2 * b);
        g.drawLine(x + 0, y + height, x + 5 * a, y + 1 * b);
        g.drawLine(x + 0, y + height, x + 5 * a, y + 7 * b);
        g.drawLine(x + 0, y + height, x + 8 * a, y + 6 * b);

        // drawing tail
        g.setColor(Color.green);
        int tailX = x + 8 * a, tailY = y + 8 * b, tailDX = width / 17, tailDY = height / 14;
        for (int i = 0; i < 10; i++) {
            g.fillOval(tailX, tailY, TAIL_ELEMENT_SIZE, TAIL_ELEMENT_SIZE);
            tailX += tailDX;
            tailY += tailDY;
        }
    }

    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }
}

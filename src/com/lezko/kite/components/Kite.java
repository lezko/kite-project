package com.lezko.kite.components;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class Kite extends MyComponent {

    private final int TAIL_ELEMENT_SIZE = 20;

    private int x, y;
    private Color color;

    private int[] flowRect = new int[4];
    private double currX, currY, targetX, targetY, dx, dy;
    private final double E = 1e-5;

    public Kite(int x, int y, Color color) {
        this.x = x;
        this.y = y;

        currX = targetX = x;
        currY = targetY = y;
        this.color = color;
    }

    public void update() {
        if (targetX - currX < E && currY - targetY < E) {
            double[] randomTarget = getRandomTarget();
            targetX = randomTarget[0];
            targetY = randomTarget[1];

            dx = (targetX - currX) / 150;
            dy = (targetY - currY) / 150;
        }

        currX += dx;
        currY += dy;

        x = (int) currX;
        y = (int) currY;
    }

    private double[] getRandomTarget() {
        double randomX = flowRect[0] + Math.random() * flowRect[2];
        double randomY = flowRect[1] + Math.random() * flowRect[3];
        return new double[]{randomX, randomY};
    }

    public void draw(Graphics2D g) {
         // Drawing base shape
        GeneralPath shape = new GeneralPath();
        int a = getWidth() / 10, b = getHeight() / 10;

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
        g.drawLine(x + 0, y + getHeight(), x + 2 * a, y + 2 * b);
        g.drawLine(x + 0, y + getHeight(), x + 5 * a, y + 1 * b);
        g.drawLine(x + 0, y + getHeight(), x + 5 * a, y + 7 * b);
        g.drawLine(x + 0, y + getHeight(), x + 8 * a, y + 6 * b);

        // Drawing tail
        g.setColor(Color.green);
        int tailX = x + 8 * a, tailY = y + 8 * b, tailDX = getWidth() / 17, tailDY = getHeight() / 14;
        for (int i = 0; i < 10; i++) {
            g.fillOval(tailX, tailY, TAIL_ELEMENT_SIZE, TAIL_ELEMENT_SIZE);
            tailX += tailDX;
            tailY += tailDY;
        }
    }

    public void setFlowRect(int x, int y, int width, int height) {
        flowRect = new int[]{x, y, width, height};
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

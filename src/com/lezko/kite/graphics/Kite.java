package com.lezko.kite.graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;

/**
 * Created by uleziko_t_a on 26.09.2022.
 */
public class Kite extends JComponent {

    private int x;
    private int y;

    private int width;
    private int height;

    private final int DEFAULT_WIDTH = 100;
    private final int DEFAULT_HEIGHT = 100;

    public Kite(int x, int y) {
        this.x = x;
        this.y = y;

        width = DEFAULT_WIDTH;
        height = DEFAULT_HEIGHT;

        setPreferredSize(new Dimension(width, height));
        update();
    }

    public void update() {
        setBounds(x, y, width, height);
    }

    public void draw(Graphics2D g) {
        GeneralPath shape = new GeneralPath();
        shape.moveTo(0, 0);
    }

    public void paintComponent(Graphics g) {
        draw((Graphics2D) g);
    }
}

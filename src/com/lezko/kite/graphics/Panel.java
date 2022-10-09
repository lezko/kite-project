package com.lezko.kite.graphics;

import com.lezko.kite.components.Kite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * Created by uleziko_t_a on 26.09.2022.
 */
public class Panel extends JPanel {

    private Kite kite;

    private int width, height;

    public Panel(int width, int height) {
        this.width = width;
        this.height = height;
        setPreferredSize(new Dimension(width, height));

        kite = new Kite(100, 100, width / 3, height / 3, Color.blue);

    }

    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    private void updateComponents(Graphics2D g) {
        kite.setSize(width / 3, height / 3);
        kite.draw(g);
    }

    public void paintComponent(Graphics graphics) {
        updateComponents((Graphics2D) graphics);
    }
}

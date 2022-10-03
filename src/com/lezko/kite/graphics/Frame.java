package com.lezko.kite.graphics;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * Created by uleziko_t_a on 26.09.2022.
 */
public class Frame extends JFrame {

    private Panel panel;

    public Frame(int width, int height) {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(width, height);

        panel = new Panel(600, 600);
        add(panel);
        pack();

        setVisible(true);

        initResizeListener();
    }

    private void initResizeListener() {
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                panel.setSize(getWidth(), getHeight());
                panel.repaint();
            }
        });
    }
}

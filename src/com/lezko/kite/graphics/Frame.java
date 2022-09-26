package com.lezko.kite.graphics;

import javax.swing.*;

/**
 * Created by uleziko_t_a on 26.09.2022.
 */
public class Frame extends JFrame {

    private Panel panel;

    public Frame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new Panel());
        pack();
        setVisible(true);
    }
}

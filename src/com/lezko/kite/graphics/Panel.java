package com.lezko.kite.graphics;

import javax.swing.*;
import java.awt.*;

/**
 * Created by uleziko_t_a on 26.09.2022.
 */
public class Panel extends JPanel {

    private final int DEFAULT_WIDTH = 800;
    private final int DEFAULT_HEIGHT = 600;

    private Kite kite;

    public Panel() {
        setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        setLayout(null);

        kite = new Kite(100, 100);
        add(kite);
    }
}

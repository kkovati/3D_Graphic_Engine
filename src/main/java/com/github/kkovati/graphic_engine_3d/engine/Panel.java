package com.github.kkovati.graphic_engine_3d.engine;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;


/**
 * The single component inside Frame,
 * provides Graphics object for the controller and models to
 */
public class Panel extends JPanel {

    public Panel() {
        super();
    }

    /**
     * Displays grid lines, mainly used for debugging
     * Background is above grid lines, so grid lines cannot be seen
     */
    public void display() {
        Graphics g = getGraphics();
        super.paintComponent(g);
        this.setBackground(Color.WHITE);

        g.setColor(Color.RED);

        //horizontal grid lines
        g.drawLine(0, 0, Settings.displayWidth, 0);
        g.drawLine(0, Settings.displayHeight / 4, Settings.displayWidth, Settings.displayHeight / 4);
        g.drawLine(0, Settings.displayHeight / 2, Settings.displayWidth, Settings.displayHeight / 2);
        g.drawLine(0, Settings.displayHeight * 3 / 4, Settings.displayWidth, Settings.displayHeight * 3 / 4);
        g.drawLine(0, Settings.displayHeight, Settings.displayWidth, Settings.displayHeight);

        //vertical grid lines
        g.drawLine(0, 0, 0, Settings.displayHeight);
        g.drawLine(Settings.displayWidth / 4, 0, Settings.displayWidth / 4, Settings.displayHeight);
        g.drawLine(Settings.displayWidth / 2, 0, Settings.displayWidth / 2, Settings.displayHeight);
        g.drawLine(Settings.displayWidth * 3 / 4, 0, Settings.displayWidth * 3 / 4, Settings.displayHeight);
        g.drawLine(Settings.displayWidth, 0, Settings.displayWidth, Settings.displayHeight);

        //diagonal grid lines
        g.drawLine(0, 0, Settings.displayWidth, Settings.displayHeight);
        g.drawLine(Settings.displayWidth, 0, 0, Settings.displayHeight);

        g.setColor(Color.BLACK);

    }

}

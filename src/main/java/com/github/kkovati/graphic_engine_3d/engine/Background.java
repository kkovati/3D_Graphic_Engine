package com.github.kkovati.graphic_engine_3d.engine;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Displays background based on camera's vertical view angle
 * Makes user orientation easier
 */
public class Background {

    double invViewDir;

    public Background() {
        //left empty on purpose
    }

    /**
     * Saves camera vertical view angle
     *
     * @param cam Camera
     */
    public void update(Camera cam) {
        invViewDir = -cam.viewDirVer();
    }

    /**
     * Displays background
     *
     * @param g Graphics of Panel
     */
    public void display(Graphics g) {
        //y coordinate of horizon on screen
        double y = Settings.screenDist * Math.tan(Math.toRadians(invViewDir));
        y = -y + Settings.displayHeight / 2.0;

        //display background above horizon
        for (int i = 0; i < 250; i++) {
            g.setColor(new Color(i, i, 220));
            g.fillRect(0, (int) y - 6 * i, Settings.displayWidth, 6);
        }

        //display background under horizon
        for (double i = 0; i < 250; i++) {
            double startColor = 50;
            int color = (int) ((((250 - startColor) / 250) * i) + startColor);
            g.setColor(new Color(color, color, color));
            g.fillRect(0, (int) (y + 6 * i), Settings.displayWidth, 6);
        }

    }

}

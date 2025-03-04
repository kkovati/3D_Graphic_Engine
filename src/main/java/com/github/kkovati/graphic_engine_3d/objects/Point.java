package com.github.kkovati.graphic_engine_3d.objects;

import java.awt.Graphics;

import com.github.kkovati.graphic_engine_3d.engine.Camera;
import com.github.kkovati.graphic_engine_3d.engine.Settings;

/**
 * Represents a single point in space
 */
public class Point {

    //absolute coordinates
    private double x0, y0, z0;
    //relative coordinates to camera's position and view direction
    private double xRel, yRel, zRel;
    //visibility on display
    private boolean visible;

    //coordinates on display screen
    private double xDisp, yDisp;

    //display size
    private double size = 2;

    public Point(double x0, double y0, double z0) {
        this.x0 = x0;
        this.y0 = y0;
        this.z0 = z0;
    }

    /**
     * Calculating point's relative coordinates to camera's position and view direction
     *
     * @param cam Camera
     */
    public void update(Camera cam) {

        //relative coordinates to camera's position in space
        xRel = x0 - cam.x();
        yRel = y0 - cam.y();
        zRel = z0 - cam.z();

        //TODO
        //these calculations can be easier, deg->rad has to be deleted
        //alphas can be dismissed

        //rolling around Z axis
        double r = Math.sqrt(xRel * xRel + yRel * yRel);
        double alpha0 = Math.signum(yRel) * Math.toDegrees(Math.acos(xRel / r));
        double alpha1 = alpha0 - cam.viewDirHor();
        xRel = r * Math.cos(Math.toRadians(alpha1));
        yRel = r * Math.sin(Math.toRadians(alpha1));

        //rolling around Y axis
        r = Math.sqrt(xRel * xRel + zRel * zRel);
        alpha0 = Math.signum(zRel) * Math.toDegrees(Math.acos(xRel / r));
        if (alpha0 > 90)
            alpha0 -= 180;
        else if (alpha0 < -90)
            alpha0 += 180;
        alpha1 = alpha0 - cam.viewDirVer();
        zRel = r * Math.sin(Math.toRadians(alpha1));
        xRel = (xRel < 0 ? -1 : 1) * r * Math.cos(Math.toRadians(alpha1));
    }

    /**
     * Calculates screen coordinates and displays points on screen
     *
     * @param g Graphics from Panel
     */
    public void display(Graphics g) {

        //x coordinate on screen (origo in middle)
        double x = Settings.screenDist * yRel / xRel;

        //y coordinate on screen (origo in middle)
        double y = Settings.screenDist * zRel / xRel;

        //x and y coordinates on screen (origo at top left)
        xDisp = -x + Settings.displayWidth / 2.0;
        yDisp = -y + Settings.displayHeight / 2.0;

        //visible field set according to if point is out of screen visibility
        if (x < Settings.displayWidth / 2.0 && x > -Settings.displayWidth / 2.0 && y < Settings.displayHeight / 2.0 && y > -Settings.displayHeight / 2.0 && xRel > 0) {
            g.fillOval((int) (xDisp - (size / 2)), (int) (yDisp - (int) (size / 2)), (int) size, (int) size);
            visible = true;
        } else {
            visible = false;
        }

    }

    public double xDisp() {
        return xDisp;
    }

    public double yDisp() {
        return yDisp;
    }

    public boolean isVisible() {
        return visible;
    }

    public double getX() {
        return x0;
    }

    public double getY() {
        return y0;
    }

    public double getZ() {
        return z0;
    }

}

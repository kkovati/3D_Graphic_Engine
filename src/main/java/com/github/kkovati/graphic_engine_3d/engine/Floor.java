package com.github.kkovati.graphic_engine_3d.engine;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import com.github.kkovati.graphic_engine_3d.objects.Point;
import com.github.kkovati.graphic_engine_3d.objects.Line;

/**
 * Grid below horizon
 * NOTE: Currently unused in project
 */
public class Floor {

    ArrayList<Point> pa = new ArrayList<Point>();
    ArrayList<Line> la = new ArrayList<Line>();

    public Floor() {

        for (int i = -50; i < 51; i++) {
            Point temp1 = new Point(i, -50, -50);
            Point temp2 = new Point(i, 50, -50);
            la.add(new Line(temp1, temp2));
            pa.add(temp1);
            pa.add(temp2);
            temp1 = new Point(-50, i, -50);
            temp2 = new Point(50, i, -50);
            la.add(new Line(temp1, temp2));
            pa.add(temp1);
            pa.add(temp2);
        }

    }

    public void update(Camera cam) {
        pa.forEach(point -> point.update(cam));
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        pa.forEach(point -> point.display(g));
        la.forEach(line -> line.display(g));
    }
}

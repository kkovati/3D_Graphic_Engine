package com.github._3d_graphical_engine;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Model of an octahedron
 */
public class Octahedron implements Polyhedron {

    ArrayList<Point> points = new ArrayList<>();
    ArrayList<Line> lines = new ArrayList<>();

    public Octahedron(double x0, double y0, double z0, double edgeLength) {
        double d = edgeLength * 0.707;

        //load list of vertices
        points.add(new Point(x0 + d, y0, z0));
        points.add(new Point(x0 - d, y0, z0));
        points.add(new Point(x0,y0 + d, z0));
        points.add(new Point(x0,y0 - d, z0));
        points.add(new Point(x0, y0,z0 + d));
        points.add(new Point(x0, y0,z0 - d));

        //load list of edges
        lines.add(new Line(points.get(0), points.get(2)));
        lines.add(new Line(points.get(0), points.get(3)));
        lines.add(new Line(points.get(0), points.get(4)));
        lines.add(new Line(points.get(0), points.get(5)));
        lines.add(new Line(points.get(1), points.get(2)));
        lines.add(new Line(points.get(1), points.get(3)));
        lines.add(new Line(points.get(1), points.get(4)));
        lines.add(new Line(points.get(1), points.get(5)));
        lines.add(new Line(points.get(4), points.get(2)));
        lines.add(new Line(points.get(4), points.get(3)));
        lines.add(new Line(points.get(5), points.get(2)));
        lines.add(new Line(points.get(5), points.get(3)));
    }

    public void update(Camera cam, double deltaTime) {
        points.forEach(point->point.update(cam));
    }

    public void display(Graphics g) {
        g.setColor(Color.BLACK);
        points.forEach(point->point.display(g));
        //line draw must be after point draw
        //but if xDisp would calculated in Point`s update method (currently in display method)
        //the sequence would be irrelevant
        lines.forEach(line->line.display(g));

    }
}

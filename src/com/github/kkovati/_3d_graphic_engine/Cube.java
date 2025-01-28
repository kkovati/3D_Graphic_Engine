package com.github.kkovati.graphic_engine_3d;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Model of a cube
 */
public class Cube implements Polyhedron {
	
	ArrayList<Point> points = new ArrayList<>();
	ArrayList<Line> lines = new ArrayList<>();

	/**
	 * Creates all the vertices and edges of cube
	 * @param x0, y0, z0 coordinates of cube center
	 * @param edgeLength length of cube edge
	 */
	public Cube(double x0, double y0, double z0, double edgeLength) {

		double d = edgeLength / 2;

		//load list of vertices
		points.add(new Point(x0 - d,y0 + d,z0 + d));
		points.add(new Point(x0 - d,y0 - d,z0 + d));
		points.add(new Point(x0 - d,y0 + d,z0 - d));
		points.add(new Point(x0 - d,y0 - d,z0 - d));
		points.add(new Point(x0 + d,y0 + d,z0 + d));
		points.add(new Point(x0 + d,y0 + d,z0 - d));
		points.add(new Point(x0 + d,y0 - d,z0 + d));
		points.add(new Point(x0 + d,y0 - d,z0 - d));

		//load list of edges
		lines.add(new Line(points.get(0), points.get(1)));
		lines.add(new Line(points.get(0), points.get(2)));
		lines.add(new Line(points.get(0), points.get(4)));
		lines.add(new Line(points.get(1), points.get(3)));
		lines.add(new Line(points.get(1), points.get(6)));
		lines.add(new Line(points.get(2), points.get(3)));
		lines.add(new Line(points.get(2), points.get(5)));
		lines.add(new Line(points.get(3), points.get(7)));
		lines.add(new Line(points.get(4), points.get(5)));
		lines.add(new Line(points.get(4), points.get(6)));
		lines.add(new Line(points.get(5), points.get(7)));
		lines.add(new Line(points.get(6), points.get(7)));
	}

	/**
	 * Updates all cube vertices relative position to camera's view direction
	 * @param cam Camera object
	 * @param deltaTime for kinematics
	 */
	public void update(Camera cam, double deltaTime) {
		points.forEach(point->point.update(cam));
	}

	/**
	 * Calls all the display method of all vertices and edges
	 * @param g Graphics
	 */
	public void display(Graphics g) {
		g.setColor(Color.BLACK);
		points.forEach(point -> point.display(g));

		//TODO
		//line display must be after point display
		//but if xDisp would calculated in Point`s update method (currently in display method)
		//the sequence would be irrelevant
		lines.forEach(line -> line.display(g));

		//TODO
		//faces overlap each other, so fillFaces method cannot be used that state
		//fillFaces(g);

	}

	/**
	 * Fills cube faces with single color using Graphics.fillPolygon() method
	 * @param g
	 */
	public void fillFaces(Graphics g) {
		
		g.setColor(Color.BLACK);
		@SuppressWarnings("unused")
		int[] x = new int[] {(int) points.get(0).xDisp(),(int) points.get(1).xDisp(),(int) points.get(3).xDisp(),(int) points.get(2).xDisp()};
		@SuppressWarnings("unused")
		int[] y = new int[] {(int) points.get(0).yDisp(),(int) points.get(1).yDisp(),(int) points.get(3).yDisp(),(int) points.get(2).yDisp()};
		g.fillPolygon(x,y,4);
		
		x = new int[] {(int) points.get(4).xDisp(),(int) points.get(5).xDisp(),(int) points.get(7).xDisp(),(int) points.get(6).xDisp()};
		y = new int[] {(int) points.get(4).yDisp(),(int) points.get(5).yDisp(),(int) points.get(7).yDisp(),(int) points.get(6).yDisp()};
		g.fillPolygon(x,y,4);
		
		g.setColor(Color.BLUE);
		x = new int[] {(int) points.get(0).xDisp(),(int) points.get(1).xDisp(),(int) points.get(6).xDisp(),(int) points.get(4).xDisp()};
		y = new int[] {(int) points.get(0).yDisp(),(int) points.get(1).yDisp(),(int) points.get(6).yDisp(),(int) points.get(4).yDisp()};
		g.fillPolygon(x,y,4);
		
		x = new int[] {(int) points.get(2).xDisp(),(int) points.get(3).xDisp(),(int) points.get(7).xDisp(),(int) points.get(5).xDisp()};
		y = new int[] {(int) points.get(2).yDisp(),(int) points.get(3).yDisp(),(int) points.get(7).yDisp(),(int) points.get(5).yDisp()};
		g.fillPolygon(x,y,4);
		
		g.setColor(Color.RED);
		x = new int[] {(int) points.get(0).xDisp(),(int) points.get(2).xDisp(),(int) points.get(5).xDisp(),(int) points.get(4).xDisp()};
		y = new int[] {(int) points.get(0).yDisp(),(int) points.get(2).yDisp(),(int) points.get(5).yDisp(),(int) points.get(4).yDisp()};
		g.fillPolygon(x,y,4);
		
		x = new int[] {(int) points.get(1).xDisp(),(int) points.get(3).xDisp(),(int) points.get(7).xDisp(),(int) points.get(6).xDisp()};
		y = new int[] {(int) points.get(1).yDisp(),(int) points.get(3).yDisp(),(int) points.get(7).yDisp(),(int) points.get(6).yDisp()};
		g.fillPolygon(x,y,4);
		
		g.setColor(Color.BLACK);
	}	
}

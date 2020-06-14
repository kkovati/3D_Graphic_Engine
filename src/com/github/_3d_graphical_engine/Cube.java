package com.github._3d_graphical_engine;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Cube {
	
	ArrayList<Point> pa = new ArrayList<Point>();
	ArrayList<Line> la = new ArrayList<Line>();
	
	public Cube(double x0, double y0, double z0, double edgeLength) {

		double d = edgeLength/2;
		
		pa.add(new Point(x0-d,y0+d,z0+d));
		pa.add(new Point(x0-d,y0-d,z0+d));
		pa.add(new Point(x0-d,y0+d,z0-d));
		pa.add(new Point(x0-d,y0-d,z0-d));
		pa.add(new Point(x0+d,y0+d,z0+d));
		pa.add(new Point(x0+d,y0+d,z0-d));
		pa.add(new Point(x0+d,y0-d,z0+d));
		pa.add(new Point(x0+d,y0-d,z0-d));
		
		la.add(new Line(pa.get(0), pa.get(1)));
		la.add(new Line(pa.get(0), pa.get(2)));
		la.add(new Line(pa.get(0), pa.get(4)));
		la.add(new Line(pa.get(1), pa.get(3)));
		la.add(new Line(pa.get(1), pa.get(6)));
		la.add(new Line(pa.get(2), pa.get(3)));
		la.add(new Line(pa.get(2), pa.get(5)));
		la.add(new Line(pa.get(3), pa.get(7)));
		la.add(new Line(pa.get(4), pa.get(5)));
		la.add(new Line(pa.get(4), pa.get(6)));
		la.add(new Line(pa.get(5), pa.get(7)));
		la.add(new Line(pa.get(6), pa.get(7)));	
	}
	
	public void update(Camera cam, double deltaTime) {
		pa.forEach(point->point.update(cam));
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		pa.forEach(point->point.display(g));
		//line draw must be after point draw
		//but if xDisp would calculated in Point`s update
		//the sequence would be irrelevant
		la.forEach(line->line.display(g));
		
		g.setColor(Color.BLACK);
		@SuppressWarnings("unused")
		int[] x = new int[] {(int)pa.get(0).xDisp(),(int)pa.get(1).xDisp(),(int)pa.get(3).xDisp(),(int)pa.get(2).xDisp()};
		@SuppressWarnings("unused")
		int[] y = new int[] {(int)pa.get(0).yDisp(),(int)pa.get(1).yDisp(),(int)pa.get(3).yDisp(),(int)pa.get(2).yDisp()};		
		//g.fillPolygon(x,y,4);
		
		x = new int[] {(int)pa.get(4).xDisp(),(int)pa.get(5).xDisp(),(int)pa.get(7).xDisp(),(int)pa.get(6).xDisp()};
		y = new int[] {(int)pa.get(4).yDisp(),(int)pa.get(5).yDisp(),(int)pa.get(7).yDisp(),(int)pa.get(6).yDisp()};
		//g.fillPolygon(x,y,4);
		
		g.setColor(Color.BLUE);
		x = new int[] {(int)pa.get(0).xDisp(),(int)pa.get(1).xDisp(),(int)pa.get(6).xDisp(),(int)pa.get(4).xDisp()};
		y = new int[] {(int)pa.get(0).yDisp(),(int)pa.get(1).yDisp(),(int)pa.get(6).yDisp(),(int)pa.get(4).yDisp()};
		//g.fillPolygon(x,y,4);
		
		x = new int[] {(int)pa.get(2).xDisp(),(int)pa.get(3).xDisp(),(int)pa.get(7).xDisp(),(int)pa.get(5).xDisp()};
		y = new int[] {(int)pa.get(2).yDisp(),(int)pa.get(3).yDisp(),(int)pa.get(7).yDisp(),(int)pa.get(5).yDisp()};
		//g.fillPolygon(x,y,4);
		
		g.setColor(Color.RED);
		x = new int[] {(int)pa.get(0).xDisp(),(int)pa.get(2).xDisp(),(int)pa.get(5).xDisp(),(int)pa.get(4).xDisp()};
		y = new int[] {(int)pa.get(0).yDisp(),(int)pa.get(2).yDisp(),(int)pa.get(5).yDisp(),(int)pa.get(4).yDisp()};
		//g.fillPolygon(x,y,4);
		
		x = new int[] {(int)pa.get(1).xDisp(),(int)pa.get(3).xDisp(),(int)pa.get(7).xDisp(),(int)pa.get(6).xDisp()};
		y = new int[] {(int)pa.get(1).yDisp(),(int)pa.get(3).yDisp(),(int)pa.get(7).yDisp(),(int)pa.get(6).yDisp()};
		//g.fillPolygon(x,y,4);
		
		g.setColor(Color.BLACK);
	}	
}

package com.github._3d_graphical_engine;

import java.awt.Graphics;

/**
 * A graphical representation of a simple line between two points
 */
public class Line {
	
	Point a, b; //two points span the line
	
	public Line(Point a, Point b) {
		this.a = a;
		this.b = b;
	}
	
	public void display(Graphics g) {
		if(a.isVisible() || b.isVisible())
			g.drawLine((int)a.xDisp(), (int)a.yDisp(), (int)b.xDisp(), (int)b.yDisp());
	}
}

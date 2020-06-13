package com.github._3d_graphical_engine;

import java.awt.Graphics;

public class Line {
	
	Point a, b;
	
	public Line(Point a, Point b) {
		this.a = a;
		this.b = b;
	}
	
	public void draw(Graphics g) {
		if(a.IsVisible() || b.IsVisible())
			g.drawLine((int)a.xDisp(), (int)a.yDisp(), (int)b.xDisp(), (int)b.yDisp());
		
	}
}

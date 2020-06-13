package com.github._3d_graphical_engine;

import java.awt.Color;
import java.awt.Graphics;

public class Background {
	
	double v;
	
	public Background() {
		
	}
	
	public void update(Camera cam) {
		
		v = -cam.viewDirVer();
		
	}
	
	public void draw(Graphics g) {
		
		double d0 = Constants.diplayWidth/(2*Math.tan(Math.toRadians(Constants.viewAngleHor/2)));
		
		double y =  d0 * Math.tan(Math.toRadians(v));
				
		y = -y + Constants.diplayHeight/2;
		
		//g.drawLine(0, (int)y, Constants.diplayWidth, (int)y);
		
		/*
		g.setColor(Color.GRAY);
		g.fillRect(0, (int)y, Constants.diplayWidth, 2*Constants.diplayHeight);
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, Constants.diplayWidth, (int)y);
		*/
		
		for(int i = 0; i < 250; i ++) {
			g.setColor(new Color(i, i, 127));
			g.fillRect(0, (int)y - 3*i, Constants.diplayWidth, 3);			
		}		
		
		for(int i = 0; i < 250; i ++) {
			g.setColor(new Color(i, i, i));
			g.fillRect(0, (int)y + 3*i, Constants.diplayWidth, 3);			
		}		
		
	}

}

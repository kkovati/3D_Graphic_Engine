package com.github._3d_graphical_engine;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 */

public class Background {
	
	double v;
	
	public Background() {
		
	}
	
	public void update(Camera cam) {
		
		v = -cam.viewDirVer();
		
	}
	
	public void draw(Graphics g) {

		//Camera virtual distance from the screen
		double d0 = Constants.diplayWidth / (2 * Math.tan(Math.toRadians(Constants.viewAngleHor / 2)));
		
		double y =  d0 * Math.tan(Math.toRadians(v));
				
		y = -y + Constants.diplayHeight / 2;

		//display background above horizon
		for(int i = 0; i < 250; i++) {
			g.setColor(new Color(i, i, 220));
			g.fillRect(0, (int)y - 3 * i, Constants.diplayWidth, 3);
		}

		//display background under horizon
		for (double i = 0; i < 250; i++) {
			double startColor = 50;
			int color = (int)((((250 - startColor) / 250) * i) + startColor);
			g.setColor(new Color(color, color, color));
			g.fillRect(0, (int)(y + 3 * i), Constants.diplayWidth, 3);
		}		
		
	}

}

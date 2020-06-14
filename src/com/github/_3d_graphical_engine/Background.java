package com.github._3d_graphical_engine;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Displays background based on camera's vertical view angle
 */
public class Background {
	
	double invViewDir;
	
	public Background() {
		
	}
	
	public void update(Camera cam) {
		
		invViewDir = -cam.viewDirVer();
		
	}
	
	public void display(Graphics g) {

		//Camera virtual distance from the screen
		double dist = Settings.diplayWidth / (2 * Math.tan(Math.toRadians(Settings.viewAngleHor / 2)));

		//y coordinate of horizon on screen
		double y =  dist * Math.tan(Math.toRadians(invViewDir));
		y = -y + Settings.diplayHeight / 2;

		//display background above horizon
		for(int i = 0; i < 250; i++) {
			g.setColor(new Color(i, i, 220));
			g.fillRect(0, (int)y - 3 * i, Settings.diplayWidth, 3);
		}

		//display background under horizon
		for (double i = 0; i < 250; i++) {
			double startColor = 50;
			int color = (int)((((250 - startColor) / 250) * i) + startColor);
			g.setColor(new Color(color, color, color));
			g.fillRect(0, (int)(y + 3 * i), Settings.diplayWidth, 3);
		}		
		
	}

}

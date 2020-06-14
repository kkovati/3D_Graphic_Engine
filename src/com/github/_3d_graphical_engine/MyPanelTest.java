package com.github._3d_graphical_engine;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MyPanelTest extends JPanel {
	
	public void update(double deltaTime) {
		
	}
	
	public void draw() {
		Graphics g = getGraphics();
		super.paintComponent(g);
		this.setBackground(Color.WHITE);
		
		g.setColor(Color.RED);
		
		//vizszintes vonalak 
		g.drawLine(0, 0, Test.Disp, 0);		
		g.drawLine(0, Test.Disp/2, Test.Disp, Test.Disp/2);
		g.drawLine(0, Test.Disp, Test.Disp, Test.Disp);
				
		//fuggoleges vonalak
		g.drawLine(0, 0, 0, Test.Disp);
		g.drawLine(Test.Disp/2, 0, Test.Disp/2, Test.Disp);;
		g.drawLine(Test.Disp, 0, Test.Disp, Test.Disp);
		
		//lines of angle of view:
		g.drawLine(Test.Disp/2, Test.Disp/2, 0, (int)(Test.Disp/2 - Math.tan(Math.toRadians(Settings.viewAngleHor/2)) * (Test.Disp / 2)));
		g.drawLine(Test.Disp/2, Test.Disp/2, 0, (int)(Test.Disp/2 + Math.tan(Math.toRadians(Settings.viewAngleHor/2)) * (Test.Disp / 2)));
		
		
		g.setColor(Color.BLACK);
		
		//coordinate on monitor (origo at top left)
		double xDisp = 20 * -Test.xRel + Test.Disp/2;
		double yDisp = 20 * -Test.yRel + Test.Disp/2;
		g.fillOval((int)(xDisp - (10/2)),(int)(yDisp - (int)(10/2)), (int)10, (int)10 );
		
		
		
		
	}
}

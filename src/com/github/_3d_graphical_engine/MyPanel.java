package com.github._3d_graphical_engine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;


public class MyPanel extends JPanel{
	
	private MyObjectManager m = new MyObjectManager();
	
	private Camera cam = new Camera(0,0,1,0,0);
	
	public void update(double deltaTime) {
		m.update(cam, deltaTime);
	}
	
	public void draw() {
		Graphics g = getGraphics();
		super.paintComponent(g);
		this.setBackground(Color.WHITE);
		
		g.setColor(Color.RED);

		//horizontal grid lines
		g.drawLine(0, 0, Constants.diplayWidth, 0);
		g.drawLine(0, Constants.diplayHeight/4, Constants.diplayWidth, Constants.diplayHeight/4);
		g.drawLine(0, Constants.diplayHeight/2, Constants.diplayWidth, Constants.diplayHeight/2);
		g.drawLine(0, Constants.diplayHeight*3/4, Constants.diplayWidth, Constants.diplayHeight*3/4);
		g.drawLine(0, Constants.diplayHeight, Constants.diplayWidth, Constants.diplayHeight);
		
		//vertical grid lines
		g.drawLine(0, 0, 0, Constants.diplayHeight);
		g.drawLine(Constants.diplayWidth/4, 0, Constants.diplayWidth/4, Constants.diplayHeight);
		g.drawLine(Constants.diplayWidth/2, 0, Constants.diplayWidth/2, Constants.diplayHeight);
		g.drawLine(Constants.diplayWidth*3/4, 0, Constants.diplayWidth*3/4, Constants.diplayHeight);
		g.drawLine(Constants.diplayWidth, 0, Constants.diplayWidth, Constants.diplayHeight);
				
		g.drawLine(0, 0, Constants.diplayWidth, Constants.diplayHeight);
		g.drawLine(Constants.diplayWidth, 0, 0, Constants.diplayHeight);
		
		g.setColor(Color.BLACK);
		
		m.draw(g);
		
		//for testing reasons only
		cam.draw(g);
		
		
		//System.out.println("" + cam.x() + ", " + cam.y()+ ", " + cam.z() + ", " + cam.viewDirHor() + ", " + cam.viewDirVer());
	}	
	
	public void camMove(KeyEvent e) {
		cam.move(e);
	}
	
	public void camRotate(MouseEvent e) {
		cam.rotate(e);
	}
	
}

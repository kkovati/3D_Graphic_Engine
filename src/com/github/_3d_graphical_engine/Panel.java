package com.github._3d_graphical_engine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;


public class Panel extends JPanel{
	
	private ObjectManager manager = new ObjectManager();
	
	private Camera cam = new Camera(0,0,1,0,0);
	
	public void update(double deltaTime) {
		manager.update(cam, deltaTime);
	}
	
	public void display() {
		Graphics g = getGraphics();
		super.paintComponent(g);
		this.setBackground(Color.WHITE);
		
		g.setColor(Color.RED);

		//horizontal grid lines
		g.drawLine(0, 0, Settings.diplayWidth, 0);
		g.drawLine(0, Settings.diplayHeight / 4, Settings.diplayWidth, Settings.diplayHeight / 4);
		g.drawLine(0, Settings.diplayHeight / 2, Settings.diplayWidth, Settings.diplayHeight / 2);
		g.drawLine(0, Settings.diplayHeight * 3 / 4, Settings.diplayWidth, Settings.diplayHeight * 3 / 4);
		g.drawLine(0, Settings.diplayHeight, Settings.diplayWidth, Settings.diplayHeight);
		
		//vertical grid lines
		g.drawLine(0, 0, 0, Settings.diplayHeight);
		g.drawLine(Settings.diplayWidth / 4, 0, Settings.diplayWidth / 4, Settings.diplayHeight);
		g.drawLine(Settings.diplayWidth / 2, 0, Settings.diplayWidth / 2, Settings.diplayHeight);
		g.drawLine(Settings.diplayWidth * 3 / 4, 0, Settings.diplayWidth * 3 / 4, Settings.diplayHeight);
		g.drawLine(Settings.diplayWidth, 0, Settings.diplayWidth, Settings.diplayHeight);

		//diagonal grid lines
		g.drawLine(0, 0, Settings.diplayWidth, Settings.diplayHeight);
		g.drawLine(Settings.diplayWidth, 0, 0, Settings.diplayHeight);
		
		g.setColor(Color.BLACK);
		
		manager.display(g);
		
		//for testing reasons only
		cam.display(g);
		
		
		//System.out.println("" + cam.x() + ", " + cam.y()+ ", " + cam.z() + ", " + cam.viewDirHor() + ", " + cam.viewDirVer());
	}	
	
	public void camMove(KeyEvent e) {
		cam.move(e);
	}
	
	public void camRotate(MouseEvent e) {
		cam.rotate(e);
	}
	
}

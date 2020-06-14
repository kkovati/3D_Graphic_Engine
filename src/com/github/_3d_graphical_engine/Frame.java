package com.github._3d_graphical_engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;

public class Frame extends JFrame implements KeyListener, MouseListener, MouseMotionListener {
	
	private Panel panel = new Panel();
	
	public Frame(String title) {
		super(title);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//size of app frame is wider than the actual display
		setSize(Settings.diplayWidth + 10, Settings.diplayHeight + 32);
		setLocationRelativeTo(null); //set frame in middle of monitor
		setVisible(true);
		setResizable(false);
		
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		
		add(panel);
	}
	
	public void update(double deltaTime) {
		panel.update(deltaTime);
	}
	
	public void draw() {
		panel.display();
	}

	/*KeyListener interface methods*/
	
	public void keyPressed(KeyEvent e) {
		panel.camMove(e);
	}
	
	public void keyTyped(KeyEvent e) {
		//left empty on purpose
	}
	
	public void keyReleased(KeyEvent e) {
		//left empty on purpose
	}

	/*MouseMotionListener interface methods*/
	
	public void mouseMoved(MouseEvent e) {
		//left empty on purpose
		
	}
	
	public void mouseDragged(MouseEvent e) {
		panel.camRotate(e);
	}

	/*MouseListener interface methods*/
	
	public void mouseEntered(MouseEvent e) {
		//left empty on purpose
	}
	
	public void mouseExited(MouseEvent e) {
		//left empty on purpose
	}
	
	public void mousePressed(MouseEvent e) {
		//left empty on purpose
	}
	
	public void mouseReleased(MouseEvent e) {
		//left empty on purpose
	}

	public void mouseClicked(MouseEvent e) {
		//left empty on purpose
	}

}

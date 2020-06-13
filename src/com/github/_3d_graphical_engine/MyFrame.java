package com.github._3d_graphical_engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;

public class MyFrame extends JFrame implements KeyListener, MouseListener, MouseMotionListener {
	
	private MyPanel p = new MyPanel();
	
	public MyFrame(String title) {
		super(title);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Constants.diplayWidth+10, Constants.diplayHeight+32);
		setLocationRelativeTo(null); //set frame in middle of monitor
		setVisible(true);
		setResizable(false);
		
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		//this.addMouseWheelListener(this);
		
		add(p);				
	}
	
	public void update(double deltaTime) {
		p.update(deltaTime);
	}
	
	public void draw() {
		p.draw();
	}	
	
	public void keyPressed(KeyEvent e) {
		p.camMove(e);
	}
	
	public void keyTyped(KeyEvent e) {
		//empty
	}
	
	public void keyReleased(KeyEvent e) {
		//empty
	}	
	
	//----------------------------------------------------
	
	public void mouseMoved(MouseEvent e) {
		//System.out.println(e.getX());
		
	}
	
	public void mouseDragged(MouseEvent e) {
		p.camRotate(e);
	}
	
	//----------------------------------------------------
	
	public void mouseEntered(MouseEvent e) {
		//empty
	}
	
	public void mouseExited(MouseEvent e) {
		//empty
	}
	
	public void mousePressed(MouseEvent e) {
		//empty
	}
	
	public void mouseReleased(MouseEvent e) {
		//empty
	}

	public void mouseClicked(MouseEvent e) {
		//empty
	}

}

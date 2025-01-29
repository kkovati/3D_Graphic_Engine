package com.github.kkovati.graphic_engine_3d.engine;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;


/**
 * Main window of the application, a container for the Panel
 * Handles all user activity events through listeners, and gives these events back to Engine
 */
public class Frame extends JFrame implements KeyListener, MouseListener, MouseMotionListener {
	
	private Panel panel = new Panel();

	private Engine engine;
	
	public Frame(Engine engine) {
		super("3D Graphical Engine");

		this.engine = engine;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//size of app frame is wider than the actual display
		setSize(Settings.displayWidth + 10, Settings.displayHeight + 32);
		setLocationRelativeTo(null); //set frame in middle of monitor
		setVisible(true);
		setResizable(false);
		
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		
		add(panel);
	}

	public Graphics getPanelGraphics() {
		return panel.getGraphics();
	}

	public void display() {
		panel.display();
	}

	/*KeyListener interface methods*/
	
	public void keyPressed(KeyEvent e) {
		engine.camMove(e);
		engine.exit(e);
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
		engine.camRotate(e);
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

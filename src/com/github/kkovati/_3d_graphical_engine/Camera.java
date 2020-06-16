package com.github.kkovati._3d_graphical_engine;;

import java.awt.Graphics;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Representation of the point of view
 * Camera has position in space and direction of view
 */
public class Camera {

	//position coordinates in space
	private double x,y,z;
	//view direction horizontal and vertical angles
	private double viewDirHor, viewDirVer;

	//auxiliary variable for proper camera rotation display
	private int camXRotate;
	private int camYRotate;

	//variables for displaying camera movement
	private String lastMove = "";
	private int dispCountdown;
		
	public Camera(double x, double y, double z, double viewDirHor, double viewDirVer) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.viewDirHor = viewDirHor;
		this.viewDirVer = viewDirVer;		
	}
	
	public double x() {
		return x;
	}
	
	public double y() {
		return y;
	}
	
	public double z() {
		return z;
	}
	
	public double viewDirHor() {
		return viewDirHor;
	}
	
	public double viewDirVer() {
		return viewDirVer;
	}
	
	public void move(double x, double y, double z) {
		this.x += x;
		this.y += y;
		this.z += z;
	}

	/**
	 * Moves Camera in space by updating it's positions
	 * @param e KeyEvent of pressing cursors or WASD keys
	 */
	public void move(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		if(keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_W) {
			x += (Math.cos(Math.toRadians(viewDirHor)) * Settings.stepSize);
			y += (Math.sin(Math.toRadians(viewDirHor)) * Settings.stepSize);
			lastMove = "UP";
		}
		if(keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_S) {
			x -= (Math.cos(Math.toRadians(viewDirHor)) * Settings.stepSize);
			y -= (Math.sin(Math.toRadians(viewDirHor)) * Settings.stepSize);
			lastMove = "DOWN";
		}
		if(keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_A) {
			x += (Math.cos(Math.toRadians(viewDirHor+90)) * Settings.stepSize);
			y += (Math.sin(Math.toRadians(viewDirHor+90)) * Settings.stepSize);
			lastMove = "LEFT";
		}
		if(keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_D) {
			x += (Math.cos(Math.toRadians(viewDirHor-90)) * Settings.stepSize);
			y += (Math.sin(Math.toRadians(viewDirHor-90)) * Settings.stepSize);
			lastMove = "RIGHT";
		}
		dispCountdown = 8;
	}

	/**
	 * Change the Camera's direction of view
	 * @param e MouseEvent of dragging the view in the frame
	 */
	public void rotate(MouseEvent e) {
		//calculate horizontal rotation
		if(Math.abs(camXRotate - e.getX()) < 10) {
			viewDirHor += (e.getX() - camXRotate) * 0.1;
		}
		camXRotate = e.getX();

		//calculate vertical rotation
		if(Math.abs(camYRotate - e.getY()) < 10) {
			viewDirVer += (e.getY() - camYRotate) * 0.1;
		}
		camYRotate = e.getY();

		//set horizontal view direction between 0 and 360 degrees
		if(viewDirHor > 360)
			viewDirHor -= 360;
		if(viewDirHor < 0)
			viewDirHor += 360;

		//forbid vertical tilting of the view direction more than zenith or nadir
		if(viewDirVer > 90)
			viewDirVer = 90;
		if(viewDirVer < -90)
			viewDirVer = -90;
	}

	/**
	 * Displaying camera view angles on screen,
	 * and arrows which represent camera movement
	 * @param g Graphics
	 */
	public void display(Graphics g) {
		g.setFont(new Font("default", Font.BOLD, 16));
		g.drawString("Hor: " + (int)viewDirHor + "deg", 50, 50);
		g.drawString("Ver: " + (int)viewDirVer + "deg", 50, 70);

		if (dispCountdown <= 0) {
			lastMove = "";
			return;
		}
		dispCountdown--;
		g.setFont(new Font("default", Font.BOLD, 32));
		switch (lastMove) {
			case "UP":
				g.drawString("▲", Settings.diplayWidth / 2, 50);
				break;
			case "DOWN":
				g.drawString("▼", Settings.diplayWidth / 2, Settings.diplayHeight - 50);
				break;
			case "LEFT":
				g.drawString("◄", 50, Settings.diplayHeight / 2);
				break;
			case "RIGHT":
				g.drawString("►", Settings.diplayWidth - 50, Settings.diplayHeight / 2);
				break;
			default:
		}

	}

}

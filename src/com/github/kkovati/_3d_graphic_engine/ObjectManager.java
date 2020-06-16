package com.github.kkovati._3d_graphic_engine;

import java.awt.Graphics;
import java.util.ArrayList;


/**
 * Handles, updates and displays all the displayable objects
 */
public class ObjectManager {

	//list of single points
	private ArrayList<Point> points = new ArrayList<>();

	//list of all type of complex objects made of points and lines
	private ArrayList<Polyhedron> polyhedrons = new ArrayList<>();

	private Background background = new Background();
	
	public ObjectManager() {
		//left empty on purpose
	}

	public void add(Point p) {
		points.add(p);
	}

	public void add(Polyhedron p) {
		polyhedrons.add(p);
	}

	/**
	 * Runs update() method of all objects
	 * @param cam Camera
	 * @param deltaTime for kinematics
	 */
	public void update(Camera cam, double deltaTime) {
		background.update(cam);
		polyhedrons.forEach(cube->cube.update(cam, deltaTime));
		points.forEach(point->point.update(cam));
		
	}

	/**
	 * Runs display() method of all objects
	 * @param g Graphics
	 */
	public void display(Graphics g) {
		background.display(g);
		polyhedrons.forEach(cube->cube.display(g));
		points.forEach(point->point.display(g));
	}
}

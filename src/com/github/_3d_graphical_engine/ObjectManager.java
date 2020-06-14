package com.github._3d_graphical_engine;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {

	private ArrayList<Point> points = new ArrayList<>();

	private ArrayList<Polyhedron> polyhedrons = new ArrayList<>();
	
	private Background background = new Background();
	
	//private Line ln;
	
	//private Floor fl = new Floor();
	
	public ObjectManager() {

		//pa.add(new Point(1000,0,0));
		//pa.add(new Point(1000,0,-1));
		
		//ln = new Line(pa.get(0),pa.get(1));
		
		/*Gauss*/
		/*Random r = new Random();
		for(int i = 0; i<5; i++) {
			polyhedrons.add(new Cube(r.nextGaussian(), r.nextGaussian(), r.nextGaussian(), 1));
		}*/
	}

	public void add(Point p) {
		points.add(p);
	}

	public void add(Polyhedron p) {
		polyhedrons.add(p);
	}
	
	public void update(Camera cam, double deltaTime) {
		background.update(cam);
		//fl.update(cam);
		polyhedrons.forEach(cube->cube.update(cam, deltaTime));
		points.forEach(point->point.update(cam));
		
	}
	
	public void display(Graphics g) {
		background.display(g);
		//fl.draw(g);
		polyhedrons.forEach(cube->cube.display(g));
		points.forEach(point->point.display(g));
		//ln.draw(g);
	}
}

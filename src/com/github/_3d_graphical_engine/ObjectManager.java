package com.github._3d_graphical_engine;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	
	private ArrayList<Cube> ca = new ArrayList<Cube>();
	
	private ArrayList<Point> pa = new ArrayList<Point>();
	
	private Background bg = new Background();
	
	//private Line ln;
	
	//private Floor fl = new Floor();
	
	public ObjectManager() {

		//ca.add(new Cube(2,0,1,1));
		//ca.add(new Cube(4,3,3,1));
		
		//pa.add(new Point(1000,0,0));
		//pa.add(new Point(1000,0,-1));
		
		pa.add(new Point(2,2,1));
		//pa.add(new Point(-2,2,1));
		
		//ln = new Line(pa.get(0),pa.get(1));
		
		/*Gauss*/
		Random r = new Random();
		for(int i = 0; i<5; i++) {
			ca.add(new Cube(r.nextGaussian(), r.nextGaussian(), r.nextGaussian(), 1));			
		}
	}
	
	public void update(Camera cam, double deltaTime) {
		bg.update(cam);
		//fl.update(cam);
		ca.forEach(cube->cube.update(cam, deltaTime));
		pa.forEach(point->point.update(cam));	
		
	}
	
	public void display(Graphics g) {
		bg.display(g);
		//fl.draw(g);
		ca.forEach(cube->cube.draw(g));
		pa.forEach(point->point.display(g));
		//ln.draw(g);
	}
}
